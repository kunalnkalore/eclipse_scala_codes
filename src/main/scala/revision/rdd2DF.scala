package revision

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object rdd2DF {
  
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("RDD to Dataframe conversion").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val spark = SparkSession.builder().getOrCreate()
    
    val rdd = sc.textFile("file:///D:/Projects/Data/txs.csv")
    val rdd1 = rdd.map(x => x.split(","))
    val rdd2 = rdd1.map(x => (x(0).toInt, x(1), x(2), x(3).toDouble,x(4)))
    
    import spark.implicits._
    
    val df = rdd2.toDF("txnid","txndate","custid","amount","category")
    df.show()
    df.printSchema()
    
  }
  
}