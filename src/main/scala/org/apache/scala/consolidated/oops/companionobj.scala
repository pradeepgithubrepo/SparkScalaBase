package org.apache.scala.consolidated.oops

//In scala, when you have a class with same name as singleton object, it is called companion class and the singleton object is called companion object.
//The companion class and its companion object both must be defined in the same source file.
//A companion object is allowed to access both private methods and private fields of the class.
//https://www.learningjournal.guru/courses/scala/scala-programming-foundation/scala-companion-objects/
//You can define all instance-level fields and methods in a Class. If you have some global static fields and methods, define them in the object. And keep them together into the same file but still separate them into two different constructs
//Purpose - seperation of concerns using companion -> All fields which needs local access in class . Ones for global access in scala
//implementation of factory method - You dont have to create a object to access it . Just use apply ethod
class companionobj {
   private def printFilename() = {
    println(companionobj.HiddenFilename)
  }
}

object companionobj {
//  Note that this is a private variable in the case of
  private val HiddenFilename = "/tmp/foo.bar"
  def main(args: Array[String]): Unit = {
    val compobj = new companionobj
    compobj.printFilename()

//    Step 1 to invoke the companionobj.But problem here is we need to create an obj to access the
    val grpobj = new graph
    grpobj.persistdata(graph.DISK_AND_MEM)
    graph.apply().persistdata(graph.DISK_ONLY)
  }
}

object tstobj extends App {
  val obj = new companionobj
//  obj.printFilename()
}
class graph{
  val numofedges = 100
  val numofvertices = 300
  def persistdata(strorage_level : Int) ={
 println(s" Storgage level selected is $strorage_level")
  }
}

private object graph{
  val DISK_ONLY = 0
  val MEM_ONLY = 1
  val DISK_AND_MEM = 2
//  Import - This will help to overcome the issue related to creating a object to access it
  def apply(): graph = new graph()
}
