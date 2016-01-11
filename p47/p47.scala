package com.daystrom_data_concepts

object p47 {
  def factors(n : BigInt) = Euler.primes.takeWhile(_ <= n).filter(n % _ == 0)

  val x = 4

  lazy val solution = Euler.natural
    .filter(factors(_).length == x)
    .sliding(x)
    .filter({ window => window.last - window.head == (x - 1) })
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
