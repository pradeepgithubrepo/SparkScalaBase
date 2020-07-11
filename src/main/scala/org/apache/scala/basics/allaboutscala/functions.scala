package org.apache.scala.basics.allaboutscala

import scala.annotation.tailrec

object functions extends App {

  println("************************************** Functions *************************")

  //  Function with no return type
  def funtionwithnoreturn = " Hello"

  println(funtionwithnoreturn)

  //  Func with default values
  defaultvaluefunc("pradeep")

  def defaultvaluefunc(name: String, age: Int = 30) = {
    println(s"I am $name and age $age")
  }

  //  Dynamic function with option paramter and Returning a Options value
  val result = funtionwithoption("Pradeep")
  println(result.getOrElse("Zoomba"))

  def funtionwithoption(name: String, age: Option[Int] = None): Option[Any] = {

    val computedage = age match {
      case Some(x) => x + 20
      case None => null
    }
    println("Computed Age " + computedage)
    Option(computedage)
  }

  println("************************************** Implicit Parms *************************")
  //  https://stackoverflow.com/a/61722482/5773418

  println("************************************** Polymorphic functions *************************")
  polymorphifunc(10)
  polymorphifunc(10.2)

  def polymorphifunc[T](disc: T) = {
    disc match {
      case p: Int => println("That's an integer")
      case p: Double => println("That's a double")
      case _ => println("That's empty")
    }
  }

  println("************************************** Currying *************************")
//Transforms a function into a chain functions
  def formatter(x: String)(c: Double) = x.format(c)

  val threepie = formatter("%3.2f")(_)
  val tenpie = formatter("%10.8f")(_)

  println("Threepie", threepie(Math.PI))
  println("tenpie", tenpie(Math.PI))

  println("************************************** HOF *************************")
  println("HOF " + hoffunc(10, sqrroot))

  def hoffunc(x: Int, func: Int => Int) = {
    func(x)
  }

  def sqrroot(x: Int) = x * x

  println("************************************** cbn cbv *************************")
  cbn(System.nanoTime())
  cbv(System.nanoTime())

  def cbv(x: Long) = {
    println("Time 1:" + x)
    println("Time 2:" + x)
  }

  def cbn(x: => Long) = {
    println("Time 1:" + x)
    println("Time 2:" + x)
  }

  println("************************************** Lamda Function *************************")
  val addnumer = (a: Int, b: Int) => {
    a + b
  }
  println("Lamda" + addnumer(3, 4))

  println("************************************** Recursive Function *************************")
  //  /          5 -> 5*4*3*2*1
  //  Recursive factorial value of X :3
  //  Recursive factorial value of X :2
  //  Recursive factorial value of X :1
  //  Computed value of fac : 1 is 1
  //  Computed value of fac : 2 is 2
  //  Computed value of fac : 3 is 6
  //  6
  println("Rec func Factorial" + recfunc(5))

  def recfunc(x: Int): Int = {
    if (x == 0) 1
    else
      x * recfunc(x - 1)
  }

  println("Tailrec Func "+ tailrec(6))
  def tailrec(x: Int) = {
    @tailrec
    def helperfunc(y: Int, acc: Int): Int = {
      if ( y <=1) acc
      else
        helperfunc(y-1,y*acc)
    }
    helperfunc(x,1)
  }


}

