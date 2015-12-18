package com.daystrom_data_concepts

object p41 {

  def prime(n : BigInt) = Iterator.range(2,31428).takeWhile(_ < n).forall(n % _ != 0)

  lazy val solution = Iterator.range(9,0,-1)
    .flatMap("123456789".take(_).permutations.map(BigInt(_)).toList.sortWith(_ > _))
    .filter(prime)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
