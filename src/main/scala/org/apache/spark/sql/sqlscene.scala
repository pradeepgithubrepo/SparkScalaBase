package org.apache.spark.sql

import org.apache.spark.sql.expressions.Window
import org.apache.spark.utils.utility
import org.apache.spark.sql.functions._

object sqlscene extends utility {
  def main(args: Array[String]) = {
    val sparkses = getsparses
    var q = "";
    //    var moviesdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/movies_upd.csv")
    //    moviesdf.show(false)
    //    moviesdf.createOrReplaceTempView("movies")

    //   *******************************Find Duplicate Values*******************
    //       sparkses.sql("select * from (select * , row_number() over(partition by movie order by movie) as movierank from movies ) where movierank = 1").show(false)
    //
    //       val movie_spec = Window.partitionBy("movie").orderBy("movie")
    //       moviesdf.withColumn("movie_rank", row_number() over(movie_spec) ).where("movie_rank = 1").show(false)
    //
    //    //   Not a proper Solution
    //       sparkses.sql("select a.*  from movies a group by movie").show(false)


    //   *************** Remove duplicate vals - If Hive Write to another table , drop the first table and alter the name for new table
    //   First change the external table name to internal , then fire alter table name to change the name . Then again set it to internal
    //    $$$$$$https://stackoverflow.com/a/51840429/5773418
    //   sparkses.sql("select * from(select * , row_number() over (partition by movie order by movie) as movie_rank from movies ) where  movie_rank = 1 ").drop("movie_rank").show(false)


    // ******Search for data with specific column values , IN Exist , Like
    //    q = "select * from movies where title like '%of%'"


    //********Retrieving the latest records?
    //    val salarydf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/salary.csv")
    //    salarydf.show()
    //    salarydf.createOrReplaceTempView("salary")
    //    q = "select  * from (select * , row_number() over (partition by name order by cast(unix_timestamp(updated, 'dd.MM.yyyy') as timestamp) desc) as sal_rank from salary) where sal_rank = 1"


    //    *******************************Which customers didn’t place an order in August”
    //    https://stackoverflow.com/a/43191350/5773418
    //val customerdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/customers.csv")
    //    customerdf.createOrReplaceTempView("customer")
    //        val orderdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/order.csv")
    //        orderdf.createOrReplaceTempView("order")
    //
    //     q  = "select distinct(c.name) from customer c  LEFT JOIN order o on c.name = o.name " +
    //      "where o.orderdate between '2019-05-01' and '2019-05-30' " +
    //      "and o.name is null "

    //*******************************List employees (names) who have a bigger salary than their boss
    //    val customerdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/emp.csv")
    //    customerdf.createOrReplaceTempView("customer")
    //    val q = "select b.name from customer a , customer b where a.emp_id = b.boss_id and a.salary < b.salary"
    //    val q = "select b.name from customer a inner join customer b on a.emp_id = b.boss_id where a.salary < b.salary"
    //    Boss of current employee
    //    q = "select a.name as bossname , b.name as empname from customer a inner join customer b on a.emp_id = b.boss_id "

    // ******* *******************************  Use a scala list in IN condition in saprk sql
    //    var finallist = ""
    //     List ("emp2", "emp3").foreach(x => finallist = x +"','"+ finallist )
    //    q = s"select * from customer where name NOT IN ('${finallist}')"

    //    val nobeldf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/noble.csv")
    //    nobeldf.createOrReplaceTempView("noble")

    //    *******************************Write a SQL query to find all the details of the nobel winners for the subject not started with the letter 'P' and arranged the list as the most recent comes first, then by name in order.
    //     q = "select * from noble where SUBJECT not like 'P%' order by YEAR desc , WINNER"

    //    *******************************Date Conversion****
    //    q = "SELECT cast(date_format(cast(unix_timestamp(orderdate, 'dd.MM.yyyy') as timestamp),'yyyy-MM-dd') as date) as upd_order FROM order"

    //    *******************************Write a query in SQL to find the last name of all employees, without duplicates
    //    val employeedf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/employee.csv")
    //    employeedf.createOrReplaceTempView("employee")
    //    q = "select * from (select * ,row_number() over (partition by EMP_LNAME order by EMP_FNAME)  as emp_rank from employee) where emp_rank > 1 "

    //    *******************************Write a SQL statement to display either those orders
    //    which are not issued on date 2012-09-10 and issued by the salesman whose ID is 5005
    //    and below or those orders which purchase amount is 1000.00 and below
    val salesdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/sales2.csv")
    salesdf.createOrReplaceTempView("sales")
    //    salesdf.printSchema()
    //    q = "select * from sales where ord_date  != '2012-09-10' and salesman_id > '5005' and purch_amt <= '1000' "


    //   ******************************* Write a SQL statement to find the highest purchase amount
    //    ordered by the each customer on a particular date with their ID,
    //    order date and highest purchase amount.
    //    q = "select customer_id , cast(max(purch_amt) as Decimal(5,1)) ,ord_date from sales group by  customer_id,ord_date"


    //   ******************************* Foramtting wuery op
    //    q = "select customer_id , concat(cast(max(purch_amt) as Decimal(5,1)),'%') ,ord_date from sales group by  customer_id,ord_date"

    //Date logic -> date - 3 yrs < current date = current date else same date
    //    q= "select name ,upd_date , date_add(year , -3 ,upd_date ) as calc_date from" +
    //      "(select name , cast(date_format(cast(unix_timestamp(updated, 'yyyy-MM-dd HH:MM:SS') as timestamp),'yyyy-MM-dd') as date) as upd_date  from salary)"


    //    *********************JOINS
    val salesmandf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/salesman.csv")
    salesmandf.createOrReplaceTempView("salesman")
    val customerdf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/customers.csv")
    customerdf.createOrReplaceTempView("customer")

    //    *****************Write a query to find those customers with their name and those salesmen
    //    with their name and city who lives in the same city
    //    q = "select s.name as salesman_name , s.city , c.cust_name from salesman s inner join customer c on  s.city = c.city"

    //    *****************Write a SQL statement to display all those orders by the customers
    //    not located in the same cities where their salesmen live.
    //    q = "select o.ord_no , o.customer_id from (select c.customer_id , c.salesman_id from customer c , salesman s  where c.city <> s.city and" +
    //      " s.salesman_id = c.salesman_id)d inner join sales o on d.customer_id =o.customer_id "


    //    *****************Write a SQL statement that finds out each order number followed by the name of the customers who made the order
    //    q = "select o.ord_no , c.cust_name from sales o inner join customer c on  o.customer_id = c.customer_id"

    //    *****************Write a SQL statement that sorts out the customer and their grade who made an order.
    //    Each of the customers must have a grade and served by at least a salesman, who belongs to a city
    //    q = "select * from (select c.cust_name ,c.city, c.grade ,s.salesman_id from customer c inner join salesman s  on c.salesman_id = s.salesman_id where c.grade is not null)d "

    //   ***************** Write a query that produces all customers with their name, city, salesman and commission,
    //    who served by a salesman and the salesman works at a rate of the commission within 12% to 14%.
    //    q = "select c.cust_name , c.city , s.name , s.commission from salesman s inner join customer c on s.salesman_id = c.salesman_id where s.commission between 0.12 and 0.14"

    //   ***************** Write a SQL statement to find the list of customers who appointed a salesman for their jobs
    //    who gets a commission from the company is more than 12%.
    //    q = "select c.cust_name from customer c left join salesman s on c.salesman_id = s.salesman_id where s.commission > 0.12  and c.cust_name is not null"

    //    ********Write a query to display all the orders from the orders table issued by the salesman 'Paul Adam'.
    //    q="select ord_no from sales where salesman_id in (select salesman_id from salesman where  name = 'Paul Adam')"

    //   ******** Write a query in SQL to display the employee ID and the date on which he ended his previous job.
    //    val historydf = sparkses.read.format("csv").option("header", true).option("InferSchema", true).load("/Users/pradeepp/Desktop/AzureProcesingframework/SparkScalaBase/resources/deltatable/history.csv")
    //    historydf.createOrReplaceTempView("history")
    //    q = "select first(EMPLOYEE_ID),count(*) as emp_count , max(END_DATE) from history group by EMPLOYEE_ID having emp_count > 1"

    //    ********Write a query in SQL to display job ID for those jobs that were done by two or more for more than 300 days.
    //        q = "select distinct(jobid) from (select first(JOB_ID) as jobid ,count(*) as jobcount from history group by JOB_ID having jobcount > 1) union" +
    //     "(select JOB_ID as jobid from history where datediff(END_DATE,START_DATE) > 300)"

    //    ********Complex Union
    //    Write a query that produces the name and number of each salesman and each customer with more than one current order.
    //    Put the results in alphabetical order
    //    q = "select customer_id , cust_name from customer where customer_id in (select customer_id from (select customer_id , count(*) as custcount from sales group by  customer_id  having custcount > 1))"

    //    ********case statments
    //    q = "select city ,case when city = 'New York' then 'USA' " +
    //      "when city ='Paris' then 'France' " +
    //      "when city ='London' then 'England' " +
    //      "when city ='Rome' then 'Italy' " +
    //      "else 'unknown' end as country" +
    //      " from salesman"

    //    ********complex datastructures --. collect_set
    //      q = "select collect_set(struct(name as salesman_name , city as salesman_city )) as global_struct from salesman"

    //   ********Build as a a struct
    q = "select struct(name as salesman_name , city as salesman_city ) as global_struct from salesman"
    //
    sparkses.sql(q).show(false)
  }
}
