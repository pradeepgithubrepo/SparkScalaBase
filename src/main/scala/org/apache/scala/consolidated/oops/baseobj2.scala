package org.apache.scala.consolidated.oops

object baseobj2 extends App {
  //See the differnce between this keyword

  val perobj = new Person("Pradeep", 30)
  val gokulobj = new Person("Gokul", 30)
  gokulobj.personinfo(perobj)
  gokulobj.name
  class Person( val name: String, age: Int) {
    def personinfo(per: Person): Unit = {
      println(s"${per.name} is here . ${this.name}")
    }
  }

}

