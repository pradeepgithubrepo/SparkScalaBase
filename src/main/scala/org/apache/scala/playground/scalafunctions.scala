        package org.apache.scala.playground

import scala.annotation.tailrec

        object scalafunctions {
          def main(args: Array[String]): Unit = {

        println(arecursivefunc("hi",4))
            println("Fibonachi series result: "+fibonachiseries(3))
            println("Factorial"+factorial(10))
            println("Tail recursion"+anotherfactorial(2000))
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
