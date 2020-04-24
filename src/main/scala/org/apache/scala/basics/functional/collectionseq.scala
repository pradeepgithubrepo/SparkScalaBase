package org.apache.scala.basics.functional

import scala.util.Random

object collectionseq extends App {
  //  List , Array and vector are from Seq
  val aseq = Seq(1, 3, 3, 2, 1)
  println(aseq)
  // List(1, 3, 3, 2, 1) --> It will be printed as list only

  //Ranges -It is a sequence of Int
  val arange: Seq[Int] = 1 to 5
  println("Range" + arange)

  // List
  //  Maintains order of elemetns and follow LIFO
  //  Can have dups
  val mlist = List(1, 2, 3, 4)
  val prepend = 0 +: mlist :+ 5
  println("Append & Prepend" + prepend)

  println(prepend.mkString("|"))

  //Array - Same as simple Java array
  // They are mutable
  // Indexing is fast
  // interoprable with Java Arrays

  val nums = Array(1, 2, 3, 4)
  val emptydim = Array.ofDim[Int](5)
  emptydim.foreach(println)

  // array and seq - they are connected
  val numseq: Seq[Int] = nums //Implicit Conversions
  println(numseq)


  // Vectors
  // fast element addition
  // good performance for very large size -
//  It provides random access of elements. It is good for large collection of elements.
  val vectorseq: Vector[Int] = Vector(1, 2, 3, 4)
  println(vectorseq)

  //  SET
  //    It is used to store unique elements in the set. It does not maintain any order for storing elements.
  val setval: Set[Int] = Set(1, 2, 3, 5, 3)
  println("setval" + setval)
}
