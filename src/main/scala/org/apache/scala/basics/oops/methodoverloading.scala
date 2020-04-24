package org.apache.scala.basics.oops

object methodoverloading {
  def main(args: Array[String]): Unit = {
    println("MethodOverloading"+addvalue(10,20))
    println("MethodOverloading"+addvalue(10,20,30))
  }

  def addvalue(a : Int , b : Int) = {a+b}
  def addvalue(a : Int , b : Int , c : Int) : Int = a+b+c
}
