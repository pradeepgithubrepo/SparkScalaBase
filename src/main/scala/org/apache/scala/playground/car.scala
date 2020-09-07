package org.apache.scala.playground
abstract class car{
  def bookingprice : Int
  def cartype : List[String]
  def avaiablity : Int
  def booking(book : Int) : Int
}
object car {

class standard extends car{
  override def bookingprice: Int = 2000
  override def cartype: List[String] = List("Alto","Swift")
  override def avaiablity: Int = 10
  override def booking(book :Int): Int = {
    avaiablity - book
  }
}
class luxury extends car{
  override def bookingprice: Int = 100

  override def cartype: List[String] = List("BMw","Benz")

  override def avaiablity: Int = 5

  override def booking(book: Int): Int = avaiablity-book
}

  def apply(carType:String):car = {
    carType match {
      case "lux" => new luxury()
      case "std" => new standard()
      case _ => new standard()
    }
  }



}
