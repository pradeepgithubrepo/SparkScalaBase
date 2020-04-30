package org.apache.spark.tryit

import org.apache.spark.sql.Row
import org.apache.spark.utils._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.types.{ArrayType, IntegerType, MapType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._

object driver extends App with utility {
  val sparsses = getsparses
  val paymentrdd = sparsses.sparkContext.parallelize(Seq(
    (1, 101, 2500), (2, 102, 1110), (3, 103, 500), (4, 104, 400), (5, 105, 150), (6, 106, 450)
  ), 6)

  //  Partitions
  println("Default num of parit:" + sparsses.sparkContext.defaultMinPartitions)
  println("Totalparitions : " + paymentrdd.getNumPartitions)
  paymentrdd.repartition(10)
  println("repartition : " + paymentrdd.getNumPartitions)
  paymentrdd.coalesce(2)
  println("Coalesce : " + paymentrdd.getNumPartitions)

  import sparsses.implicits._

  val paymentdf = paymentrdd.toDF("paymentId", "customerId", "amount")
  paymentdf.persist(StorageLevel.DISK_ONLY)

  val bcList = sparsses.sparkContext.broadcast(List("abc", "def", "ghi"))

  val paymentrdd1 = sparsses.sparkContext.parallelize(Seq(
    ("ghi", 101, 2500), ("2", 102, 1110), ("def", 103, 500)
  ), 6)
  val updpaymentrdd = paymentrdd1.map({ x =>
    if (bcList.value.contains(x._1))
      x
  })
  updpaymentrdd.collect.foreach(println)

  val rawdata = Seq(Row(Row("James ", "", "Smith"), "36636", "M", "3000"),
    Row(Row("Michael ", "Rose", ""), "40288", "M", "4000"),
    Row(Row("Robert ", "", "Williams"), "42114", "M", "4000"),
    Row(Row("Maria ", "Anne", "Jones"), "39192", "F", "4000"),
    Row(Row("Jen", "Mary", "Brown"), "", "F", "-1")
  )

  val schema = new StructType()
    .add("name", new StructType()
      .add("firstname", StringType)
      .add("middlename", StringType)
      .add("lastname", StringType))
    .add("dob", StringType)
    .add("gender", StringType)
    .add("salary", StringType)


  val datadf = sparsses.createDataFrame(sparsses.sparkContext.parallelize(rawdata), schema)
  val newdatadf = datadf.withColumn("coronoalary", col("salary").cast("Integer") * 0.9)
  newdatadf.show()

  val pivotdata = Seq(("Banana", 1000, "USA"), ("Carrots", 1500, "USA"), ("Beans", 1600, "USA"),
    ("Orange", 2000, "USA"), ("Orange", 2000, "USA"), ("Banana", 400, "China"),
    ("Carrots", 1200, "China"), ("Beans", 1500, "China"), ("Orange", 4000, "China"),
    ("Banana", 2000, "Canada"), ("Carrots", 2000, "Canada"), ("Beans", 2000, "Mexico"))

  import sparsses.implicits._

  val df1rdd = sparsses.sparkContext.parallelize(pivotdata)
  val df1 = df1rdd.toDF("Product", "Amount", "Country")
  df1.show()

  val pivotdf = df1.groupBy(col("Product")).pivot("Country").sum("Amount")

  pivotdf.show()

  val structureData = Seq(
    Row(Row("James", "", "Smith"), "36636", "M", 3100),
    Row(Row("Michael", "Rose", ""), "40288", "M", 4300),
    Row(Row("Robert", "", "Williams"), "42114", "M", 1400),
    Row(Row("Maria", "Anne", "Jones"), "39192", "F", 5500),
    Row(Row("Jen", "Mary", "Brown"), "", "F", -1)
  )

  val innerschema = StructType(List(
    StructField("fname", StringType, true),
    StructField("mname", StringType, true),
    StructField("lname", StringType, true)
  ))
  val simpleSchema = StructType(List(
    StructField("name", innerschema, false),
    StructField("Pincode", StringType, true),
    StructField("Gender", StringType, true),
    StructField("Amount", IntegerType, true)
  ))

  val newdf = sparsses.createDataFrame(sparsses.sparkContext.parallelize(structureData), simpleSchema)
  newdf.printSchema()
  newdf.collect().foreach(println)

//  println("****Explode DF*****")
//  val explodeddf = newdf.select(explode(col("name")), col("Pincode"), col("Gender"), col("Amount"))
//  explodeddf.printSchema()
//  explodeddf.show()
}

