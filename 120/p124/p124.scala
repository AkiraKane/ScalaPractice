package com.daystrom_data_concepts


object p124 {
  val limit = 100000

  val primes = 1 #:: 2 #:: Stream.iterate(BigInt(1))(_ + 2)
    .takeWhile(_ <= limit)
    .filter(_.isProbablePrime(1000))
    .map(_.toInt)

  def score(n: Int) =
    primes.filter({ p => n % p == 0 }).product.toInt

  val list = Stream.iterate(1)(_ + 1)
    .takeWhile(_ <= limit)
    .map({ n => (n, score(n)) })
    .sortWith({ (left, right) =>
      if (left._2 < right._2) true
      else if (left._2 > right._2) false
      else (left._1 < right._1) })

  val solution = list(10000 - 1)

  def main(args: Array[String]) = println(solution)
}
