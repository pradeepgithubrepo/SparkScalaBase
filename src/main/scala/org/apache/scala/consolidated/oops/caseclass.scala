package org.apache.scala.consolidated.oops

object caseclass extends App {

  //  1.Case class will make the class parameters as field values
  //  2. Brings in additional properties. Has default apply method which manages the construciton of object
  //  3. Create an object without keyword new
  case class address(building: String, pincode: Int)

  case class Person(name: String, age: Int, addressdetails: address)

  case class complexPerson(name: String, age: Int, addressdetails: Array[address])

  val addressobj = address("Sakthi ", 600125)
  val obj = Person("pradeep", 30, addressobj)
  println(obj.addressdetails)

  val addressobj1 = address("mou", 12)

  //  2. Gives a better tostring capablity
  println(obj.toString)
  val complexobj = complexPerson("pradeep", 30, Array(addressobj))
  println(complexobj.toString)
  println(obj)

  //3. Equals and hashcode out of Box
  val newobj = Person("pradeep", 30, addressobj)
  println(obj == newobj)

  //  4. Have companion objects and also serializable


}
