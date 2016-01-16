package com.daystrom_data_concepts

import math.pow

object p87 {
  val limit = 50000000
  val aLimit = pow(limit, 0.5).toInt
  val bLimit = pow(limit, 0.34).toInt
  val cLimit = pow(limit, 0.25).toInt

  val as = Euler.primes.takeWhile(_ <= aLimit)
  val bs = Euler.primes.takeWhile(_ <= bLimit)
  val cs = Euler.primes.takeWhile(_ <= cLimit)

  val solution = (
    for(a <- as; b <- bs; c <- cs) yield (a*a + b*b*b + c*c*c*c)
  ).filter(_ <= limit).toSet.size

  def main(args: Array[String]) = println(solution)
}
