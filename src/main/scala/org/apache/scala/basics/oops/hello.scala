  package org.apache.scala.basics.oops

object hello{
    def main(args : Array[String])={
//    Various If Condition option-1
      var a = 100
      if (a > 101){println("greater")}
      else {println("lesser")}
//      Various If Condition option-2
      println(checkval(a))

//    Scala Pattern Matching - Switch class
//    Setting "B" to any ensures any value can be passed to it
      val b : Any = "hi0"
        b match {
          case 1 => println(1)
          case "hi" => println("hi")
          case _ =>println("default")
        }

//      While Loop
      while ( a < 105){
        a = a+1
        println(a)
      }

//      for loop - 1
      for ( c <- 1 to 10){
        println("Loop"+c)
      }
//     for loop -2
      var d = List(1,2,3,4)
      for (c <- d)
        {
          println("List:"+ c)
        }
//    for loop yield keyword-3
//      yield keyword which returns a result after completing of loop iterations
      val result = for ( a <- 1 to 5) yield  a
      println("Yield"+result)
      for ( i <- result){
        println("result for yield "+ i)
      }
//      for loop yield keyword-4
      val fruits = Array("apple", "banana", "orange")
      var newfruits = for( upd <- fruits) yield upd.toUpperCase
      println(newfruits)
      for(a <- newfruits) println(a)

//      why should we use a for-each loop
//      An important lesson from the for loop examples is that when you use the for/yield combination with a collection, you’re building and returning a new collection,
//      but when you use a for loop without yield, you’re just operating on each element in the collection — you’re not creating a new collection. The for/yield combination is referred to as a for-comprehension, and in its basic use, it works just like the map method. It’s discussed in more detail in Recipe 3.4, “Creating a For Comprehension (for/yield Combination)”.
//      https://alvinalexander.com/scala/scala-for-loops-foreach-how-to-translated-by-compiler/
      fruits.foreach( i => println(i.toUpperCase()) )

//      Break Statment
//      break the loop
    }



    def checkval(a:Int)=if(a>99) true else false
  }