package functional_programming.concept.tail_recursion

import scala.annotation.tailrec

/**
  * Created by Sangwook on 2016-05-15.
  * Ref: http://hanmomhanda.github.io/2015/07/27/%EC%9E%AC%EA%B7%80-%EB%B0%98%EB%B3%B5-Tail-Recursion/
  */
class Fibonacci {
  def calculateIter(n: Int): Int = {
    var curVal = 0
    var prevVal = 1
    var prevprevVal = 0
    if (n < 2) { n }
    for (i <- 2 to n) {
      curVal = prevVal + prevprevVal
      prevprevVal = prevVal
      prevVal = curVal
    }
    curVal
  }

  def calculateRec(n: Int): Int = n match {
    case n if (n < 2) => n
    case _ => { calculateRec(n -1) + calculateRec(n - 2) }
  }

  @tailrec
  private def calculateTailRecUtil(n: Int, prevVal: Int, prevprevVal: Int): Int = n match {
    case 0 => prevprevVal
    case 1 => prevVal
    case _ => calculateTailRecUtil(n - 1, prevVal + prevprevVal, prevVal)
  }

  def calculateTailRec(n: Int): Unit = {
    calculateTailRecUtil(n, 1, 0)
  }
}

object FibonacciApp {
  def main(args: Array[String]): Unit = {
    val fiboObj = new Fibonacci

    println("Iterative: " + fiboObj.calculateIter(6))
    println("Recursive: " + fiboObj.calculateRec(6))

    val result = fiboObj.calculateTailRec(6)
    println("Tail recursive: " + result)
  }
}
