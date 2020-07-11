package org.apache.spark.tryit

import scala.collection.mutable.ListBuffer

object prime extends App {
  val limit = 100
  var i = 2
  var flag = 0
  var alistbuffer = new ListBuffer[Int]()
  alistbuffer += 2

  for (i <- 2 to limit) {
    flag = 0
    for (j <- 2 to 10) {
      if (i != j && i % j == 0) {
        flag = 1
      }
    }
    if (flag == 1) {
      alistbuffer += i
    }
  }

  println(alistbuffer)
}
