package org.apache.scala.basics.oops

object abstractdata extends App {

//  Abstract - Class that contains unimplemented methods
//  Abstract class cannot be instatined by object
//  Abstract class can have both abstract and non-abstract types

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
  class crocodile extends carnivore{
  }

  object hyena extends carnivore{
    def main(args: Array[String]): Unit = {
      eat("elephant")
    }
  }
}
