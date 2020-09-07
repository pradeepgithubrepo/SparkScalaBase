package org.apache.spark.interview

import org.apache.spark.utils.utility
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import scala.collection.mutable.ListBuffer
import scala.util.control._
import java.sql.Timestamp
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object sapient extends App with utility {
  //  Soln-1
  val aseq = Seq(("Rajesh", 21, "London"), ("Suresh", 28, "California"),
    ("Sam", 26, "Delhi"), ("Rajesh", 26, "Gurgaon"), ("Manish", 26, "Bengaluru"))

  val alistbuffer = new ListBuffer[String]

  for (element <- aseq) {
    var formatedelement = element._1 + ":" + element._2
    if ((!alistbuffer.contains(formatedelement)) || alistbuffer.length == 0) alistbuffer += formatedelement
  }

  println("alistbuffer" + alistbuffer)

  //  Soln-2
  val sparkses = getsparses
  var sessiondf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/interview/ses.csv")
  sessiondf.show(false)
  sessiondf.createOrReplaceTempView("session")
  val interimSessionThreshold=60
  val totalSessionTimeThreshold=120
}
