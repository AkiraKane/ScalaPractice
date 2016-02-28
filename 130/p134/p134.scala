package com.daystrom_data_concepts

import Euler.{ extendedEuclidean, primes }


object p134 {
  val limit = 1000000

  def power(b: Int, k: Int) = {
    var result = 1; var i = 0
    while (i < k) {result *= b; i += 1}
    result
  }

  /*
   * Solve
   *
   * p_{2}x + (-10^{d})y = p_{1}
   *
   * for y (where d is the number of digits in p_{1}).
   */
  def compute(p1: Int, p2: Int) = {
    val d = p1.toString.length
    val zeros = power(10, p1.toString.length)
    val y = extendedEuclidean(p2, -zeros % p2 + p2) match { case (_, y, _, _, _) => BigInt(y) }
    val left = (y * p1) % p2

    (if (left < 0) left + p2; else left) * zeros + p1
  }

  val solution = primes.drop(2).sliding(2)
    .takeWhile({ case Stream(p1, p2) => p1 <= limit }) // This was a gotcha
    .map({ case Stream(p1, p2) => compute(p1, p2) })
    .sum

  def main(args: Array[String]) = println(solution)
}
