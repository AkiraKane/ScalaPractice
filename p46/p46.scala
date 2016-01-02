package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p46 {
  import math.{ceil,sqrt}

  def writable(n : BigInt) = {
    Euler.primesBig
      .takeWhile(_ < n)
      .flatMap({ a =>
        Iterator.iterate(BigInt(1))(_ + 1)
          .takeWhile(_ < (n-a)/2 + 1)
          .filter({ b => (a + 2*b*b == n) })
          .map({ b => (a,b) })
      })
      .nonEmpty
  }

  lazy val solution = Iterator.iterate(BigInt(3))(_ + 2)
    .filter(!Euler.isPrimeBig(_))
    .filter(!writable(_))
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
