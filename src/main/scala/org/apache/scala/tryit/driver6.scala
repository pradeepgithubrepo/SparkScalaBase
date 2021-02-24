package org.apache.scala.tryit

import java.sql.Struct

import scala.annotation.tailrec
import scala.collection.immutable.ListSet
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object driver6 {
  def main(args: Array[String]) = {

    //  Immutable Collectins
    val alist = List("Apple", "Orange", "Peas")
    println(alist.filter(_.contains("ea")))

    var amap = Map("A" -> "Apple", "B" -> "Ball", "C" -> "Cat").withDefaultValue("No rec Found")
    amap += ("D" -> "Dog")
    var alistbuffer = new ListBuffer[String];
    alistbuffer += "goat"
    alistbuffer += "cow"
    alistbuffer += "donkey"

    val alistset = ListSet("Apple", "Orange", "Peas")
    //    LIFO
    println(alistset)

    val aseq = Seq(1, 2, 3, 5)
    println(aseq)

    println(aseq.map(_ + 1))
    println(alistset.flatMap(_.toLowerCase()))

    val blist = List(1, 2, 3)

    def mapflat(x: Int) = {
      List(x, x + 1, x + 2)
    }

    println(blist.map(x => mapflat(x)))
    println(blist.flatMap(x => mapflat(x)))
    //  1. cbn vs cbv
    cbv(System.nanoTime())
    cbn(System.nanoTime())
    //  2. Hof
    println("HOF" + hof(5, cuberoot))
    //  3. Lamda func
    val avalue = (x: String, y: String) => {
      x + " " + y
    }
    println("Lamda Func : " + avalue("Hello", "World"))
    //  Polymorphic
    polymorphick(1)
    polymorphick(2.2)
    //  Patter matching
    println(patMatch(1))
    println(patMatch(0))
    //  Options
    val caps = Map("ger" -> "Berlin", "korea" -> null)
    println("Opt1" + optionhelp(Option(caps("korea"))).length)
    println("Opt1" + optionhelp(Option(caps("ger"))).length)
    //    Currying
    //   Helps to create chain/ derivative funcitons from the parent functions
    val threepie = formatter("%8.2f")(_)
    val twoepie = formatter("%3.2f")(_)

    println(threepie(Math.PI))
    println(twoepie(Math.PI))

    //   4. Recursives
    println(fibbo(6))
    //  5. Tail Recursive
  }

  def fibbo(x: Int): Int = {
    if (x <= 2) 1
    else
      fibbo(x - 1) + fibbo(x - 2)
  }

  def fibbotail(x: Int) = {
    @tailrec
    def helperfuc(i: Int, acc: Int): Int = {
      if (i < 2) 1
      else
        helperfuc(i - 1, i * acc)
    }

    helperfuc(x, 0)
  }

  def formatter(x: String)(y: Double) = x.format(y)

  def optionhelp(x: Option[String]): String = {
    x match {
      case Some(y) => y
      case None => ""
    }
  }

  def polymorphick[T](x: T) = {
    x match {
      case y: Int => println(" This is Int")
      case y: Double => println("This is double")
      case _ => println("This is dummy")
    }
  }

  def patMatch(x: Int): String = {
    x match {
      case 1 => "one"
      case _ => "default"
    }
  }

  def hof(X: Int, func: Int => Int) = func(X)

  def cuberoot(x: Int) = x * x * x

  def cbv(x: Long) = {
    println(s"X1 value is : $x")
    println(s"X2 value is : $x")
  }

  def cbn(x: => Long) = {
    println(s"X1 value is : $x")
    println(s"X2 value is : $x")
  }

  val klist = List(1, 2, 2, 3, 4, 5, 5)
  println("Set1 : " + klist.toSet)
  println(klist.groupBy(x => x))

  //  def
}

abstract class abs(a : Int) {
  val b = 10;
  def compare() : String
}

class intermediate (a : Int) extends abs(a : Int) {
  val q = a
  override def compare(): String = {
    var aval = ""
    if ( q > b ) {
      aval = "This is great"
    }else
    {
      aval = "This does't work"
    }
    aval
  }
}

object mainclass extends App {
  val obj = new intermediate(15);
  println(obj.compare());
}

class baseclass (age : Int , name : String ){

  def tellage(): Unit ={
    println("Age is "+age)
  }
   def tellname(name : String )={
     println(s"This name : ${this.name} is different from $name")
   }
}

object baseclassobj {
  def main(args : Array[String])={
    val obj = new baseclass(15,"Pradeep")
    obj.tellage()
    obj.tellname("Ram")
  }
}

case class person1(name : String , age : Int)
case class address1(location : String, city : String)
case class aggperson1(per : person1 , adddressinfo : Array[address1])

object caseclass1 {
  def main(args : Array[String]){
  val personobj1 = person1("pradeep",15)
  val addressobj = address1("Moulivakkam","chennai")
  val agg_obj = aggperson1(personobj1,Array(addressobj))
    println(agg_obj.toString)



}
}

class pradeep(age : Int , roll : Int) {
  var pradage = 0;
  var pradroll = 0
  def setter(): Unit ={
    pradage = age
    pradroll = roll
  }
}

case class pradeep1(age : Int , roll : Int){

}
object prad{
  def main(args : Array[String])={
    val obj = new pradeep(10,13)
    println("Prad_age"+ obj.pradage)

    val obj1 = pradeep1(31,96)
    println(obj1.age)
  }
}


class compa(name : String){
  private val aname = name
  def tellnamae(): Unit ={
    println("Name is "+aname)
  }
}

object compa{
  def main(args: Array[String])={
    val obj = new compa("Pradeep")
   println(" Getting priviate variable "+ obj.aname )
  }
}
