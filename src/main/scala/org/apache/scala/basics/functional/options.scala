package org.apache.scala.basics.functional

object options extends App {
  //Objective is to guard against null pointer exception
  //  Option is a wrapper for a value that might be present or absent

  //  Below code will result in NPE.
  //  println(unsafemthd().length)

  println(Option(unsafemthd()))

  def unsafemthd(): String = ""

  //Retriveing from options
  val capitals = Map("France" -> "Paris", "Japan" -> null)

  //  This will fail with NPE
  //  println(capitals("Japan").length)

  println("France Cap"+show(Option(capitals("France"))).length)
  println("Jap cap"+show(Option(capitals("Japan"))).length)

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => ""
  }

}
