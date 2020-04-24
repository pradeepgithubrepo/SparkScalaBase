    package org.apache.scala.playground

object stringops {
      def main(args: Array[String]): Unit = {
        val str = " Hello ,Pradeep, Are you learning scala?"
        stringops(str)
      }

      def stringops(str : String ) ={
      println(str.split(","))
        println(str.startsWith("Hello"))
  //      String Interpolation
        val a = "Pradee"
        val b = "Ram"
        println(s"Hello $a how are you $b")

//        String Interpoalation part-2
        val cfloat = 1.2f
        println(f"Train is running @ $cfloat%2.8f ")
      }
    }
