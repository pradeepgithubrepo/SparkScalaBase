package org.apache.scala.tryit

import scala.annotation.tailrec
import scala.concurrent.Future
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object driver7 {
  def main(args: Array[String]) = {
    val donuts = List("Plain Donut 1", "Plain Donut 2", "Strawberry Donut", "Plain Donut 3", "Glazed Donut")
    println("List " + donuts.filter(_.endsWith("ut")))
    val donutfolder = donuts.fold("")((acc, s) => acc + " Hello" + s)
    println(donutfolder)

    val donuts1: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
    val prices: Seq[Double] = Seq(1.50, 2.0, 2.50)

    val donitzip = donuts1.zip(prices)
    println(donitzip)
    println(donitzip.unzip._2)
    println(donitzip.zipWithIndex)

    val alist = List(1, 2, 3, 5)
    val foldval = alist.fold(0)((acc, s) => {
      acc + s
    })
    println(foldval)

    //    hof
    println("HOF" + hof(5, sqrroor));

    //    currying
 println(threepie(Math.PI))
    println(twopie(Math.PI))
    cbn(System.nanoTime())
    cdv(System.nanoTime())
    println("Fibbo"+fibbo(10))
    println("fibbotail",fibbotail(10))
  }

  def hof(x: Int, func: Int => Int) = {
    func(x)
  }

  def sqrroor(x: Int) = x * x

  def formatter(x: String)(f:Double) = x.format(f)
  val twopie = formatter("%3.2f")(_)
  val threepie = formatter("%8.2f")(_)

  def cbn(x : => Long): Unit ={
    println(x)
    println(x)
  }

  def cdv(x : Long) ={
    println(x)
    println(x)
  }

  val lamda = (x : Int , y : Int ) => x + y
  println(lamda(5,10))

  def fibbo(x : Int) : Int = {
    if(x <=2 )  1
    else
     fibbo(x-1) + fibbo(x-2)
  }

  def fibbotail(x : Int) ={
    @tailrec
    def helperfunc(a : Int ,acc : Int) : Int = {
      if( a <= 1) acc
      else {
        helperfunc(a - 1, a + acc)
      }
    }
    helperfunc(x,0)
  }

  val captials = Map("germany" -> "Belin","Japan" -> null)
  println("Cpatials 1  :" + option_refactor(Option(captials("germany"))).length)
  println("Captials 2 :"+option_refactor(Option(captials("Japan"))).length)
  def option_refactor(x : Option[String])  = {
    x match {
      case Some(y) => y
      case None => ""
    }
  }

//  println("Futures : " + addum(4,5))
  def addum(x: Int , y : Int ) : Future[Int] = Future{
    x + y
  }

  addum(5,4).onComplete{
    case success => println("This is good")
    case failure => println("This is Bad")
  }

}


//class processing extends Exception {
//  def processing(): Unit ={
//    try{
//      if (10 > 5) throw  Exception
//    }catch {
//      case e : RuntimeException => println("This is a runtime Execption"+e)
//      case _ => println("This is a overall exception")
//    }finally {
//      println("This is hitting finally")
//    }
//  }
//
//}

trait river{
  def rivermethod(a : Int , b : Int) = println(a + b)
  def absmethod(a : Int)
}

class sea

class ocean
class lake extends sea with river {
  override def absmethod(a: Int): Unit = println("This is a abs method")
}

object core {
  def main(args : Array[String])={
    val obj  = new lake()
    obj.rivermethod(1,2)
    obj.absmethod(3)
  }
}
