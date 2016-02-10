package com.daystrom_data_concepts

import scala.collection.mutable

object p113 {

  def nonDecreasing(
    index: Int,
    limit: Int,
    digit: Int,
    state: mutable.Map[(Int, Int), Int] = mutable.Map.empty[(Int, Int), Int],
    backup: String = ""
  ): Int = {
    val nextBackup = backup ++ digit.toString

    if (index == limit) {
      println(s"${nextBackup}")
      1
    }
    else {
      val key = (index, digit)
      val cached = state.get(key)

      if (cached != None && false) cached.get
      else {
        val result = (digit to 9).map({ d => nonDecreasing(index + 1, limit, d, state, nextBackup) }).sum
        state.put(key, result)
        result
      }
    }
  }

  val solution = (0 to 9).map({ limit => nonDecreasing(0,2,limit) }).sum

  def main(args: Array[String]) = {
    println(solution)
    println
    println(Euler.natural
      .takeWhile(_ < 1000)
      .filter({ n => n.toString == n.toString.sorted /*&& n.toString != n.toString.sorted.reverse*/ })
      .length)
  }
}
