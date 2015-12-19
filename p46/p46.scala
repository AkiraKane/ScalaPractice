package com.daystrom_data_concepts

object p46 {
  import math.{ceil,sqrt}

  def prime(n : BigInt) : Boolean = {
    var a : BigInt = 2
    while (a < n) {
      if (n % a == 0) return false
      a += 1
    }
    return true
  }

  val primes = Stream.iterate(BigInt(2))(_ + 1).filter(prime(_))

  def writable(n : BigInt) = {
    primes
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
    .filter(!prime(_))
    .filter(!writable(_))
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
