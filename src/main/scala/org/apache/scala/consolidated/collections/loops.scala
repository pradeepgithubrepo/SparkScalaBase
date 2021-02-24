//package org.apache.scala.consolidated.collections
//
//object loops{
//    def main(args : Array[String])= {
//      //    Various If Condition option-1
//      var a = 100
//      if (a > 101) {
//        println("greater")
//      }
//      else {
//        println("lesser")
//      }
//      //      Various If Condition option-2
////      println(checkval(a))
//
//      //    Scala Pattern Matching - Switch class
//      //    Setting "B" to any ensures any value can be passed to it
//      val b: Any = "hi0"
//      b match {
//        case 1 => println(1)
//        case "hi" => println("hi")
//        case _ => println("default")
//      }
//
//      //      While Loop
//      while (a < 105) {
//        a = a + 1
//        println(a)
//      }
//
//      //      for loop - 1
//      for (c <- 1 to 10) {
//        println("Loop" + c)
//      }
//      //     for loop -2
//      var d = List(1, 2, 3, 4)
//      for (c <- d) {
//        println("List:" + c)
//      }
//      //    for loop yield keyword-3
//      //      yield keyword which returns a result after completing of loop iterations
//      val result = for (a <- 1 to 5) yield a
//      println("Yield" + result)
//      for (i <- result) {
//        println("result for yield " + i)
//      }
//    }
////      for loop yield keyword-4
////      val fruits = Array("apple", "banana", "orange")
////      var newfruits = for( upd <- fruits) yield upd.toUpperCase
////      println(newfruits)
////      for(a <- newfruits) println(a)
