package org.apache.scala.consolidated.collections

object tuplesandmaps extends App {

  //  Tuples are finite ordered List . Tuples need not have any unique key concept
  val tuple = List((2, "Hello Pradeep"), (2, "Hello Dude"))
  println(tuple)

  tuple.foreach(x => println(x._1))

  val newtuple = tuple.foreach(x => println(x.swap))

  //  Map
  //  Maintain a key -> Value relationship
  //  key should be always unique.

  //  Empty map declaration
  val anemptymap: Map[Int, String] = Map()

  //  Map operations
  var phonebook = Map(("pradeep" -> 12345), ("Gokul" -> 5678), ("Ram" -> 25347)).withDefaultValue("No record found ")
  println(phonebook)
  println(phonebook("pradeep"))
  println(phonebook.getOrElse("ram1", "Norecfound"))
  println(phonebook("gpoi"))
  //  Filterkeys
  println(phonebook.filterKeys(_.startsWith("G")))
  //MapValues
  //  println(phonebook.mapValues(x => x.*10))

  //  Operating on an immutable map
  var x = Map("AL" -> "Alabama")

  x += ("AK" -> "Alaska")
  println(x)

  x += ("AR" -> "Arkansas", "AZ" -> "Arizona")
  println(x)

  x -= "AR"
  //  https://stackoverflow.com/questions/8287425/mutable-vs-immutable-in-scala-collections
  println(x)

  val y = scala.collection.mutable.Map("AL" -> "Alabama").withDefaultValue("Ok")

  y += ("AK" -> "Alaska")
  println(y)
  y += ("AR" -> "Arkansas", "AZ" -> "Arizona")
  println(y)
  y -= "AR"
  println(y)

  //  Grouping a list
  val lnames = List("Pradeep","Prajul","Gokul","Gopi","Manoj")
  println(lnames.groupBy(x => x.charAt(0)))

  //  How Mutable List and Listbuffer vary ?
  //  https://stackoverflow.com/questions/5446744/difference-between-mutablelist-and-listbuffer
  //  Tuples Vs MAP
  //  https://stackoverflow.com/questions/43420810/scala-immutable-map-vs-list-of-tuples
}
