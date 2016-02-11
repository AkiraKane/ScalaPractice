package com.daystrom_data_concepts

import scala.collection.mutable

object p113 {

  def nonBouncyHalf(
    index: Int,
    n: Int,
    digit: Int,
    nonDecreasing: Boolean,
    state: mutable.Map[(Int, Int), BigInt] = mutable.Map.empty[(Int, Int), BigInt]
  ): BigInt = {
    if (index == n) BigInt(1)
    else {
      val key = (index, digit)
      val cached = state.get(key)

      if (cached != None) cached.get
      else {
        val range =
          if (nonDecreasing) (digit to 9) // "Increasing"
          else (0 to digit) // "Decreasing"
        val result = range.map({ d => nonBouncyHalf(index + 1, n, d, nonDecreasing, state) }).sum
        state.put(key, result)
        result
      }
    }
  }

  def nonBouncy(zeros: Int): BigInt = {
    val raw =
      (0 until zeros).flatMap({ n =>
        (1 to 9).map({ digit => nonBouncyHalf(0, n, digit, true) + nonBouncyHalf(0, n, digit, false) })
      }).sum
    val duplicate = 9 * zeros

    raw - duplicate
  }

  val solution = nonBouncy(100)

  def main(args: Array[String]) = println(solution)
}
