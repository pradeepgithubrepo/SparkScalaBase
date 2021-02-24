package org.apache.scala.tryit

object driver3 extends App {

  //  1. cbn vs cbv
  //  2. Hof
  //  3. Lamda func
  //  Polymorphic
  //  Patter matching
  //  Options
  //   4. Recursive
  //  5. Tail Recursive
  //  6.Abstract class



}

abstract class Room {
  var rate: Int = 0
  var availability: Int = 0

  def book(needed: Int): Int

  var facility: List[String]
}

object Room{
  val std = 1
  val delixe = 2
  val super_deluxe =3

  def apply(roomType : Int): Room = {
    roomType match {
      case std => new standard()
      case delixe => new deluxe()
      case super_deluxe => new superdeluxe()
    }
  }

  def main(args : Array[String])= {
    val obj = Room(std)
    println(obj.facility)
    println(obj.rate)
    println(obj.book(25))
  }
}

class standard extends Room{
  rate = 100
  availability = 50
  override def book(needed: Int): Int = needed * rate
  override var facility: List[String] = List("room","fan")
}

class deluxe extends Room{
  rate = 150
  availability = 30
  override def book(needed: Int): Int = availability - needed
  override var facility: List[String] = List("room","fan")
}

class superdeluxe extends Room{
  rate = 200
  availability = 10
  override def book(needed: Int): Int = availability - needed
  override var facility: List[String] = List("room","fan")
}