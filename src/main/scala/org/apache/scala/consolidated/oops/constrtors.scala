package org.apache.scala.consolidated.oops

object constrtors {
  def main(args: Array[String]): Unit = {
    var obj = new primaryconstrutor("pradeep",25)
    obj.printstmt()
  }

}

class primaryconstrutor(var name : String , var age : Int){
//  As var is given both getter and stter methods will be invoked
//  Val will set only setter method
  def printstmt()={
  println(s"Name $name")
  age +=5
  println(s"Upd age ${age}")
}

//  //  auxiliary constructor
//  def this(Cname: String, Employeeage : Int)
//  {
//    // Calls Primary constructor
//    this(Cname : String , Employeeage : Int)
//
//  }
}
