package com.daystrom_data_concepts

import math.{ceil, floor}
import scala.collection.mutable


object p121 {
  type ReturnType = Map[Int, BigInt]

  def simulate(n: Int): ReturnType = {
    if (n == 1) Map(0 -> BigInt(1), 1 -> BigInt(1))
    else {
      val previous = simulate(n-1)
      val r = previous.map({ case (blues, count) => (blues, count * n) })
      val b = previous.map({ case (blues, count) => (blues + 1, count) })

      (r.toList ++ b.toList).groupBy(_._1)
        .map({ case (number, list) => (number, list.map(_._2).sum) })
        .toMap
    }
  }

  def pounds(n: Int) = {
    val result = simulate(n)
    val denom = result.map(_._2).sum
    val numer = result.filter(_._1 > (n/2.0)).map(_._2).sum

    denom / numer
  }

  val n = 15
  val solution = pounds(n)

  def main(args: Array[String]) = println(solution)
}
