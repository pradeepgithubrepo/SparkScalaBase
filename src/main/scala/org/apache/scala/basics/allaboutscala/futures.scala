package org.apache.scala.basics.allaboutscala
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object futures extends App {
  //  Futures are the standard mechanism for writing multithreaded code in Scala.
  //  Whenever we create a new Future operation, Scala spawns a new thread to run that Future’s code, and after completion it executes any provided callbacks.

  def addnum(x : Int,y:Int) : Future[Int]= Future{
    x + y
  }

  addnum(5,10).onComplete{
    case Success(n) => println(n)
    case Failure(e)=> println(e)
  }
}
