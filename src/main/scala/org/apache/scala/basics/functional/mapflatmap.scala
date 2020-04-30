package org.apache.scala.basics.functional

object mapflatmap extends App {
  val mlist = List(1, 2, 3, 4)
  println(mlist.head)
  println(mlist.tail)
  //MAP --> Easy way of accessing map elements
  println(mlist.map(_ + 1))

  println(mlist.filter(_ % 2 == 0))

  // Flatmap
  // It can be defined as a blend of map method and flatten method.
  // The output obtained by running the map method followed by the flatten method is same as obtained by the flatMap()
  val names = List("Pradeep","RahuL")
  var res1 = names.map(_.toLowerCase)
  println("Res1"+res1)
  var res2 = res1.flatten
  println("Res2 "+ res2)

  println("Flatmap result"+names.flatMap(_.toLowerCase))

  //  Anothr example Difference between map and a flatmap --> you  have to go through multiple steps which can be achevied in a single step in flatmap

  def func(x : Int) = List(x,x+1,x+2)
  var r1 = mlist.map(x => func(x))
  println("R1"+r1)
  //  var r2 = mlist.flatten(_)
  //  println("R2"+r2)

  var r3 = mlist.flatMap(y => func(y))
  println("R3"+r3)

  //  Bring out combinations
  val alist = List(1,2,3,4)
  val blist = List("a","b","c","d")

  println(alist.map(x => blist.map(y => x+y)))
  println((alist.map(x => blist.map(y => x+y))).flatten)
  println(alist.flatMap(x => blist.map(y => x+y)))

  //  foreach vs for . Above logic I can do with "For" loop

  var resultcomb = for {a <- alist
                        b <- blist} yield "Space" + a + "-"+b
  var plist = for{a <- alist}yield a
  println(resultcomb)
  resultcomb = for {
    a <- alist if (a%2 ==0)
    b <- blist
  } yield "" + a + "-" + b

  println("New variety"+resultcomb)

}
