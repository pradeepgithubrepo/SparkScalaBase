package org.apache.spark.basics

import org.apache.spark.utils._

object sparkjoins extends App with utility {
  val sparsses = getsparses

  import sparsses.implicits._

  val payment = sparsses.sparkContext.parallelize(Seq(
    (1, 101, 2500), (2, 102, 1110), (3, 103, 500), (4, 104, 400), (5, 105, 150), (6, 106, 450)
  )).toDF("paymentId", "customerId", "amount")

  println("Payment")
  //  payment.show()
  //  +---------+----------+------+
  //  |paymentId|customerId|amount|
  //  +---------+----------+------+
  //  |        1|       101|  2500|
  //  |        2|       102|  1110|
  //  |        3|       103|   500|
  //  |        4|       104|   400|
  //  |        5|       105|   150|
  //  |        6|       106|   450|
  //  +---------+----------+------+
  val customer = sparsses.sparkContext.parallelize(Seq((101, "Jon"), (102, "Aron"), (103, "Sam"))).toDF("customerId", "name")
  println("customer")
  //  customer.show()
  //  +----------+----+
  //  |customerId|name|
  //  +----------+----+
  //  |       101| Jon|
  //  |       102|Aron|
  //  |       103| Sam|
  //  +----------+----+
  payment.createOrReplaceTempView("payment")
  customer.createOrReplaceTempView("customer")
  //  Inner-Join
  //  val innerjoindf = customer.join(payment, "customerId")
  //  innerjoindf.show()
  //  val innerjoindf1 = sparsses.sql("select p.paymentId,p.customerId,p.amount,c.name from payment p join customer c on p.customerId = c.customerId ")
  //  innerjoindf1.show()
  //  +----------+----+---------+------+
  //  |customerId|name|paymentId|amount|
  //  +----------+----+---------+------+
  //  |       101| Jon|        1|  2500|
  //  |       103| Sam|        3|   500|
  //  |       102|Aron|        2|  1110|
  //  +----------+----+---------+------+

  //  Left join
  //  val leftjoin = customer.join(payment,Seq("customerId"),"left")
  //  leftjoin.show
  //  +----------+----+---------+------+
  //  |customerId|name|paymentId|amount|
  //  +----------+----+---------+------+
  //  |       101| Jon|        1|  2500|
  //  |       103| Sam|        3|   500|
  //  |       102|Aron|        2|  1110|
  //  +----------+----+---------+------+

  //  Right Join
  //  val rightjoin = customer.join(payment,Seq("customerId"),"right")
  //  rightjoin.show()
  //  +----------+----+---------+------+
  //  |customerId|name|paymentId|amount|
  //  +----------+----+---------+------+
  //  |       101| Jon|        1|  2500|
  //  |       103| Sam|        3|   500|
  //  |       102|Aron|        2|  1110|
  //  |       105|null|        5|   150|
  //  |       106|null|        6|   450|
  //  |       104|null|        4|   400|
  //  +----------+----+---------+------+

  //  Full join
  //  val fulljoin = customer.join(payment,Seq("customerId"),"full")
  //  fulljoin.show()

  //  Cross join
  //  Not recommmended returns a full cartesian product

  //  Self join
  val peopleDF = Seq(
    ("andrea", "medellin"),
    ("rodolfo", "medellin"),
    ("abdul", "bangalore")
  ).toDF("first_name", "city")

  val citiesDF = Seq(
    ("medellin", "colombia", 2.5),
    ("bangalore", "india", 12.3)
  ).toDF("city", "country", "population")

  val pepldfres = peopleDF.join(
    citiesDF.hint("broadcast"),
    peopleDF("city") <=> citiesDF("city")
  )
    .drop(citiesDF("city"))
  pepldfres.show()
  val threshold = sparsses.conf.get("spark.sql.autoBroadcastJoinThreshold").toInt
  //  Default threshold - 10 MB
  //  Recently Spark has increased the maximum size for the broadcast table from 2GB to 8GB. Thus, it is not possible to broadcast tables which are greater than 8GB.
  //  spark.conf.set("spark.sql.autoBroadcastJoinThreshold", -1) --> To disable broadcast join
  //  spark.sql.autoBroadcastJoinThreshold=50485760 --> Configure custom setting

  val ppldfsql = sparsses.sql("SELECT /*+  BROADCASTJOIN(payment) */ * from payment p join customer c on p.customerId = c.customerId ")
  ppldfsql.show()
  //  +---------+----------+------+----------+----+
  //  |paymentId|customerId|amount|customerId|name|
  //  +---------+----------+------+----------+----+
  //  |        1|       101|  2500|       101| Jon|
  //  |        3|       103|   500|       103| Sam|
  //  |        2|       102|  1110|       102|Aron|
  //  +---------+----------+------+----------+----+
  //  Explain
  //  == Physical Plan ==
  //    *Project [first_name#33, city#34, country#46, population#47]
  //  +- *BroadcastHashJoin [coalesce(city#34, )], [coalesce(city#45, )], Inner, BuildRight, (city#34 <=> city#45)



  val emp = Seq((1,"Smith",-1,"2018","10","M",3000),
    (2,"Rose",1,"2010","20","M",4000),
    (3,"Williams",1,"2010","10","M",1000),
    (4,"Jones",2,"2005","10","F",2000),
    (5,"Brown",2,"2010","40","",-1),
    (6,"Brown",2,"2010","50","",-1)
  )
  val empColumns = Seq("emp_id","name","superior_emp_id","year_joined","emp_dept_id","gender","salary")
  val empDF = emp.toDF(empColumns:_*)
  empDF.show(false)

  val dept = Seq(("Finance",10),
    ("Marketing",20),
    ("Sales",30),
    ("IT",40),
    ("PT",80)
  )

  val deptColumns = Seq("dept_name","dept_id")
  val deptDF = dept.toDF(deptColumns:_*)
  deptDF.show(false)


  println("Inner join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"inner")
    .show(false)

  println("Outer join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"outer")
    .show(false)
  println("full join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"full")
    .show(false)
  println("fullouter join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"fullouter")
    .show(false)

  println("right join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"right")
    .show(false)
  println("rightouter join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"rightouter")
    .show(false)

  println("left join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"left")
    .show(false)
  println("leftouter join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"leftouter")
    .show(false)

  println("leftanti join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"leftanti")
    .show(false)

  println("leftsemi join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"leftsemi")
    .show(false)

  println("cross join")
  empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"cross")
    .show(false)

  println("Using crossJoin()")
  empDF.crossJoin(deptDF).show(false)
}

case class paymentclass(paymentId: Int, customerId: Int, amount: Int)

case class customerlcass(customerId: Int, name: String)

//object JoinType {
//  def apply(typ: String): JoinType = typ.toLowerCase(Locale.ROOT).replace("_", "") match {
//    case "inner" => Inner
//    case "outer" | "full" | "fullouter" => FullOuter
//    case "leftouter" | "left" => LeftOuter
//    case "rightouter" | "right" => RightOuter
//    case "leftsemi" => LeftSemi
//    case "leftanti" => LeftAnti
//    case "cross" => Cross