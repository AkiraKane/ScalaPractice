package com.daystrom_data_concepts

object p28 {
  def width(n : Int) = 2*n + 1

  def cornerSum(n : Int) = {
    if (n == 0) 1
    else {
      val top = width(n) * width(n)
      val bot = width(n-1) * width(n-1)
      val circumference = top - bot
      val lengths = circumference / 4
      (4 * top) - (6 * lengths)
    }
  }

  val limit = 1001

  val solution = Stream.from(0)
    .takeWhile({ n => width(n) <= limit })
    .map(cornerSum)
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
