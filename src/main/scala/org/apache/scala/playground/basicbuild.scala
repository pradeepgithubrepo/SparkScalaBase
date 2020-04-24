  package org.apache.scala.playground

object basicbuild {
   def main(args : Array[String])={
  //   Val cannot be reassigned  and immutable
  //   vals are not constants they are ment to hold  intermediate values.
  val x = 45;
     println(x)
  //   Short data type is rep by 4 bytes
  //   Long data type is rep by 8 bytes
  //   If value of num is very lengthy put L at end
     val llongval : Long = 3452356667675675L
     println(llongval)

//     Expressions
     var incrvar = 2
     incrvar +=1
     println("Incremental varibales "+incrvar)

//     Loops only give side effects
     var i = 1
     while (i < 5){
       i +=1
       println("WhileLoop"+i)
     }

//     Unit == void in java
     var vari = 0
     var bomb = (vari = 3)
     println("Unit display :"+bomb)

     val somevalue = { 2 < 3 }
     println("Somevalue: "+somevalue)
     val someothervalue = {
       if(somevalue) 45 else 95
       89
     }
     println("someothervalue : "+someothervalue)
   }
  }
