package org.apache.spark.basics

import org.apache.spark.utils._

object driver extends App with utility  {

  val sparkses = getsparses
  println(sparkses)
  val sourcedf = sparkses.read.format("csv").option("inferSchema", "true").option("header", "true").load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/total_cases.csv")
  println(sourcedf.count())
  sourcedf.persist()
  val sourcerdd = sourcedf.rdd
  val updsrcrdd = sourcerdd.map(x => x.mkString(","))
  updsrcrdd.foreach(println)
  val tmprdd = sparkses.sparkContext.parallelize(Seq(1,2,3,4))
  import sparkses.implicits._
  val tmpdf = tmprdd.toDF("rollno")
  tmpdf.createOrReplaceTempView("tmptable")
  val resdf = sparkses.sql("select * from tmptable where rollno > 1")
  resdf.show

  val res1 = resdf.groupBy("rollno").count()
  res1.show()
 val res1ds = res1.as[dataclass]
  val res2ds = res1ds.filter(_.rollno > 3)
  res2ds.show()

//  val res1df = sparkses.sql("select rollno,count(*) from restbl groupBy rollno")
//  resdf.createOrReplaceTempView("restbl")
//  res1df.show

  val userData = sparkses.createDataFrame(Seq(
    (1, "Chandler", "Pasadena", "US"),
    (2, "Monica", "New york", "USa"),
    (3, "Phoebe", "Suny", "USA"),
    (4, "Rachael", "St louis", "United states of America"),
    (5, "Joey", "LA", "Ussaa"),
    (6, "Ross", "Detroit", "United states")
  )).toDF("id", "name", "city", "country")

def cleancountry = (country : String)=>{
  val countrylist = List("US",
  "USa",
  "USA",
  "United states",
  "United states of America")
  if (countrylist.contains(country)) "USA" else "Don't Know that"
}
  sparkses.udf.register("cleancountryudf",cleancountry)
  userData.createOrReplaceTempView("userdata")
  val userdatadf = sparkses.sql("select * , cleancountryudf(country) from userdata")
  userdatadf.show
}
case class dataclass ( rollno : Int , count : BigInt)

