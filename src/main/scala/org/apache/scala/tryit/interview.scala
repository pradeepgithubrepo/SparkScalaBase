package org.apache.scala.tryit
import org.apache.spark.utils.utility
object interview extends App with utility {
  //val sparkses = getsparses
  //  val veh = List("cyc","car","Bike")
  //  val vehrdd = sparkses.sparkContext.parallelize(veh)
  //  val vehrdd1 = vehrdd.filter{(l : String ) => l.take(1) != "f"}
  //  vehrdd1.collect().foreach(println)
  var aarray: Array[Int] = Array(4, 6, 2, 3)
  aarray = aarray.sorted
  aarray.foreach(println)


  val donuts: List[String] = List("Plain Donut 1", "Plain Donut 2", "Strawberry Donut", "Plain Donut 3", "Glazed Donut")
  println(donuts.sorted)

}
