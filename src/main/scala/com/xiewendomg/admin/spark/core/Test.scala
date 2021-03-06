package com.xiewendomg.admin.spark.core

import org.apache.spark.sql.SparkSession


object Test {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("test").getOrCreate()
    //
    val sc = spark.sparkContext
    val rddString = sc.textFile("D:\\ideaProject\\dealQuestionDemo\\src\\main\\resources\\data.txt").repartition(2);
    var s="nihao!"
    val rddSplit = rddString.map(x => {
      println(s)
      s="how?"
      println(s)
      val array = x.split(",")
      (array(0), (array(1), array(2).toDouble))
    })

    val resultRDD = rddSplit.groupByKey().map(x => {
      val orderId = x._1
      val top1 = x._2.toArray.sortWith(_._2 > _._2).take(1)
      (orderId, top1)
    }).foreach(m => {
    m._2.foreach(println)
    })
  }
}
