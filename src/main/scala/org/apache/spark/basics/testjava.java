package org.apache.spark.basics;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import scala.Tuple2;
import scala.collection.immutable.Seq;
import org.apache.spark.sql.SparkSession.implicits$;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class testjava  {
    public static void main(String[] args) {

    }
    void process(){
        SparkSession sparkses = SparkSession
                .builder()
                .appName("Application Name")
                .config("some-config", "some-value")
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(sparkses.sparkContext());

        String[] l = new String[] { "a", "b", "c", "d" };
        List<String> data = Arrays.asList(l);
        Dataset<String> ds = sparkses.createDataset(data, Encoders.STRING());
        Dataset<Row> df = ds.toDF();
        df.show();
    }
}

class anotherclass{

}
