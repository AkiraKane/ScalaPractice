package com.daystrom_data_concepts


object p119 {
  def power(b: Int, e: Int): BigInt = {
    var i = e
    var result = BigInt(1)
    while (i > 0) {
      result *= b
      i -= 1
    }
    result
  }

  val solution = (for(b <- 1 to 1000; e <- 1 to 100) yield (power(b, e), b))
    .filter({ case(n, b) => n.toString.map(_ - '0').sum == b })
    .toList
    .distinct
    .sorted
    .drop(9)
    .take(30)
    .map(_._1)
    .last

  def main(args: Array[String]) = println(solution)
}
