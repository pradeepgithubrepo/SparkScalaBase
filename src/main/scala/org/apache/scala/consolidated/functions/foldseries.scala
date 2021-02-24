package org.apache.scala.consolidated.functions

object foldseries  {
 def main(args : Array[String])={

   val alist = List(1,2,2,4);
   val result = alist.fold(0) {
     (z, i) => z +i
   }
   println("Fold result "+ result)
   //   foldLeft traverses the list from head to the last element.
   //   foldRight on the other hand traverses it from the last element to head

   val blist = List(1,2,3)
   val foldleft = blist.foldLeft(List.empty[Int]) { (acc, ele) => ele :: acc }
   println(foldleft)
   val foldright = blist.foldRight(List.empty[Int]){(acc,ele)=> acc :: ele}
   println(foldright)
 }
}
