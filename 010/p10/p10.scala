package com.daystrom_data_concepts

object p10 {
  val limit = 2000000
  val solution = Euler.primes.toIterator
    .takeWhile(_ < limit)
    .map(BigInt(_))
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
