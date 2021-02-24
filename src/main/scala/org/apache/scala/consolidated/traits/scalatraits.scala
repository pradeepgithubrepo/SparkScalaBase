package org.apache.scala.consolidated.traits

//trats vs abstract
//  1.Multiple traits can be inherited.
//  2.Traits does not have a constructor paramter.
trait scalatraits {
  def attack(animal : String)= println(s"I attack $animal")
}

//object root extends scalatraits {
//  def main(args : Array[String])={
//    attack("Lion")
//  }
//}

//Traits can be extended along with the abstract classes
//Trait Mixins The right mixins order of trait is that any class or abstract class which you want to extend, first extend this. All the traits will be extended after this class or abstract class.
abstract class croc {
  def crocattack() : Unit
}

trait river {
  def riverdrown() = println("River is flowing ")
}

class joinriver extends croc with river{
  def crocattack(): Unit = println("Croc is attacking")
}
object rivercroc extends river {
  def main(args: Array[String]): Unit = {
    val joinriverobj = new joinriver
    joinriverobj.crocattack()
    riverdrown()
  }
}


