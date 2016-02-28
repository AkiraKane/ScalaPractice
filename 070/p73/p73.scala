package com.daystrom_data_concepts

object p73 {
  val limit = 12000

  def fromD(d: Int) = {
    val lower = d / 3.0
    val upper = d / 2.0

    Euler.natural
      .dropWhile({ n => lower >= n }).takeWhile({ n => n < upper })
      .map({ n =>
        val gcd = Euler.gcd(n,d)
        (n / gcd, d / gcd) })
  }

  val solution = Euler.natural
    .drop(3).takeWhile(_ <= limit)
    .flatMap(fromD).distinct.length

  def main(args: Array[String]) = {
    println(solution)
  }
}
