package org.apache.scala.tryit

import org.apache.spark.sql._
import org.apache.spark.sql.types.{ArrayType, IntegerType, MapType, StringType, StructType}
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._

import scala.io._
import org.apache.spark.utils.utilclass

object driver5 extends utilclass {
  def main(args: Array[String]) = {

    val spark = SparkSession.builder().master("local").appName("pradeep").getOrCreate()
    import spark.implicits._

    val simpleData = Seq(("James", "Sales", 3000),
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

 val rdd = spark.sparkContext.parallelize(simpleData)
    val newrdd = rdd.map(x => (x._1,x._3))
    newrdd.foreach(println)


  }
}
