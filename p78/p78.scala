package com.daystrom_data_concepts

import scala.collection.mutable
import com.daystrom_data_concepts._

object p78 {
  val zero = BigInt(0)
  val one = BigInt(1)

  val pattern = Stream.continually(List(1,1,-1,-1)).flatten

  val generalizedPentagonal = Stream.iterate(1)(_ + 1)
    .flatMap({ n => List(n, -n) })
    .map({ n => n*(3*n - 1)/2 })

  val A000041_memo = mutable.Map.empty[Int,BigInt]

  /* https://oeis.org/A000041 and https://en.wikipedia.org/wiki/Partition_(number_theory)#Generating_function
   * Number of Partitions */
  def A000041(n: Int, memo: mutable.Map[Int,BigInt] = A000041_memo) : BigInt = {
    if (n < 0) zero
    else if (n <= 1) one
    else memo.getOrElse(n, {
      val ks = generalizedPentagonal.map({ k => n-k }).takeWhile(_ >= 0).map(A000041(_,memo))
      val result = ks.zip(pattern).map({ x => x._1 * x._2 }).sum
      memo.put(n, result)
      result
    })
  }

  val solution = Euler.natural
    .map({ n => (n, A000041(n)) })
    .filter(_._2 % 1000000 == 0)
    .head

  def main(args: Array[String]) = println(solution)

}
