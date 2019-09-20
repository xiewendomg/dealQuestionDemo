package com.xiewendomg.admin.spark.core

import org.apache.spark.sql.SparkSession


object Test {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("test").getOrCreate()
    val sc = spark.sparkContext
    val rddString = sc.textFile("");
    val rddSplit = rddString.map(x => {
      val array = x.split(",")
      (array(0), (array(1),array(2).toDouble))
    })
    rddSplit.groupByKey().map(x=>{
      val orderId=x._1
      val top1=x._2.toArray.sortWith(_._2>_._2).take(1)
      (orderId,top1)
    })
  }
}
