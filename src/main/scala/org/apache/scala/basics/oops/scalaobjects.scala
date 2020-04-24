package org.apache.scala.basics.oops

object scalaobjects extends App {
  //  Singleton Object
  //  A singleton object provides an entry point to your program execution.
  //  If you do not create a singleton object in your program, then your code compile successfully but does not give output.
  //   No object is required to call methods declared inside singleton object.
  //  So you required a singleton object to get the output of your program.
  //  The method in the singleton object is globally accessible.
  //  https://www.javatpoint.com/scala-singleton-and-companion-object
  singletonobj.display

  val compclass = new singletonobj
  compclass.displayfromclass

  val bob = Person(new AnotherPerson("Mary"), new AnotherPerson("John"))
}

object singletonobj {
  def display = println("Hello")
}

//Companion class
//Benefit - Can access each others private members
class singletonobj {
  def displayfromclass = println("Hello from companionclass")
}

//In java we use static to static to access the variables directly using class names not by creating an obj


object Person {
  //  Factory method - Build an instance by provinding few arguments
  //def from(mother : AnotherPerson , father : AnotherPerson) : AnotherPerson= new AnotherPerson("Bob")
  //  Change from to Apply
  def apply(mother: AnotherPerson, father: AnotherPerson): AnotherPerson = new AnotherPerson("Bob")

  def fromcompanion(mother: Person, father: Person): Person = new Person("Bob")
  val pp = new Person("Gokul")
  pp.fromPersonclass()
}

class Person(val name: String) {
def fromPersonclass()= println("Hello fromPersonclass")
}

class AnotherPerson(val name: String) {
  def fromAnotherPersonclass()= println("Hello fromAnotherPersonclass")

}
