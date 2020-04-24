package org.apache.scala.playground

object cbvvscbn {
//  Time seconds should always be Long data type
//  => in calledbyName
 def main( args : Array[String]) = {

   callByValue(System.nanoTime())
   callByName(System.nanoTime())
  println("Default values"+defaultfunctionval(200))
 }
//  Here value is already calculated and thus computed value is passed on to the funcitons
  def callByValue(x : Long)={
    println("Val1"+x)
    println("Val2"+x)
  }
//  Here Expression is sent to each call println("Val1"+System.nanoTime())
  def callByName(x : => Long)={
    println("Val1"+x)
    println("Val2"+x)
  }

//  Default values to function
  def defaultfunctionval(x:Int , y : Int =100)={
    x+y
  }
}
