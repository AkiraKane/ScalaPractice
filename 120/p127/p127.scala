package com.daystrom_data_concepts

import scala.collection.mutable
import Euler.gcd


object p127 {
  val limit = 120000

  val primes = 2 #:: Stream.iterate(BigInt(3))(_ + 1)
    .filter({ n => n.isProbablePrime(1000) })
    .takeWhile(_ <= limit)

  val rads = Stream.iterate(1)(_ + 1)
    .takeWhile(_ <= limit)
    .map({ n => (n, primes.filter({ p => n % p == 0 }).product) })
    .toMap

  def rad(n: Int) = rads.get(n).get

  val solution = {
    var tally = 0
    var a = 1
    while (a < limit) {
      var b = a + 1
      while (a + b < limit) {
        val c = a + b
        if (gcd(a,b) == 1 && rad(a)*rad(b)*rad(c) < c) tally += c
        b += 1
      }
      a += 1
    }
    tally
  }

  def main(args: Array[String]) = println(solution)
}
