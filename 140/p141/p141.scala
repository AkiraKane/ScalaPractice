package com.daystrom_data_concepts

import scala.collection.mutable


object p141 {
  val limit = BigInt("1000000000000")

  val squares = Stream.iterate(BigInt(0))(_ + 1)
    .map({ i => i*i })
    .takeWhile(_ < limit)
    .toSet

  @inline def n(a: BigInt, b: BigInt, c: BigInt) = a*a*a*b*c*c + b*b*c

  val solution = {
    val seen = mutable.Set.empty[BigInt]

    var a: BigInt = 2; while (a*a*a < limit) {
      var b: BigInt = 1; while (b < a) {
        var c: BigInt = 1; while (n(a,b,c) < limit) {
          if (squares.contains(n(a,b,c)) && !seen.contains(n(a,b,c))) {
            seen += n(a,b,c)
            c = limit
          }
          c += 1
        }
        b += 1
      }
      a += 1
    }
    seen.sum
  }

  def main(args: Array[String]) = println(solution)
}
