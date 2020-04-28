package org.apache.spark.utils
import org.apache.spark.sql.SparkSession
trait utility {
 def getsparses = SparkSession.builder().master("local").appName("legend").getOrCreate()
}
