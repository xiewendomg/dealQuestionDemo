package com.xiewendomg.admin.spark

import org.apache.spark.sql.SparkSession

object 中电健康云 {
  val APP_NAME="中电健康云"
  def main(args: Array[String]): Unit = {
    //创建spark
    val spark =SparkSession.builder().appName(APP_NAME).master("local[1]").getOrCreate()
    //得到sparkContext
    val sparkContext=spark.sparkContext
    val rdd=sparkContext.textFile("D:\\ideaProject\\dealQuestionDemo\\src\\main\\resources\\data.txt")
    //map 函数
    val mapResult1=rdd.map(line=>line.split(",")).collect()
    //flatMap 函数
    val mapResult2=rdd.flatMap(line=>line.split(",")).collect()
    mapResult1.map(x=>(x(0),(x(1),x(2).toDouble)))

  }
}
