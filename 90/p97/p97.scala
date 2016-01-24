package com.daystrom_data_concepts


object p97 {
  val mod = BigInt("10000000000000000000000000")

  val huge =  {
    var i = 0
    var result = BigInt(1)
    while (i < 7830457) {
      result = (result * 2) % mod
      i += 1
    }
    result * 28433 + 1
  }

  val solution = huge.toString.reverse.take(10).reverse

  def main(args: Array[String]) = println(solution)
}
