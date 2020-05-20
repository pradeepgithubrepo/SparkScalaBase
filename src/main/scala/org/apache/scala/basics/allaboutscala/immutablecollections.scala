package org.apache.scala.basics.allaboutscala

import scala.collection.immutable.ListSet
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object immutablecollections extends App {

  println("************************************** List  *************************")
  val alist = List(1, 2, 3, 4, 5)
  val blist = List(5, 6, 68, 7)
  var clist = alist ::: blist
  println(clist)
  println("Remove list" + clist.filter(_ != 4))
  //  List(1, 2, 3, 4, 5, 5, 6, 68, 7)
  //  List is designed to be immutable hence do not make it mutable
  //  Note that this operation has a complexity of O(n)-O(N) means in proportion to the number of items.. If you need this operation frequently, or for long lists, consider using another data type (e.g. a ListBuffer).
  var alistbuffer = new ListBuffer[Int]
  alistbuffer = alistbuffer ++ clist
  println(alistbuffer)
  //  Maintains order of elemetns and follow LIFO
  //  Can have dups
  val mlist = List(1, 2, 3, 4)
  val prepend = 0 +: mlist :+ 5
  println("Append & Prepend" + prepend)
  println(prepend.mkString("|"))

  println("**************************************List set  *************************")
  //  No immutable data
  //  Stores in Reverse order , LIFO
  val alistset = ListSet(1, 2, 4, 4, 5)
  println(alistset)

  println("**************************************List Map  *************************")
  val alistmap: mutable.ListMap[String, String] = mutable.ListMap("a" -> "b", "c" -> "c")
  println(alistmap)

  println("**************************************Hash Map  *************************")
  var ahashmap: mutable.HashMap[String, String] = mutable.HashMap("a" -> "b", "c" -> "c")
  println(ahashmap)

  println("**************************************Seq  *************************")
  //Seq - Java List & List --> Java's Linked List
  val aseq = Seq("a", "b", 1)
  println(aseq)
  val flist = List("a", "b", 1)
  println(flist)
  // List(1, 3, 3, 2, 1) --> It will be printed as list only
  // array and seq - they are connected
  val numseq: Seq[Int] = nums //Implicit Conversions
  println(numseq)

  println("**************************************Range  *************************")
  //Ranges -It is a sequence of Int
  val arange: Seq[Int] = 1 to 5
  println("Range" + arange)

  println("**************************************Array  *************************")
  //Array - Same as simple Java array
  // They are mutable
  // Indexing is fast
  // interoprable with Java Arrays

  val nums = Array(1, 2, 3, 4)
  val emptydim = Array.ofDim[Int](5)
  emptydim.foreach(println)

  println("**************************************Vectors  *************************")
  // fast element addition
  // good performance for very large size -
  //  It provides random access of elements. It is good for large collection of elements.
  val vectorseq: Vector[Int] = Vector(1, 2, 3, 4)
  println(vectorseq)

  println("**************************************SET  *************************")
  //    It is used to store unique elements in the set. It does not maintain any order for storing elements.
  val setval: Set[Int] = Set(1, 2, 3, 5, 3)
  println("setval" + setval)

}
