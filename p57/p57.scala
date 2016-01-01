package com.daystrom_data_concepts

object p57 {
  def gcd(u : BigInt, v : BigInt) : BigInt = {
    if (v != 0) gcd(v, u % v)
    else u
  }

  val rootTwo = Iterator
    .iterate((BigInt(2),BigInt(1)))({ case (n,d) => (2*n + d, n) })
    .map({ case (n,d) =>
      val numer = n-d
      val denom = d
      val divisor = gcd(numer, denom)
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
