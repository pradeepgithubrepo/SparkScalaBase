package org.apache.scala.tryit

object driver1 {
  def main(args: Array[String]) = {
    //  Increment operator
    var aval = 3
    aval += 1
    println("Increment op: " + aval)
    //  cbv vs cbn
    cbv(System.nanoTime())
    cbn(System.nanoTime())
    //  fibonacci
    println("Fiborec" + fibborec(6))
    //
    //    Patter Mtching
    println("Pattern MAtching" + pattermatch(3))
    //    HOF
    println("HOF" + hof(5, sqrroot))
    //    Lamda
    val result = (x: String, y: String) => x + "{}" + y
    println("Lamda" + result("Hello", "World"))
    //    Currying
    val stdformatter = formatter("%3.2f")(_)
    println("Currying 1: " + stdformatter(Math.PI))
    val preciseformat = formatter("%10.2f")(_)
    println("Currying 2 :" + preciseformat(Math.PI))


  }


  def cbv(x: Long) = {
    println("Val1" + x)
    println("Val2" + x)
  }

  def cbn(x: => Long) = {
    println("Val1" + x)
    println("Val2" + x)
  }

  //  1 1 2 3 5
  //  n-3 + n-2
  //  f(3) + f(2)
  def fibborec(x: Int): Int = {
    if (x <= 2) 1
    else {
      var result = fibborec(x - 2) + fibborec(x - 1)
      result
    }

  }

  def pattermatch(x: Int) = {
    x match {
      case 1 => println(" REsult is 1")
      case _ => println("By default")
    }
  }

  //    HOF
  def hof(x: Int, func: Int => Int): Int = {
    func(x)
  }

  def sqrroot(x: Int) = x * x

  def formatter(x: String)(pre: Double) = x.format(pre)
}

//    Companion obj
object companion extends App {
  val compobj = new companion("Pradeep", 30, "Chennai")
  println("Companion Obj : " + compobj.namesetter)
  println("Comp city " + compobj.city)
  val anotherobj = new anotherclass("Rahul", 30, "Cbe")
  println("Another obj" + anotherobj.city)
  //    anotherobj.n
}

//    Constructors
class companion(name: String, age: Int, val city: String) {
  private def namesetter = name

  private def agesettter = age
}

class anotherclass(name: String, age: Int, val city: String) {
  private def namesetter = name

  private def agesettter = age
}

object constructorsam extends App {
  val newobj = new samplecons(10, 20)
  println("Val1" + newobj.a)
  newobj.updvalue
}

class samplecons(val a: Int, val b: Int) {
  //    This keyword
  def updvalue = println(s"Hell this $a is not ${this.a}")
}

//    Trait
//    Abstract class

abstract class absclass {
  def absmethod(x: String) = {
    println("absmethod is printing " + x)
  }
}

trait itstrait {
  def traitfunc() = println("This is a trait")
}

object traitabs extends absclass with App with itstrait {
  absmethod("Pradeep")
  traitfunc
}

//    Case class
case class person(name: String, age: Int)

case class persondetails(city: String, person: person)

object caseclass extends App {

}

//  Sequence
object sequence extends App {
  val seq = Seq(1, 2, 3, 4)
  println("Seq" + seq)
  val alist = List(1, 2, 3, 4)
  println(alist)
  var aimmutablelist = List(1, 2, 3, 4)
  aimmutablelist = 0 +: aimmutablelist :+ 5
  println("An immutable list " + aimmutablelist)
  val avec = Vector(1, 2, 3, 4, 5)
  println(avec)
  val anarray = Array(1, 2, 3, 4)
  anarray.foreach(println(_))

  // map vs flatmap
  val names = List(List("Pradeep","ram"),List("Gokul"))

  println((names.map(x => x.map(_.toLowerCase))).flatten)
  println(names.flatMap(x => x.map(_.toLowerCase)))

  var mapx = Map("AR" -> "Arkansas", "AZ" -> "Arizona")
  mapx += ("AK" -> "Arizona")
  println(mapx)
  mapx -= ("AZ")
  println(mapx)
}

//option
object optionstest extends App {
  println((showval(unsafefunc)).length)
//  println(unsafefunc.length)
  def unsafefunc = null
  def showval(option: Option[String]) = {
    option match {
      case Some(option) => option
      case none => ""
    }
  }
}