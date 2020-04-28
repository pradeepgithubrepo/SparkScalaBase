package org.apache.spark.basics
import org.apache.spark.utils._


object runner extends App  with utility {
  val sparsses = getsparses
  val lookup = Map("This" -> "frequent", "is" -> "frequent")
  val lookupbc = sparsses.sparkContext.broadcast(lookup)

  println(lookupbc.value.get("This"))
  def lookupfunc(x : String):(String,String) =
    (x,lookupbc.value.get(x).getOrElse("No Text"))

  val rdd = sparsses.sparkContext.parallelize(Seq("Roses are red", "Violets are blue"))
  val dummymaprdd = rdd.map(_.split(" "))
  dummymaprdd.foreach(x => for( i <- x) println(i))

  val maprdd = rdd.map(_.length)
  val flatmaprdd = rdd.flatMap(x => x.split(" ")).map(_.length)
  maprdd.foreach(println)
  flatmaprdd.foreach(println)

  val flattenrdd = rdd.flatMap(x => x.split(" "))
  val pairrdd = flattenrdd.map(x => (x,1)).reduceByKey((k,v) => v+1)
  pairrdd.foreach(println)

  val jsondf = sparsses.read.format("json").load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/sample.json")
  jsondf.printSchema()
  jsondf.show()


}
