package org.apache.spark.basics

import org.apache.spark.basics.sparkjoins.sparsses
import org.apache.spark.sql.{DataFrame, Dataset}
import org.apache.spark.utils._
import org.apache.spark.sql.SparkSession

object dfoperations extends App with utility {
  val sparsses = getsparses

  import sparsses.implicits._

  val payment = sparsses.sparkContext.parallelize(Seq(
    (1, 101, 2500), (2, 102, 1110), (3, 103, 500), (4, 104, 400), (5, 105, 150), (6, 106, 450)
  )).toDF("paymentId", "customerId", "amount").as[paymentclass]
  //

  iteratingfunc(payment, sparsses)

  def iteratingfunc(paymentds: Dataset[paymentclass], sparkses: SparkSession) = {
    payment.foreach(x => println(s"Values are ${x.amount} , ${x.customerId} "))
    val jsondf = sparsses.read.format("json").load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/sample.json")
    println(jsondf.count())
    val paymentdf = paymentds.toDF()
    val peopleArray = paymentdf.collect.map(r => Map(paymentdf.columns.zip(r.toSeq): _*))
    peopleArray.foreach(x => println(x))

  }
}


