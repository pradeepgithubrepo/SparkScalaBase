package org.apache.scala.basics.allaboutscala

import scala.collection.mutable.Map
import scala.collection.mutable.{ListBuffer,ArrayBuffer,Set}

object mutablecollections extends App {

  println("************************************** Map  *************************")
  var amap = Map("a" -> "b", "c" -> "d")
   amap += ("e" -> "f")
  println(amap)
  println(amap("a"))

  println("************************************** List Buffer  *************************")
  val alistbuffer = new ListBuffer[Int]
  alistbuffer += 1
  alistbuffer +=2
  println(alistbuffer)
  alistbuffer(1) = 5
  println(alistbuffer)
//  Refer in immutable page

  println("************************************** Array Buffer  *************************")
  val aarraybuffer = new ArrayBuffer[Int]
  aarraybuffer +=1
  aarraybuffer +=2
  println(aarraybuffer)
  aarraybuffer(1) = 5
  println(aarraybuffer)

  println("************************************** Set  *************************")
  val aset = Set(1,2,3)
  aset += 5
  println(aset)


}
