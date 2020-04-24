package org.apache.scala.basics.oops

//When subclass wants to provide a specific implementation for the method defined in the parent class,
// it overrides method from parent class.
//Here we are overriding scala's default tostring method.
//https://www.geeksforgeeks.org/overriding-tostring-method-in-scala/
object methodoverriding {
  def main(args: Array[String]): Unit = {
    //  println(toString())
    val triatobj = new trialclass("hello", "pradeep")
    println(triatobj)
    //    Without an override function trait will display only like below
    //    com.prad.legend.trialclass@4563e9ab

  }

  //   override  def toString():String = { "hello"}

}

class trialclass(val1: String, val2: String) {
  def getval() = val1

  def getval2(): String = val2

  override def toString()={
    s"Value 1 is $val1 and for Value 2 is $val2"
  }
}
