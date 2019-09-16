package com.xiewendomg.admin.spark.core

import org.apache.spark.sql.SparkSession

object 中电健康云 {
  val APP_NAME = "中电健康云"

  def main(args: Array[String]): Unit = {
    //创建spark
    val spark = SparkSession.builder().appName(APP_NAME).master("local[1]").getOrCreate()
    //得到sparkContext
    val sparkContext = spark.sparkContext
    val sparkSql = spark.sqlContext
    import sparkSql.implicits._
    val rdd = sparkContext.textFile("D:\\ideaProject\\dealQuestionDemo\\src\\main\\resources\\data.txt")
    val test = rdd.map(x => for (i <- 1 to 10000) yield i.toString)
    var accumulator = sparkContext.accumulator(0)
    //    test.collect().foreach(print)
    // 先分组，根据orderid分组，得到一个适合计算的元组
    var orderIdRdd = rdd.map(lines => {
      val array = lines.split(",")
      accumulator.add(1)
      val orderId = array(0)
      val goodId = array(1)
      val price = array(2).toDouble
      (orderId, (goodId, price))
    }).groupByKey()

    var orderIdRdds = rdd.map(lines => {
      val array = lines.split(",")
      accumulator.add(1)
      val orderId = array(0)
      val goodId = array(1)
      val price = array(2).toDouble
      (orderId, goodId, price)
    }).toDS().collect().foreach(println)


    println(orderIdRdd.getNumPartitions)
    orderIdRdd = orderIdRdd.coalesce(3, true)
    println(orderIdRdd.getNumPartitions)
    orderIdRdd = orderIdRdd.coalesce(5)
    println(orderIdRdd.getNumPartitions)
    //    val orderIdRdd2 = rdd.map(lines => {
    //      val array = lines.split(",")
    //      accumulator.add(1)
    //      val orderId = array(0)
    //      val goodId = array(1)
    //      val price = array(2).toDouble
    //      (orderId, (goodId, price))
    //    }).reduceByKey((x, y) => {
    //      (y._1,x._2+y._2)
    //    }).foreach(println)


    orderIdRdd.foreach(println)
    //    orderIdRdd.foreach(println)
    //    println(accumulator + "================================")
    //    orderIdRdd.map(m => {
    //      val orderId = m._1
    //      //将商标和价格转化为Array数组 并且按价格进行降序排列取前1
    //      accumulator.add(1)
    //      val top1 = m._2.toArray.sortWith(_._2 > _._2).take(1)
    //      (orderId, top1)
    //
    //    }).foreach(m => {
    //      print(m._1 + "价格最高的商品为")
    //      m._2.foreach(println)
    //    })
    println(accumulator + "================================")
    sparkContext.stop()

    say(1,"")
    say(1)("")(1L)

  }


  def say(int: Int)(string: String)(long: Long): Unit = {
    println("=================")
  }

  def say(int: Int, string: String): Unit = {
    println("+++++++++++++++++++")

  }

}
