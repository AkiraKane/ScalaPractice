package com.daystrom_data_concepts

object p53 {

  def factorial(n : Int) : BigInt =
    if (n < 1) 1
    else Iterator.iterate(BigInt(1))(_ + 1).takeWhile(_ <= n).product

  def combinations(n : Int, r : Int) = {
    val nFact = factorial(n)
    val rFact = factorial(r)
    val nrFact = factorial(n-r)
    nFact / (rFact * nrFact)
  }

  val limit = 100
  val cutoff = 1000000

  lazy val solution = (for(
    n <- List.range(1, limit+1);
    r <- List.range(1, limit+1)) yield((n,r)))
    .toIterator
    .map({ case (n,r) => combinations(n,r) })
    .filter(_ > cutoff)
    .length

  def main(args: Array[String]) = {
    println(solution)
  }
}
