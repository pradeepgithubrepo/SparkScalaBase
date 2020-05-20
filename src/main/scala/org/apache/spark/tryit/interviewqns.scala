package org.apache.spark.tryit

import javassist.runtime.Desc
import org.apache.spark.utils._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.functions.col

import scala.collection.mutable.ListBuffer

object interviewqns extends App with utility {
  //  val sparkses = getsparses
  //1.   Eliminate Invalid Contact Number using Scala/Python

  //  import sparkses.implicits._
  //
  //  val alistdf = Seq(("100", "XXX", "9999999999"), ("102", "ZZZ", "8ag65jgjv898"), ("103", "AAA", "5555555555")).toDF("num", "name", "phone")
  //
  //  alistdf.printSchema()
  //  val finaldf = alistdf.filter("CAST(phone AS Long) IS NOT null")
  //  val findf = alistdf.filter(row => row.getAs[String]("phone").matches("""\d+"""))
  //  finaldf.printSchema()
  //  finaldf.show()
  //  findf.printSchema()
  //  findf.show()

  //  2.	i = List(1,2,3,4,5,…11,12,13,14,15)
  //
  //  O/P :
  //    (1, 15)
  //  (2,14)
  //  (3,13)
  //  (4,12)

  //  val alist = List(1, 2, 3, 4, 5, 11, 12, 13, 14, 15)
  //  val listlen = alist.length
  //  var loopindex = 0
  //  while (loopindex < listlen / 2) {
  //    println(alist(loopindex), alist(listlen - loopindex-1))
  //    loopindex += 1
  //  }
  //  val numbers: List[Any] = List(10, 20, 30, "dghfd")
  //  println(numbers)

  //  3.   Emp_id	Name 	Manager_id
  //  101	XXXX	-
  //    102	YYY	101
  //  103	YYY	102
  //  104	ZZZ	103

//  val alistdf1 = Seq(("100", "XXX", "9999999999"), ("102", "XXX", "8ag65jgjv898"), ("103", "AAA", "5555555555")).toDF("num", "name", "phone")
  //  val finaldf1 = alistdf1.groupBy($"name").agg((collect_list($"num")) as("agg_num")  ,(collect_list($"phone")).as("agg_phone"))
  //  finaldf1.printSchema()
  //  finaldf1.show

  //  4.  https://stackoverflow.com/questions/24826530/collect-to-a-map-in-hive
  //  val finaldf2 = alistdf1.groupBy($"name").agg((collect_list($"num")) as ("agg_num"))
  //  finaldf2.createOrReplaceTempView("alisttabl")
  //  val resdf = sparkses.sql("select Map(name, agg_num) as agg_map from alisttabl")
  //  resdf.printSchema()
  //  resdf.show(false)

  //  val alistds1 = Seq(("100", "XXX", "9999999999"), ("102", "XXX", "8ag65jgjv898"), ("103", "AAA", "5555555555")).toDF("num", "name", "phone").as[alistds]
  //  val alistds2 = alistds1.groupBy($"name").agg((collect_list($"num")) as ("agg_num"))
  //  alistds2.printSchema()
  //  alistds2.show()
  //
  //  case class alistds(num : String, name : String, phone : String)

  //  Permutations in scala.
  //  val blist = List("A","B","C","D","E")
  //  val clist  = blist.combinations(2).toList
  //  var dlist = new ListBuffer[String]()
  ////  println(clist)
  //  clist.foreach(x => {
  //    val p = x.mkString("")
  //    dlist +=p
  //  })
  //
  //  println(dlist.toList)


  //  val existingcollistdf = alistdf1
  //    .withColumn("address",lit("23534"))
  //    .withColumn("zipcode",lit("4546757"))
  //
  //  existingcollistdf.printSchema()
  //  val acolllist = alistdf1.columns.toList
  //  val newcollist = List("address","zipcode")
  //  val colpos = 2
  //  var increment = 0
  //  var alistbuffer = new ListBuffer[String]()
  //  acolllist.foreach(x =>
  //  {
  //    alistbuffer += x
  //    if(increment == colpos-1){
  //      alistbuffer = alistbuffer ++ newcollist
  //    }
  //    increment +=1
  //  })
  //  println(alistbuffer)
  //
  //  val newlistdf = existingcollistdf.selectExpr(alistbuffer.toList :_*)
  //  newlistdf.printSchema()
  //  newlistdf.show()

  //  val salesdf = sparkses.read.option("header", true).option("inferSchema", true).csv("/Users/pradeepp/Desktop/AzureProcesingframework/sales.csv")
  //    salesdf.createOrReplaceTempView("salestable")
  //    val salesres = sparkses.sql("select CITY,BRANCH,AMOUNT from (select * , DENSE_RANK() OVER(PARTITION BY CITY ORDER BY AMOUNT DESC) as PowerRank from salestable) where PowerRank <=2")
  //    salesres.printSchema()
  //    salesres.show()
  //  val windowSpec = Window.partitionBy("CITY").orderBy(desc("AMOUNT"))
  //  val salresdf = salesdf.withColumn("powerrank", dense_rank().over(windowSpec))
  //    .filter($"powerrank" <= 2)
  //  salresdf.printSchema()
  //  salresdf.show()

//  val str1 = "abccba"
//  val strlength = str1.length
//  var indexpos = 0
//  var alistbuffer = new ListBuffer[Char]
//  while (indexpos <= strlength-1){
//    val eachchar = str1.charAt(indexpos)
//     if (alistbuffer.contains(eachchar)){
//   println(s"$eachchar is the first reapeating char in $str1")
//     } else
//     {
//       alistbuffer += eachchar
//     }
//    indexpos +=1
//  }

  val tmap = Map(("Eng" -> 50),("Maths") ->48)
  val updmap = tmap.map(x => (x._1,x._2 + 10))
  println(updmap)
}


