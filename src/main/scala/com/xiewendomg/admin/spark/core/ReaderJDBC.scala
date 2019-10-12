package com.xiewendomg.admin.spark.core

import org.apache.spark.sql.SparkSession

object ReaderJDBC {
  def main(args: Array[String]): Unit = {
    val spark= SparkSession.builder().appName("JDBC").master("local").getOrCreate()
//    spark.read.jdbc();
//    spark.read.format()
  }
}
