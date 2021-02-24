package org.apache.spark.hcscpoc

import org.apache.spark.utils._

object driver extends utility {
  def main(args: Array[String]) = {
    val spark = getsparses
    //   val sourcedf = spark.read.format("com.databricks.spark.xml").option("rowTag", "ClinicalDocument").load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/hcsc/hl.xml")
    //   sourcedf.show(false)
    //   sourcedf.printSchema()
    var sourcedf = spark.read.format("csv").option("header", "true").option("inferSchema", "true").load("/Users/pradeeppmacbook/Desktop/AzureProcesingframework/SparkScalaBase/resources/interview/testcases.csv")
    sourcedf.show(false)
    sourcedf.printSchema()
    sourcedf = sourcedf.filter("World > 2")
    sourcedf.show(false)
    sourcedf.printSchema()
  }
}
