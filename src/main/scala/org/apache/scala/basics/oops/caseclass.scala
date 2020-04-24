package org.apache.scala.basics.oops

object caseclass extends  App {

  //  1.Case class will make the class parameters as field values
  case class address(building : String , pincode : Int)
  case class Person(name : String , age : Int , addressdetails : address)
  case class complexPerson(name : String , age : Int , addressdetails : Array[address])
  val addressobj = new address("Sakthi ",600125)
  val obj = new Person("pradeep",30 ,addressobj)
  println(obj.name)

  //  2. Gives a better tostring capablity
  println(obj.toString)
  val complexobj = new complexPerson("pradeep",30 ,Array(addressobj))
  println(complexobj.toString)
  println(obj)

  //3. Equals and hashcode out of Box
  val newobj = new Person("pradeep",30,addressobj)
  println(obj == newobj)

  //  4. Have companion objects and also serializable


}
