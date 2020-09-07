package org.apache.spark.sql

import org.apache.spark.utils.utility

object interview extends App with utility {
  val sparkses = getsparses

  import sparkses.implicits._

  val salarydf = Seq((1, 1, 0, "manager", 80000),
    (2, 1, 1, "emp1", 60000),
    (3, 1, 1, "emp2", 50000),
    (4, 1, 1, "emp3", 95000),
    (5, 1, 1, "emp4", 75000)
  ).toDF("emp_id", "dept_id", "boss_id", "name", "salary")
  var q = ""
  salarydf.createOrReplaceTempView("salary")
  q = "select b.name from salary a inner join salary b on a.emp_id = b.boss_id where a.salary < b.salary"

  sparkses.sql(q).show(false)

}
