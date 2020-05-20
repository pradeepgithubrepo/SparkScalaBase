package org.apache.spark.basics
import org.apache.spark.sql.SparkSession

object serialiation {

  def main(args: Array[String]): Unit = {
      val sparkses = SparkSession.builder().master("local").appName("serilization").getOrCreate()
//       val data = List(1,2,3,4,5,6,7,8,9)
//       val pprdd  = sparkses.sparkContext.parallelize(data)
//       val filterrdd = pprdd.filter(_ % 2 ==0)
//       val maprdd = filterrdd.map(x => x+1)
//       maprdd.cache()
//    maprdd.count()
    import sparkses.implicits._
    val tbl1 = Seq("1","1","2","2").toDF("id")
    tbl1.createOrReplaceTempView("tbl1")
    val tbl2 = Seq("1","1","2",null).toDF("id")
    tbl2.createOrReplaceTempView("tbl1")

    println("Inner join")
    tbl1.join(tbl2,Seq("id"),"inner").show(false)
    println("Left join")
    tbl1.join(tbl2,Seq("id"),"left").show(false)
    println("Right join")
    tbl1.join(tbl2,Seq("id"),"right").show(false)
    println("Full join")
    tbl1.join(tbl2,Seq("id"),"full").show(false)
    println("Full join")
    tbl1.join(tbl2,Seq("id"),"full").show(false)
    println("Mapjoin join")
    tbl1.join(tbl2.hint("broadcast"),Seq("id")).show(false)

  }
}
