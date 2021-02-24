package org.apache.scala.consolidated.advanced

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object futures extends App {
  //  Futures are the standard mechanism for writing multithreaded code in Scala.
  //  Whenever we create a new Future operation, Scala spawns a new thread to run that Future’s code, and after completion it executes any provided callbacks.

  def addnum(x : Int,y:Int) : Future[Int]= Future{
    x + y
  }

  addnum(5,10).onComplete{
    case Success(n) => println("Hello"+ n)
    case Failure(e)=> println("Pello"+e)
  }
}


