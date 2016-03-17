package com.daystrom_data_concepts

import java.lang.Long


object p148 {
  val limit = 1000000000

  @inline def score(n: Int) = {
    val str = Long.toString(n, 7)
    val length = str.length
    var result: BigInt = 1

    var i = 0; while(i < length) {
      result *= (1 + str(i) - '0')
      i += 1
    }
    result
  }

  val solution = {
    var result: BigInt = 0

    var i = 0; while (i < limit) {
      result += score(i)
      i += 1
    }
    result
  }

  def main(args: Array[String]) = println(solution)
}
