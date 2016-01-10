package com.daystrom_data_concepts

import scala.collection.mutable

object p77 {
  val limit = 5000

  val primes = Euler.primes
  val natural = Euler.natural

  val A008472_memo = mutable.Map.empty[Int,Int]

  /* https://oeis.org/A008472
   * The Sum of Prime Factors */
  def A008472(n: Int) : Int = {
    A008472_memo.getOrElse(n, {
      val result = primes.takeWhile(_ <= n).filter(n % _ == 0).sum
      A008472_memo.put(n,result)
      result
    })
  }

  val A000607_memo = mutable.Map.empty[Int,Int]

  /* https://oeis.org/A000607
   * Prime Partitions */
  def A000607(n: Int, memo: mutable.Map[Int,Int] = mutable.Map.empty[Int,Int]) : Int = {
    if (n < 0) 0
    else if (n == 0) 1
    else if (n == 1) 0
    else {
      memo.getOrElse(n, {
        val result = natural.take(n).map({ k => A008472(k) * A000607(n-k, memo) }).sum / n
        memo.put(n,result)
        result
      })
    }
  }

  val solution = natural.toIterator.
    map({ n => (n,A000607(n,A000607_memo)) })
    .filter(_._2 >= limit)
    .next

  def main(args: Array[String]) = println(solution)

}
