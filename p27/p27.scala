package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p27 {
  def score(a : Int, b : Int) = {
    var n = 0
    while (Euler.isPrime(n*n + a*n + b)) n += 1
    n
  }

  val limit = 1000

  val solution = (for(
    a <- -limit to limit;
    b <- -limit to limit) yield (a, b, a*b, score(a,b)))
    .reduce({ (x,y) => if (x._4 >= y._4) x; else y })

  def main(args: Array[String]) = {
    println(solution)
  }
}
