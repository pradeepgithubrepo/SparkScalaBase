package org.apache.spark.utils
import org.apache.spark.sql.SparkSession
trait utility extends Serializable {
 def getsparses = SparkSession.builder().master("local").appName("legend").getOrCreate()

 def combine(a : String , b: String , c : String) : String = {
  a+":"+b+":"+c
 }
}
