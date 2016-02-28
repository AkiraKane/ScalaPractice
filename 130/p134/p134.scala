package com.daystrom_data_concepts

import Euler.{ extendedEuclidean, primes }
import math.max


object p134 {
  val limit = 100

  def makePositive(n: BigInt, p: Int) = {
    var retval = n
    while (retval < 0) retval += p
    retval % p
  }

  /*
   * Solve the equation
   *
   * ax - p_{2}y = -c
   *
   * where c  is equal to ("1"+p1.toString  mod p2) and a  is how much
   * the  modulus of  (i.toString+p1.toString mod  p2) increases  with
   * each successive  i.  The idea is  to find the smallest  x so that
   * ax - p_{2}y + c = 0 (so that the concatenated number is divisible
   * by p_{2}).
   */
  def compute(p1: Int, p2: Int) = {
    val c = ("1" + p1.toString).toInt % p2
    val a = (("2" + p1.toString).toInt % p2) - c
    val (x, y) = extendedEuclidean(a, -p2) match { case (x, y, _, _, _) => (BigInt(x), BigInt(y)) }
    val answer = List( // work around extended Euclidean algorithm issues
      x * -c + 1,
      x * c + 1,
      makePositive(x * -c, p2) + 1,
      makePositive(x * c, p2) + 1)
      .map({ left => BigInt(left.toString + p1.toString) })
      .filter({ n => n % p2 == 0 && n > 0 })
      .sorted

    assert(answer.nonEmpty && answer.head % p2 == 0, s"p1=$p1 p2=$p2 c=$c a=$a x=$x y=$y answer=$answer")
    answer.head
  }

  val solution = primes.takeWhile(_ <= limit).drop(2).sliding(2)
    .map({ case Stream(p1, p2) => compute(p1, p2) })
    .sum

  def main(args: Array[String]) = println(solution)
}
