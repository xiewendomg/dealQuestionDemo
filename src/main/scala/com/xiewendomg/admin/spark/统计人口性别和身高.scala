package com.xiewendomg.admin.spark

import org.apache.spark.sql.SparkSession

object 统计人口性别和身高 {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[1]").appName("统计人口性别和身高").getOrCreate()
    //得到sparkContext
    val sparkContext = spark.sparkContext;
    //加载数据
    val dataRDD = sparkContext.textFile("D:/ideaProject/dealQuestionDemo/src/main/resources/peopleinfo.txt")
    //得到身高和性别的元组
    val sexHeightRDD = dataRDD.map(line => line.split(",")).map(x => {
      val number = x(0)
      val sex = x(1)
      val height = x(2)
      (sex, height.toInt)
    })
    sexHeightRDD.foreach(println)
    //找性别总人数
    val map = sexHeightRDD.countByKey()
    sexHeightRDD.groupByKey().foreach(println)
    sexHeightRDD.groupByKey().map(x => {
      val sex = x._1
      val top1 = x._2.max
      val low = x._2.min
      (sex, top1, low)
    }).foreach(println)

    map.keys.foreach(key => {
      if ("F".equals(key)) {
        println("性别为女的人数=" + map(key))
      }
      if ("M".equals(key)) {
        println("性别为男的人数=" + map(key))
      }
    })

  }
}
