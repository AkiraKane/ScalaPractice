package com.daystrom_data_concepts

import math.sqrt


object p108 {
  val limit = 1000

  def squaredD(n: Int) =
    Euler.primeFactors(n).map(_._2 * 2 + 1).product

  def squaredFactors(n: Int) = {
    val fs = Euler.natural
      .takeWhile(_ <= sqrt(n))
      .filter(n % _ == 0)
      .flatMap({ f => List(f,n/f) })
      .toList
    (for (a <- fs; b <- fs) yield (a*b)).distinct
  }

  /* Want to solve the equation
   *
   * xy - nx - ny = 0
   *
   * Use the prescription from the great website
   * https://www.alpertron.com.ar/JQUAD.HTM to solve the equation then
   * count the solutions.*/
  def score(n: Int) = {
    val fsPos = squaredFactors(n)
    val fs = (fsPos ++ fsPos.map(_ * -1))

    fs
      .map(BigInt(_))
      .map({ factor =>
        val nBig = BigInt(n)
        val other = (nBig * nBig)/factor
        val x = factor + n
        val y = other + n
        if (x <= y) (x,y); else (y,x) })
      .filter({ case (x, y) => (x > 0) && (y > 0) })
      .filter({ case (x, y) => x*y - n*x - n*y == 0 })
      .distinct
      .length
  }

  val solution = Euler.natural
    .filter(squaredD(_) > limit)
    .filter(score(_) > limit)
    .head

  def main(args: Array[String]) = println(solution)
}
