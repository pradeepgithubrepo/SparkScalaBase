import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val arraysort=ar.sorted
    var paircounter = 0
    arraysort.foreach(x => {
      if(x != arraysort.length){
        if(arraysort(x) == arraysort(x+1)){
          paircounter += 1
        }
      }
    })



    return paircounter
  }

  def main(args: Array[String]) {
    val n = 9
    val ar = Array[Int](10,20,20,10,10,30,50,10,20)
    val result = sockMerchant(n, ar)

  }
}
