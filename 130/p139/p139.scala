package com.daystrom_data_concepts

import Euler.gcd


object p139 {
  val limit = 100000000

  def aux(m: BigInt, n: BigInt) = {
    val a = m*m - n*n
    val b = 2*m*n
    val c = m*m + n*n

    (a, b, c)
  }

  // // https://en.wikipedia.org/wiki/Pythagorean_triple
  // def triangles(m: BigInt) = {
  //   Iterator.iterate(BigInt(1))(_ + 1)
  //     .takeWhile({ n => (n < m) && ((2*m*m + 2*m*n) < limit) })
  //     .filter({ n => (gcd(n,m) == 1) && ((m - n) % 2 == 1) })
  //     .map({ n => aux(m, n) })
  // }

  // val solution = Iterator.iterate(BigInt(1))(_ + 1)
  //   .takeWhile({ m => (2*m*m + 2*m) < limit })
  //   .flatMap({ m => triangles(m) })
  //   .filter({ case (a,b,c) => c % (b-a) == 0 })
  //   .map({ case (a,b,c) => limit / (a+b+c) })
  //   .sum

  val solution = {
    var count = 0

    var m = 1
    while (2*m*m + 2*m < limit) {
      var n = 1
      while ((n < m) && (2*m*m + 2*m*n < limit)) {
        if ((gcd(n,m) == 1) && ((m-n) % 2 == 1)) {
          val a = m*m - n*n
          val b = 2*m*n
          val c = m*m + n*n
          if (c % (b-a) == 0) count += (limit / (a+b+c))
        }
        n += 1
      }
      m += 1
    }
    count
  }

  def main(args: Array[String]) = println(solution)
}
