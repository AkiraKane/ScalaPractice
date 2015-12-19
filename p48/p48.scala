package com.daystrom_data_concepts

object p48 {
  def power(n : Int) = Iterator.fill(n)(BigInt(n)).product

  val limit = 1000

  val solution = Iterator.range(1, limit+1)
    .map(power(_))
    .sum
    .toString
    .reverse.take(10).reverse

  def main(args: Array[String]) = {
    println(solution)
  }
}
