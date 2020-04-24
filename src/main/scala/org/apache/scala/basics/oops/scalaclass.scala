package org.apache.scala.basics.oops

//class combines the fields and methods(member function which defines actions) into a single unit.
class student {
  def display(name : String )={
    println(name)
  }
}
object scalaclass {
 def main(args : Array[String])={
//   Example of scala Class and invoking them thru obj
   val obj = new student
   obj.display("Pradeep")

   //  Singleton Object
   //  A singleton object provides an entry point to your program execution.
   //  If you do not create a singleton object in your program, then your code compile successfully but does not give output.
//   No object is required to call methods declared inside singleton object.
   //  So you required a singleton object to get the output of your program.
   //  The method in the singleton object is globally accessible.
   //  https://www.javatpoint.com/scala-singleton-and-companion-object
   singletonobject.displaydata()


 }


}

object singletonobject{
  def displaydata(): Unit ={
    println("Hello")
  }
}
