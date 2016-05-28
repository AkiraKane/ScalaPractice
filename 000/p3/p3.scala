package com.daystrom_data_concepts

object p3 {
  val N = BigInt("600851475143")

  val primeFactors = Stream.iterate(BigInt(1))(_ + 1)
    .takeWhile({ n => (n * n <= N) })
    .filter(N % _ == 0)
    .filter(Euler.isPrimeBig)

  def main(args: Array[String]) = {
    println(primeFactors.last)
  }
}
