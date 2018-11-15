package com.xiewendomg.admin.spark

import org.apache.spark.sql.SparkSession

object 中电健康云 {
  val APP_NAME="中电健康云";
  def main(args: Array[String]): Unit = {
    //创建spark
    val spark =SparkSession.builder().appName(APP_NAME).master("local[1]").getOrCreate()
    //得到sparkContext
    val sparkContext=spark.sparkContext
    val rdd=sparkContext.textFile("classpath:data.txt")

    print(rdd)
  }
}
