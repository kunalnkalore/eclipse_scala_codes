package revision
//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession  // Packages for Spark SQL
import org.apache.spark.sql.DataFrame     // In order to transfer DF from 1 method to another method
import org.apache.spark.sql.functions._   // In order to process the data --> will have aggregations, joins
import org.apache.spark.sql.Row           // Converting the RDD to DF --> used in Struct Method
import org.apache.spark.sql.types._       // covered in later topics
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField

object contxtconf {
  def main(args:Array[String])
  {
    val conf = new SparkConf().setAppName("XYZ").setMaster("local[*]").set("spark.driver.allowMultipleContexts","true")
    val sc = new SparkContext(conf)
     sc.setLogLevel("Error")
   
    if (args.length < 2) {
      println("2 args needed")
      System.exit(1)
    }

    val rawrdd = sc.textFile(args(0))
    val words = rawrdd.flatMap(line => line.split(" "))
    val wrdcnt = words.map(word => (word,1)).reduceByKey(_+_)
    wrdcnt.saveAsTextFile(args(1))

/* 
	*****  
val data = sc.parallelize(Array(('A',1),('b',2),('c',3)))
val data2 = sc.parallelize(Array(('A',4),('A',6),('b',7),('c',3),('c',8)))
val result = data.join(data2)
println(result.collect().mkString(","))
val r2 = data.union(data2)
println(r2.collect().mkString(","))
	*****
*/
    
  }
}