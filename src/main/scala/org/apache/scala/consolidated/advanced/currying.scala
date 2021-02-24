package org.apache.scala.consolidated.advanced

object currying {
  def main(args: Array[String]) = {
    println("**************************************Currying*************************")
    //   Scala Function Currying
    //   it is a technique of transforming a function that takes multiple arguments into a function that takes a single argument.

    def formatter(x: String)(y: Double) = x.format(y)

    val sevenpie = formatter("%7.2f")(_)
    val threepie = formatter("%3.2f")(_)

    System.out.println(sevenpie(Math.PI))
    System.out.println(threepie(Math.PI))
  }
}
