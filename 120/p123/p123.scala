package com.daystrom_data_concepts


object p123 {
  val limit = BigInt("10000000000")

  val primes = Stream.iterate(BigInt(71023))(_ + 2)
    .filter({ n => n.isProbablePrime(1000) })

  /*
   * Pascal's triangle  shows that when n  is odd, the remainder  is 2
   * and when n is even, the remainder is 2*n*p_{n}.  Start the search
   * from the solution given in the problem description and filter out
   * even n.
   */
  val solution = primes.zip(Stream.iterate(7035)(_ + 1))
    .filter({ case (_, n) => n % 2 == 1 }) // Only consider odd n
    .filter({ case (p, n) => limit / (2*n) <= p }) // Looking for 10^10 <= 2*n*p_{n}
    .head

  def main(args: Array[String]) = println(solution)
}
