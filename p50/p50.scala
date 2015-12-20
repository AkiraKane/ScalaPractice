package com.daystrom_data_concepts

object p50 {
  def prime(n : Int) = Iterator.from(2).takeWhile({ m => (m <= math.sqrt(n)) && (m < n) }).forall(n % _ != 0)

  val limit = 1000000
  val primes = Stream.from(2).filter(prime(_)).takeWhile(_ < limit).toList
  val maxPrime = primes.last
  val primeSet = primes.map(BigInt(_)).toSet

  lazy val solution = Iterator.range(0, primes.length)
    .map({ i => {
      val row = primes
        .drop(i)
        .scanLeft(BigInt(0))(_ + _)
        .drop(1).reverse
        .dropWhile(_ > maxPrime)
        .dropWhile(!primeSet.contains(_))
      (row.head, row.length) }})
    .reduce( (l,r) => if (l._2 >= r._2) l; else r )

  def main(args: Array[String]) = {
    println(solution)
  }
}
