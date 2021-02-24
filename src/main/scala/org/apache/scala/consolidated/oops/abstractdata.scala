package org.apache.scala.consolidated.oops

object abstractdata extends App {

//  Abstract - Class that contains unimplemented methods
//  Abstract class cannot be instatined by object
//  Abstract class can have both abstract and non-abstract types

// Abstract class with constructor
// And the constructor contain two arguments


abstract class myauthor(name: String,
                        topic: String)
{
  def details()
}

  // GFG class extends abstract class
  class GFG(name: String, topic: String) extends
    myauthor(name, topic)
  {
    def details()
    {
      println("Author name: " + name)
      println("Topic name: " + topic)
    }
  }

  object Main
  {

    // Main method
    def main(args: Array[String])
    {

      // objects of GFG class
      var obj = new GFG("Ankita", "Abstract class")
      obj.details()
    }
  }

//Why should you go for abstract class?
// 1. Abstract class can have constructors while traits cannot
//  2.Abstract classes are fully interoperable with Java.

  abstract  class animal{
  val animaltype : String
  def eat : Unit
}


  class dog extends animal{
    override val animaltype: String = "canine"
//Here we need to use override every time one has to use anything abstract element from the above class to overcome this trait is used.
   override def eat: Unit = {
      println("Hello doddy")
    }
  }


  val croc = new crocodile
  croc.eat("rabbit")
  trait carnivore{
    def eat(foodtype : String) : Unit={println(s"Iam eating $foodtype")}
  }
  class crocodile extends carnivore

  object hyena extends dog with carnivore{
    def main(args: Array[String]): Unit = {
      eat("elephant")
      print(eat)
    }
  }
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
