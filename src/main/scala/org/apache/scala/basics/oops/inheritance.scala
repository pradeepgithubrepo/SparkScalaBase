package org.apache.scala.basics.oops

object inheritance extends App {
class animal(food : String){
  def eat = println(s"Eats $food .")
}

  class cat extends animal("biscuits"){
    override def eat: Unit = {
      println("What do you eat?")
    }
  }
  val cat = new cat
  cat.eat

  val animalobj  = new animal("cookies")
  animalobj.eat
}
