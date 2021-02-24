package org.apache.scala.consolidated.functions

object higherorderfunc {
  def main(args : Array[String]): Unit ={

//    A function is called Higher Order Function if it contains other functions as a parameter
//    https://www.james-willett.com/scala-higher-order-functions/

    def findvalue(func: Int => Int , value : Int) ={
      println(func(value))
    }
    def squareroot(x : Int) = x*x

    findvalue(squareroot,10)
  }
}
