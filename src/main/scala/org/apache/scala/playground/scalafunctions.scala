package org.apache.scala.playground

import scala.annotation.tailrec

        object scalafunctions {
          def main(args: Array[String]): Unit = {

        println(arecursivefunc("hi",4))
            println("Fibonachi series result: "+fibonachiseries(3))
            println("Factorial"+factorial(10))
            println("Tail recursion"+anotherfactorial(2000))

            val lamdaval = (a : Int , b : Int ) => a + b
            println("Lamda functon value "+ lamdaval(100,200))
            println("HOF"+hof(9,sqrroot))
            //    https://www.james-willett.com/scala-higher-order-functions/
            println("Currying fuc"+curryunc(10)(5))
            val currit = curryunc(10)_
            println("Currying fuc2 "+ currit(3))

            //    println(recursivefunc(5))
            //    println(recursivefactorial(3))

          }

          def hof(x : Int , func : Int => Int ) : Int ={
            func(x)
          }

          def sqrroot ( x : Int ) = x * x

          def curryunc(x : Int )(y : Int) : Int = x+y
          //  fibonacci
          //  1 1 2 3  5
          //  Value of X : 5 My processing values wold be3&&4
          //  Value of X : 3 My processing values wold be1&&2
          //  Value of recursive func 3 is 2
          //  Value of X : 4 My processing values wold be2&&3
          //  Value of X : 3 My processing values wold be1&&2
          //  Value of recursive func 3 is 2
          //  Value of recursive func 4 is 3
          //  Value of recursive func 5 is 5
          //  5
          def recursivefunc(x: Int): Int = {
            if (x <= 2) 1
            else {
              println(s"Value of X : $x My processing values wold be" + (x - 2) + "&&" + (x - 1))
              var result = recursivefunc(x - 2) + recursivefunc(x - 1)
              println(s"Value of recursive func $x is $result")
              result
            }

          }

//          5 -> 5*4*3*2*1
//  Recursive factorial value of X :3
//  Recursive factorial value of X :2
//  Recursive factorial value of X :1
//  Computed value of fac : 1 is 1
//  Computed value of fac : 2 is 2
//  Computed value of fac : 3 is 6
//  6
def recursivefactorial(x: Int): Int = {
  if (x == 0) 1
  else {
    println(s"Recursive factorial value of X :$x")
    var result = x * recursivefactorial(x - 1)
    println(s"Computed value of fac : $x is $result")

    result
  }

}


      //    Recursive Function
          def arecursivefunc(a : String , i : Int ) : String = {
            if (i == 1) a
            else
              a +" "+ arecursivefunc(a,i-1)
          }
          def fibonachiseries (a : Int ) : Int = {
            if ( a <= 2 ) 1
            else
              fibonachiseries(a-1)+ fibonachiseries(a-2)
          }
          def factorial(n : Int) : Int = {
            if (n ==0) 1
            else
              n * factorial(n-1)
          }
    //      Recursive stack overflow error to avoid use
    //      Tail Recursive fucntion
    //      Use recursive function as the last call
          def anotherfactorial(n : Int) = {
      @tailrec
            def facthelper(x : Int , accum : BigInt) : BigInt = {
              if (x <= 1 )accum
              else
                facthelper(x-1,x * accum)
            }
      facthelper(n,1)
          }



        }
