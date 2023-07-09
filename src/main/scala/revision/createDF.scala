package revision

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd
import org.apache.spark.sql.Row
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._


object createDF {
  def main(args:Array[String]) {
    
    val conf = new SparkConf().setAppName("create DF").setMaster("local[*]").set("spark.driver.allowMultipleContext","true")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")
    
    val spark = SparkSession.builder().getOrCreate()
    
    import spark.implicits._
    
    val df = spark.read.format("csv")
             .option("delimiter",",")
             //.option("header", true)
             //.option("inferschema", true)
             .load("file:///D:/Projects/Data/txs.csv")
             .toDF("id","date","custid","amt","category","product","city","state","mode")
    df.show(10)
    
   
    
  }
  
  
}