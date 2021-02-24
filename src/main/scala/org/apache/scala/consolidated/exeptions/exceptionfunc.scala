package org.apache.scala.consolidated.exeptions

import java.io.FileNotFoundException

object exceptionfunc extends App {
  try{
    val tmpval :String = null
    println(tmpval.length)
  }
  catch
    {
      case e : NullPointerException => println("Exceptoion thrown"+e)
    }
  finally {
    println("Will get executed irrespective of pass or fail")
  }

  // Defining our own exceptions
  class myexception extends Exception
  val exception = new myexception
  throw exception
}

class overflowexception extends RuntimeException
class underflowexception extends RuntimeException

object customcalc {
  def main(args: Array[String]): Unit = {
    try{
      val result = add(Int.MaxValue,10)
      if ( result < 0) throw new overflowexception
    }
    catch {
      case e : overflowexception => println("Here is an overflow exception"+e)
      case e : underflowexception => println("Here is an underflow exception"+e)
    }
    finally {
      println("Simply printing")
    }
  }
  def add(x : Int , y :Int ) = x+y
}

object exceptionhandling extends Exception{
  def main(args: Array[String]): Unit = {
    try{
      throw new Exception
    }
    catch {
      case e : RuntimeException => println( "This is an IO Exception"+e)
      case e : FileNotFoundException => println("This is an FNE"+e)
      case e : Exception => println("This is an Excp"+e)
    }
    finally {
      println("should always print this")
    }

  }

}