package revision

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

object interviewcode {
  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("RDD top 10 SportsTypes").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val rdd1 = sc.textFile("file:///D:/Projects/Data/txs.csv")
    rdd1.take(10)
    val splitRDD = rdd1.map(x => x.split(",")(4))
    splitRDD.take(10)
    
    val countRDD = splitRDD.countByValue()
    println(s"count values: \n $countRDD")
    
    val sortedRDD = countRDD.toList.sortBy(-_._2)
    println(s"sorted file: \n $sortedRDD")
    
    println("Top 10 Sports Types are as follow :~")
    val top10val = sortedRDD.take(10)
    
  }

}

