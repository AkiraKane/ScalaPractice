package com.daystrom_data_concepts

import math.sqrt
import scala.collection.mutable

object p80 {
  val limit = 100
  val zeros = Iterator.fill(300)(BigInt(10)).product

  /* Calculate  lots of decimal digits  of the square root  of n using
   * Newton's  Method.  Newton's  method  converges quadratically,  so
   * this many iterations probably are not needed.*/
  def newton(n : Int, iterations : Int = 1000) = {
    val N = zeros * n
    var xn = zeros
    var i = iterations
    while (i >= 0) {
      val change = (xn - N/xn)/2
      xn -= change
      i -= 1
    }
    xn
  }

  /* Calculate the  score of n based on the  problem description.  The
   * square  root of  integer n  is rational  if and  only if  n is  a
   * perfect square.  Perfect squares get  a score of zero, all others
   * are the sum of the first 100 digits of the square root. */
  def score(n: Int) = {
    val root = sqrt(n).toInt
    if (root * root == n) 0
    else
      newton(n)
        .toString
        .take(100)
        .map(_ - '0')
        .sum
  }

  val solution = Euler.natural
    .take(limit)
    .map(score)
    .sum

  def main(args: Array[String]) = println(solution)
}
