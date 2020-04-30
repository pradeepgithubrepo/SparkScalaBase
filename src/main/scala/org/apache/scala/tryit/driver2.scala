package org.apache.scala.tryit

import scala.util.matching.Regex
import scala.annotation.tailrec

object driver2 extends App {
  var a = 5
  a += 1
  println(a)

  //  cbv(System.nanoTime())
  //  cbn(System.nanoTime())
  //
  //  //  Recursive
  //  println("Factorails " + factorail(5))
  //  println("Fibo" + fibonacci(5))
  //  println("Fibotail"+fibotail(5))

  val alist = List("123", "345", "67u", 45)

  val lst = List("Hello", "1World", 23, "Century", 4, "Best")


  val blist = alist.filter({
    case num: Int => true
    case _ => false
  })

  val mappy = (x : Int , y : Int) => x + y
  println("Lamda "+mappy(3,5))
  println(blist)

  hof(9,sqrroot)

  val standardformat = formatter("%3.5f")(_)
  val maxformater = formatter("%10.2f")(_)
  println("Currying"+standardformat(Math.PI))
  println("Currying2"+maxformater(Math.PI))
  //  val blist = alist.map(x => x.contains("[a-z]".r))
  //  blist.foreach(println)
  val numregex: Regex = "[0-9]".r
  val phonenum = "56345543unar"
  numregex.findFirstMatchIn(phonenum) match {
    case Some(_) => println()
  }




  def cbv(systime: Long) = {
    println(systime)
    println(systime)
  }

  def sqrroot(x : Int) = x*x
  def hof(x:Int,func : Int => Int)= {
    println("HOF"+func(x))
  }

  def formatter(x:String)(y:Double)=x.format(y)
  def cbn(systime: => Long): Unit = {
    println(systime)
    println(systime)
  }

  def factorail(x: Int): Int = {
    if (x <= 2) 1
    else
      x + factorail(x - 1)
  }

  def fibonacci(x: Int): Int = {
    if (x <= 1) 1
    else
      fibonacci(x - 2) + fibonacci(x - 1)
  }

  def fibotail(x: Int): BigInt = {
    @tailrec
    def fibohelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 2) 1
      else
        fibohelper(x - 1, x + acc)
    }

    fibohelper(x, 1)
  }

  def patternMatching(x: String) = {
    x match {
      case "hello" => println("hello")
      case _ => println("def")
    }
  }
}
