package org.apache.scala.tryit

object driver4 {
  def main(args: Array[String]) = {
   println(optionvalue(Option(20)).getOrElse("No value"))
 println(hof(10,sqroot))
  }
  def optionvalue(age : Option[Int]) : Option[Int] ={
    val updatedage = age.getOrElse(0) + 10
    Option(updatedage)
  }

  def hof( x : Int , func : Int => Int ) ={
    func(10)
  }
  def sqroot (x : Int) = x*x
}
