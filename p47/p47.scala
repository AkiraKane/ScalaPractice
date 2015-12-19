package com.daystrom_data_concepts

object p47 {
  def prime(n : BigInt) = Iterator.iterate(BigInt(2))(_ + 1).takeWhile(_ < n).forall(n % _ != 0)

  val primes = Stream.iterate(BigInt(2))(_ + 1).filter(prime(_))
  val numbers = Iterator.iterate(1)(_ + 1)

  def factors(n : BigInt) = primes.takeWhile(_ <= n).filter(n % _ == 0)

  val x = 4

  lazy val solution = numbers
    .filter(factors(_).length == x)
    .sliding(x)
    .filter({ window => window.last - window.head == (x - 1) })
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
