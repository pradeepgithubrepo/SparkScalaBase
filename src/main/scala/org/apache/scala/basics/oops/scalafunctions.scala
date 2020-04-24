package org.apache.scala.basics.oops

object scalafunctions {
 def main(args : Array[String])={
//   #Recursive Function
  val result = recursivefunc(1,15)
  println(result)

//   Higher Order functions
//   Higher order function is a function that either takes a function as argument or returns a function.
   //   In other words we can say a function which works with function is called higher order function.
higherorderfunc(9,sqrroot)

//   (lambda) Function
//    Anonymous function is a function that has no name but works as a function.
//   It is good to create an anonymous function when you don't want to reuse it later.
   var lamdafuncval = ( a : Int, b : Int ) => { a + b}
   println("Lamda function" + lamdafuncval(120,289))

//   Scala Function Currying
//   it is a technique of transforming a function that takes multiple arguments into a function that takes a single argument.
  println("Currying1" + addvalue(10)(100))
   val addit = addvalue(10)_
   println("Currying2 "+ addit(3))
 }
 def recursivefunc(a: Int, b: Int) : Int = {
   println("A"+a)
   println("B"+b)
  if(b == 0)          // Base condition
  0
    else
    a +recursivefunc(a,b-1)
   a
 }

  def higherorderfunc( a : Int , func:Int => Int) ={
    println("Higher Order functions")
    println(func(a))
  }
  def sqrroot(x: Int ):Int ={x*x}

  def addvalue (a : Int )( b : Int )={
    a+b
  }
 }
