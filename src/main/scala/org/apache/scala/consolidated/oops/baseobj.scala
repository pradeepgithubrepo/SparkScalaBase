package org.apache.scala.consolidated.oops

object baseobj extends App {

  val personobj = new person("John", 30)
  println(personobj)
  //  Class parms cannnot be accessed by obj
  //  eg . personobj.age is wrone
  // Correct ways is below
  println(personobj.ageclass)

  //  Call Method
  personobj.greetperson("pradeep")
  personobj.greetperson(30)
}

//class combines the fields and methods(member function which defines actions) into a single unit.
//Constructors are used to initializing the object’s state.
//constructor  contains a collection of statements that are executed at the time of Object creation.
class person(name: String, age: Int)
//This is a constructor . Every single instance must be consturcted by passing in these 2 parms.
{
  val ageclass = age

  def greetperson(name: String) = {
    //    Power of This. Ensures local varaibles are populated when ambigious variable  are used
    println(s"${this.name} says : Hello $name")
  }

  def greetperson(age: Int) = {
    println("Age " + age)
  }

  //  Method Overloading

}