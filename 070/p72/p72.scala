package com.daystrom_data_concepts

object p72 {
  val limit = 1000000

  val solution = Euler.natural
    .take(limit)
    .drop(1)
    .map({ n => BigInt(Euler.phi(n).toInt) })
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
