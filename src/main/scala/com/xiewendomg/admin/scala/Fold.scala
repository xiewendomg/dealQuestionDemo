package com.xiewendomg.admin.scala

object Fold {
  def main(args: Array[String]): Unit = {
    val number = List(2, 3, 4, 2, 123)
    // 0初始值 x代表一次运行的结果，第一次为初始值0 ，y为list集合的下一个元素，第一次为2
    val result = number.fold(0) { (x, y) => x + y }
    println(result)
    var s = "你好"
    throwableToLeft { s.toUpperCase } match {
      case Right(s) => println(s)
      case Left(e) => e.printStackTrace
    }
    s = null;
    throwableToLeft { s.toUpperCase } match {
      case Right(s) => println(s)
      case Left(e) => e.printStackTrace
    }

  }


  def throwableToLeft[T](block: => T): Either[java.lang.Throwable, T] =
    try {
      Right(block)
    } catch {
      case ex => Left(ex)
    }
}
