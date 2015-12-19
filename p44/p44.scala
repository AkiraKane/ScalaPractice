package com.daystrom_data_concepts

object p44 {

  val pentagonal = Stream.from(1).map({ n => (3*n*n - n) / 2 })

  def isPentagonal(n : Int) = (pentagonal.takeWhile(_ <= n).last == n)

  def other(n : Int) = {
    pentagonal
      .takeWhile(_ < n)
      .reverse
      .filter({ m => isPentagonal(n - m) })
      .filter({ m => isPentagonal(n + m) })
  }

  val solution =
    pentagonal
      .map({ n => (n,other(n)) })
      .filter(_._2.nonEmpty)
      .head

  def main(args: Array[String]) = {
    println(solution._1 - solution._2.head)
  }
}
