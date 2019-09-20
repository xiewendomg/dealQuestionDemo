package com.xiewendomg.admin.spark.stream

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

object 流处理累加 {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder().appName("test").master("local[1]").getOrCreate()
    //创建Streaming的对象
    val sc = spark.sparkContext
    val scc = new org.apache.spark.streaming.StreamingContext(sc, Seconds(1))
    scc.checkpoint("./")
    val addFunc = parseMethod _
    //监控源,并得到接收的数据
    var lines = scc.socketTextStream("192.168.1.11", 9999)
    //lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).print()
    lines.flatMap(_.split(" ")).map((_, 1)).updateStateByKey[Int](addFunc).print()

    //启动
    scc.start()
    scc.awaitTermination()
  }

  def parseMethod(currValues: Seq[Int], prevValueState: Option[Int]) = {
    println("=============已经进来了======")
    //通过Spark内部的reduceByKey按key规约，然后这里传入某key当前批次的Seq/List,再计算当前批次的总和
    val currentCount = currValues.sum
    // 已累加的值
    val previousCount = prevValueState.getOrElse(0)
    // 返回累加后的结果，是一个Option[Int]类型
    Some(currentCount + previousCount)
  }
}
