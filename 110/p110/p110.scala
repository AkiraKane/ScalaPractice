package com.daystrom_data_concepts


object p110 {
  val limit = 4000000
  val primes = Euler.primesBig

  def squaredD(fs: Stream[(BigInt, Int)]) =
    fs.map({ case(p,k) => (2 * k + 1) }).product

  def value(fs: Stream[(BigInt, Int)]) =
    fs.flatMap({ case(p,k) => List.fill(k)(p) }).product

  def exponents(n: Int) = {
    for(
      a <- (0 until n);
      b <- (0 until n);
      c <- (0 until n);
      d <- (0 until n)
    ) yield (List.fill(a)(4) ++ List.fill(b)(3) ++ List.fill(c)(2) ++ List.fill(d)(1)).take(n)
  }

  val solution = exponents(20)
    .map({ exps => primes.zip(exps) })
    .filter(squaredD(_) > 2 * limit + 1)
    .map({ fs => (fs, value(fs)) })
    .sortWith(_._2 < _._2)
    .head

  def main(args: Array[String]) = println(solution)
}
