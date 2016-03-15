package com.daystrom_data_concepts

import Euler.natural


object p146 {
  val limit = 150000000

  val solution = Stream
    .iterate(10)(_ + 10) // Divisible 2 otherwise i^2 + 1 divisible by 2, divisible by 5 otherwise either i^2 + 1 or i^2 + 4 divisible by 5
    .takeWhile(_ <= limit)
    .filter({ i => i % 3 != 0 }) // Otherwise i^2 + 3 divisible by 3
    .filter({ i => i % 7 != 0 }) // Otherwise i^2 + 7 divisible by 7
    .filter({ i => i % 13 != 0 }) // Otherwise i^2 + 13 divisible by 13
    .map({ i => BigInt(i) })
    .filter({ i => (i*i + 1).isProbablePrime(100) })
    .filter({ i => (i*i + 3).isProbablePrime(100) })
    .filter({ i => (i*i + 7).isProbablePrime(100) })
    .filter({ i => (i*i + 9).isProbablePrime(100) })
    .filter({ i => (i*i + 13).isProbablePrime(100) })
    .filter({ i => (i*i + 27).isProbablePrime(100) })
    .filter({ i => !(i*i + 19).isProbablePrime(100) })
    .filter({ i => !(i*i + 21).isProbablePrime(100) })
    .sum

  def main(args: Array[String]) = println(solution)
}
