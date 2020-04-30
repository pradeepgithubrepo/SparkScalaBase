package org.apache.spark.basics

import org.apache.spark.basics.dfoperations.getsparses
import org.apache.spark.utils._
object rddoperations extends  App with utility {
  val words = Array("one", "two", "two", "three", "three", "three")
  val sparsses = getsparses

  import sparsses.implicits._

  val wordsrdd = sparsses.sparkContext.parallelize(words).map(x => (x ,1)).groupByKey().map(x => (x._1,x._2.sum))

  wordsrdd.foreach(println)

  val wordsrdd1 = sparsses.sparkContext.parallelize(words).map(x => (x,1)).reduceByKey((k,v) => v+1)
  wordsrdd1.foreach(println)
}
