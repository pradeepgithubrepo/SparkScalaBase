package org.apache.scala.consolidated.oops

// single interface to insantiate one of many classes
//Loose Coupling between Object Creation logic and Client.
//Clear separation of Responsibilities.
//Easy to change object creation logic without effecting Client program.
abstract class Room{
  val bookingprice : Int
  val avaiablity : Int
  val facility : List[String]
  def book(a:Int) : Int
}
object Room{
  val STANDARD = 1
  val DELUXE = 2
  val ULTRA_DELUXE =3

  def apply(roomType : Int): Room = {
    roomType match {
      case STANDARD => new standard()
      case DELUXE => new deluxe()
      case ULTRA_DELUXE => new ultradeluxe()
    }
  }

  def main(args : Array[String])={
    val obj = Room(DELUXE)
    println("bookingprice" + obj.bookingprice)
    obj.book(25)
    println("avaiablity" + obj.avaiablity)
  }
}

private class standard extends Room {
  override val bookingprice: Int = 100
  override val avaiablity: Int = 50
  override val facility: List[String] = List("Room","Bathroom")

  override def book(needed : Int): Int = {
    avaiablity-needed
  }
}

private class deluxe extends Room{
  override val bookingprice: Int = 150
  override val avaiablity: Int = 30
  override val facility: List[String] = List("Room","Bathroom","fan")

  override def book(a: Int): Int = {
    avaiablity-a
  }
}

private class ultradeluxe extends Room{
  override val bookingprice: Int = 200
  override val avaiablity: Int = 20
  override val facility: List[String] = List("Room","bathrpoom","AC")

  override def book(a: Int): Int = {
    avaiablity - a
  }
}

