package org.apache.scala.basics.allaboutscala

object collectionfunctions extends App {

  val donuts: List[String] = List("Plain Donut 1", "Plain Donut 2", "Strawberry Donut", "Plain Donut 3", "Glazed Donut")
  println("************************************** drop  *************************")
  //  Drop n elements
  println(donuts.drop(2))

  println("************************************** drop While  *************************")
  //  The code below shows how to use the dropWhile method to drop elements from the Donut sequence whose donut names start with the letter P.
  //  The dropWhile method conveniently removes the first two elements, namely, Plain Donut 1 and Plain Donut 2. Since the first letter of the third element (Strawberry Donut) starts with the character 'S',
  //  our predicate function no longer holds true. As a result, the "dropping" iteration stops at the third element, and we end up with all the remaining elements starting from the Strawberry Donut element itself - that is, Strawberry Donut, Plain Donut 3 and Glazed Donut
  println(donuts.dropWhile(_.charAt(0) == 'P'))

  println("************************************** exists   *************************")
  println(donuts.exists(_.contains("Plain")))

  println("************************************** filter   *************************")
  println(donuts.filter(_.contains("Plain")))
  println(donuts.filterNot(_.contains("Plain")))

  println("************************************** find   *************************")
  println(donuts.find(_.contains("Donut")).getOrElse("Boom"))

  println("************************************** Fold   *************************")
  //  Fold will have a accumulator
  val alist = List(1, 2, 3, 4)
  println(alist.fold(0)(_ + _))

  println(s"All donuts = ${donuts.fold("")((acc, s) => acc + s + " Donut ")}")
  val p = donuts.fold("")((acc, x) => {
    acc + x
  })
  println(p)

  println("************************************** Slice   *************************")
  println(donuts.slice(2, 3))

  println("************************************** Transpose   *************************")
  //  transpose requires all collections have the same size
  val donuts1: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  val prices: Seq[Double] = Seq(1.50, 2.0, 2.50)
  val donutslist = List(donuts1, prices)
  println(donutslist)
  println(donutslist.transpose)

  println("************************************** Zip and unzip   *************************")
  val zipval = donuts1.zip(prices)
  println(zipval)
  val unzipval = zipval.unzip
  println(unzipval._1)
  println(unzipval._2)

  println("************************************** Zip withIndex   *************************")
  println(donuts1.zipWithIndex)
}
