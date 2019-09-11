package com.xiewendomg.admin.spark

import org.apache.spark.sql.SparkSession

object 中电健康云 {
  val APP_NAME = "中电健康云"

  def main(args: Array[String]): Unit = {
    //创建spark
    val spark = SparkSession.builder().appName(APP_NAME).master("local[1]").getOrCreate()
    //得到sparkContext

    val sparkContext = spark.sparkContext
    val rdd = sparkContext.textFile("D:\\ideaProject\\dealQuestionDemo\\src\\main\\resources\\data.txt")
    val test=rdd.map(x=>for(i <- 1 to 10000) yield i.toString)
    test.collect().foreach(print)
    // 先分组，根据orderid分组，得到一个适合计算的元组
    val orderIdRdd = rdd.map(lines => {
      val array = lines.split(",")
      val orderId = array(0)
      val goodId = array(1)
      val price = array(2).toDouble
      (orderId, (goodId, price))
    }).groupByKey()
    orderIdRdd.foreach(println)
      orderIdRdd.map(m=>{
        val orderId=m._1
        //将商标和价格转化为Array数组 并且按价格进行降序排列取前1
        val top1=m._2.toArray.sortWith(_._2>_._2).take(1)
        (orderId,top1)
      }).foreach(m=>{
        print(m._1+"价格最高的商品为")
        m._2.foreach(println)
      })

  }
}
