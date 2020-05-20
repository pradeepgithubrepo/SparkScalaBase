package org.apache.scala.basics.allaboutscala

import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer

object mutablecollections extends App {

  println("************************************** Map  *************************")
  var amap = Map("a" -> "b", "c" -> "d")
   amap += ("e" -> "f")
  println(amap)
  println(amap("a"))

  println("************************************** List Buffer  *************************")
  val alistbuffer = new ListBuffer[Int]
  alistbuffer += 1
//  Refer in immutable page
}
