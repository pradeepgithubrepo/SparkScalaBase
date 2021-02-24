package org.apache.scala.consolidated.advanced

object closures {

  def main(args: Array[String]) = {
    //    Scala Closures are functions which uses one or more free variables and the return value of this function
    //    is dependent of these variable.

    //    The free variables are defined outside of the Closure Function and is not included as a parameter of this function.
    //    So the difference between a closure function and a normal function is the free variable.
    //    A free variable is any kind of variable which is not defined within the function and not passed as the parameter of the function.
    val freevar = 10;
    def asum(a: Int) = {
      a + freevar
    }

    println(asum(10))

  }

}
