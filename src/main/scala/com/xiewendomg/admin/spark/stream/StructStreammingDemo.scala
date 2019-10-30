package com.xiewendomg.admin.spark.stream

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object StructStreammingDemo {
  def main(args: Array[String]): Unit = {
    //获取程序入口sparkSession
    val sparksession = SparkSession.builder().appName("StructuredStreamingDemo")
      .master("local[2]").getOrCreate()

    import sparksession.implicits._
    val lines: DataFrame = sparksession.readStream.format("socket")
      .option("host", "192.168.1.11")
      .option("port", "9999").load()

    val lineds: Dataset[String] = lines.as[String]
    val res = lineds.flatMap(_.split(" ")).groupBy("value").count()
    //将结果写到控制台
    val res2 = res.writeStream.outputMode("complete").format("console").start()
    res2.awaitTermination()

  }

}
