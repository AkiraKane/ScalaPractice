package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p57 {
  val rootTwo = Iterator
    .iterate((BigInt(2),BigInt(1)))({ case (n,d) => (2*n + d, n) })
    .map({ case (n,d) =>
      val numer = n-d
      val denom = d
      val divisor = Euler.gcdBig(numer, denom)
      (numer/divisor,denom/divisor)
    })
    .drop(1)

  val limit = 1000

  val solution = rootTwo
    .take(limit)
    .filter({ case(n,d) => n.toString.length > d.toString.length })
    .length

  def main(args: Array[String]) = {
    println(solution)
  }

}
