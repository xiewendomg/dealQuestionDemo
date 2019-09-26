package com.xiewendomg.admin.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object JoinTest {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("wordCount").setMaster("local[1]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val words = Array("one", "two", "two", "three", "three", "three")
    val kvRdd = sc.parallelize ( List ((1,null), (1, "b"), (1, "c") , (2, "b"),(2, "c"), (3, "d") ) , 2)
    val kvRdd2 = sc.parallelize ( List ((1,"A"), (1, null), (1, "C") , (2, "B"),(2, "C"), (3, "D") ) , 2)
    val rdd=kvRdd.leftOuterJoin(kvRdd2);
   /* rdd.map(x=>{
      if(x._2._1.is){
        (x._2._1,x._2._2)
      }
    }).foreach(println)*/
//    rdd.foreach(println)
    val cogroupKVrdd=kvRdd.cogroup(kvRdd2)
//    cogroupKVrdd.foreach(println)
    val joinKVrdd=kvRdd.join(kvRdd2);
//    joinKVrdd.foreach(println)
    val fullOuterJoin=kvRdd.fullOuterJoin(kvRdd2);
//    fullOuterJoin.foreach(println)
    fullOuterJoin.map(x=>{
      (x._1,x._2._1)
    }).foreach(println)
    val s=""
    fullOuterJoin.map(x=>{
//      if(x._2._1.getOrElse("uu"))
      (x._1,x._2._1.getOrElse("+++"))
    }).foreach(println)
  /*  val wordPairsRDD = sc.parallelize(words).map(t => (t, 1))
    val wordCountsWithReduce = wordPairsRDD.reduceByKey(_ + _).collect().foreach(println)
    val wordCountsWithGroup = wordPairsRDD.groupByKey().map(t => (t._1, t._2.sum)).collect().foreach(println)*/
    sc.stop()
  }

  def main2(args: Array[String]): Unit = {
//    sign()
    getPeople()
  }

  class Student(val name: String)

  class Older(val name: String)

  class SpecialPeople(val name: String)

 implicit def change(o: Object): SpecialPeople = {
    if (o.isInstanceOf[Student]) {
      var s = o.asInstanceOf[Student]
      new SpecialPeople(s.name)
    } else if (o.isInstanceOf[Older]) {
      var l = o.asInstanceOf[Older]
      new SpecialPeople(l.name)
    } else {
      null
    }
  }

  var ticketNumber = 0

  def buySpecialPeopleTickit(specialPeople: SpecialPeople): Unit = {
    ticketNumber += 1
    println("T-" + ticketNumber)
  }

  def getPeople(): Unit = {
    val student=new Student("hua!")
    buySpecialPeopleTickit(student)
  }


  class SignPeople {
    def write(content: String): Unit = {
      println(content)
    }
  }

  /**
    * 隐式参数
    */
  def sign(): Unit = {
    implicit val signn = new SignPeople
    signForExam("leo")

  }

  def signForExam(name: String)(implicit sign: SignPeople): Unit = {
    sign.write(name + " come to exam in time!")
  }

  def accumulator(): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("accumulator")
    val sc = new SparkContext(conf)
    val accumulator = sc.accumulator(0)
    sc.parallelize(Array("one", "two", "two", "three", "three", "three"), 2).foreach { //两个变量
      x => {
        accumulator.add(1)
        println(accumulator)
      }
    }
    println(accumulator.value)
    sc.stop()
  }
}
