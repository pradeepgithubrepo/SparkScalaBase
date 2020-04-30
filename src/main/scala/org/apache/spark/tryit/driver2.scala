package org.apache.spark.tryit

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.Window
import org.apache.spark.utils._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.types.{ArrayType, IntegerType, MapType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._

object driver2 extends App with utility {
  val sparkses = getsparses
  val simpleData = Seq(("James", "Sales", "NY", 90000, 34, 10000),
    ("Michael", "Sales", "NY", 86000, 56, 20000),
    ("Robert", "Sales", "CA", 81000, 30, 23000),
    ("Maria", "Finance", "CA", 90000, 24, 23000),
    ("Raman", "Finance", "CA", 99000, 40, 24000),
    ("Scott", "Finance", "NY", 83000, 36, 19000),
    ("Jen", "Finance", "NY", 79000, 53, 15000),
    ("Jeff", "Marketing", "CA", 80000, 25, 18000),
    ("Kumar", "Marketing", "NY", 91000, 50, 21000)
  )

  import sparkses.implicits._

  val df = simpleData.toDF("employee_name", "department", "state", "salary", "age", "bonus")
  df.show()

  val aggdf = df.groupBy("department").agg(
    sum("salary").as("agg_sal"),
    avg("salary").as("avg_sal"),
    max("bonus").as("Max_bonus")
  )

  aggdf.sort(col("agg_sal").desc)
  aggdf.show()

  //  Union

  import sparkses.implicits._

  val simpleData1 = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)
  )
  val df1 = simpleData1.toDF("employee_name", "department", "salary")
  df1.show()

  val distinctdf = df1.distinct()
  distinctdf.show()
  val dropdupdf = df1.dropDuplicates("department")
  dropdupdf.show()

  //  Explode
  val arrayStructureData = Seq(
    Row("James,,Smith", List("Java", "Scala", "C++"), List("Spark", "Java"), "OH", "CA"),
    Row("Michael,Rose,", List("Spark", "Java", "C++"), List("Spark", "Java"), "NY", "NJ"),
    Row("Robert,,Williams", List("CSharp", "VB"), List("Spark", "Python"), "UT", "NV")
  )

  val arrayStructureSchema = new StructType()
    .add("name", StringType)
    .add("languagesAtSchool", ArrayType(StringType))
    .add("languagesAtWork", ArrayType(StringType))
    .add("currentState", StringType)
    .add("previousState", StringType)

  val df2 = sparkses.createDataFrame(
    sparkses.sparkContext.parallelize(arrayStructureData), arrayStructureSchema)
  df2.printSchema()
  df2.show()

  println("***Explode **")
  val newdf = df2.select(col("name"), explode(col("languagesAtSchool")), col("currentState"))
  newdf.printSchema()
  newdf.show()

  val windowspec = Window.partitionBy("department").orderBy("salary")
  val partiondf = df.withColumn("row_number",row_number().over(windowspec))
  partiondf.printSchema()
  partiondf.show()
}
