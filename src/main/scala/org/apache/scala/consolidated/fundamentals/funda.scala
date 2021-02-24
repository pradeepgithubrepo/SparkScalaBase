package org.apache.scala.consolidated.fundamentals

object funda extends App {

  //  Lazy initialization
  //  Lazy initialization means that whenever an object creation seems expensive, the lazy keyword can be stick before val.
  //  This gives it the advantage to get initialized in the first use i.e.
  //    the expression inbound is not evaluated immediately but once on the first access.
  lazy val name = "pradeep"

  //  Supported Data Types
  val donutsBought: Int = 5
  val bigNumberOfDonuts: Long = 100000000L
  val smallNumberOfDonuts: Short = 1
  val priceOfDonut: Double = 2.50
  val donutPrice: Float = 2.50f
  val donutStoreName: String = "allaboutscala Donut Store"
  val donutByte: Byte = 0xa
  val donutFirstLetter: Char = 'D'
  val nothing: Unit = ()

  // ************************************** String Interpolation*************************/
  val cfloat = 1.2
  println(f"Train is running @ $cfloat%2.8f ")

  //  Escaping quotes in String
  println("Step 1: How to escape a Json String")
  //  val donutJson: String ="{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"
  val donutJson2: String = "{\"donut_name\":\"Glazed Donut\",\"taste_level\":\"Very Tasty\",\"price\":2.50}"
  println(s"donutJson2 = $donutJson2")

  //  Another ways is to use """
  val donutJson4: String =
    """
      |{
      |"donut_name":"Glazed Donut",
      |"taste_level":"Very Tasty",
      |"price":2.50
      |}
      """
      .stripMargin
  println(s"Donut4 $donutJson4")

  // ************************************** IF Else*************************/
  println("************************************** IF Else*************************")
  //  Expressing and using them as values
  val x = 4
  val y = 5
  val result = if (x < y) x else y
  println(result)

  // ************************************** For Loop *************************/
  println("************************************** For Loop*************************")
  //  Use yeild when you want you plan to accumulate results

  println("\nFilter values using if conditions in for loop and return the result back using the yield keyword")
  val donutIngredients = List("flour", "sugar", "egg yolks", "syrup", "flavouring")
  val sweeteningIngredients = for {
    eachingred <- donutIngredients
    if (eachingred == "sugar" || eachingred == "syrup")
  } yield eachingred
  println(s"Sweetening ingredients = $sweeteningIngredients")

  // ************************************** Pattern Matching *************************/
  println("************************************** Pattern Matching *************************")
  val donutType = "Glazed Donut"

  val donutresult = donutType match {
    case donut if (donut.contains("Glazed") || donut.contains("Donut")) => "If check works"
    case _ => "Default picks"
  }
  println("donutresult" + donutresult)
  //  Patter matching by datatype
  //  val patterdatatype = donutType match {
  //    case donut : Int => "Integer"
  //  }

  //   Tuples - Easy way of storing sematics
  // ************************************** Options  *************************/
  println("************************************** Options *************************")
  //Objective is to guard against null pointer exception
  //  Option is a wrapper for a value that might be present or absent

  //  Below code will result in NPE.
  //  println(unsafemthd().length)

  val capitals = Map("Germany" -> "Berlin", "penang" -> null)

  println("Germany result" + validateoption(Option(capitals("Germany"))).length)
  println("penange result" + validateoption(Option(capitals("penang"))).length)
//  println("penange result" + (capitals("penang")).length)

  def validateoption(x: Option[String]) = x match {
    case Some(valp) => valp
    case None => ""
  }
}
