package com.daystrom_data_concepts

import scala.collection.mutable
import Euler.{gcd, primeFactors}


object p127 {
  val limit = 2000

  val factorsCache = mutable.Map.empty[Int, Set[Int]]
  val radCache = mutable.Map.empty[Int, Int]

  def factors(
    n: Int,
    cache: mutable.Map[Int, Set[Int]] = factorsCache
  ) = {
    val cached = cache.get(n)

    if (cached.nonEmpty) cached.get
    else {
      val result = primeFactors(n).map(_._1).toSet
      cache.put(n, result)
      result
    }
  }

  def rad(
    a: Int, b: Int, c: Int,
    cache: mutable.Map[Int, Int] = radCache
  ) = {
    val abc = a * b * c
    val cached = cache.get(abc)

    if (cached.nonEmpty) cached.get
    else {
      val result = List(a, b, c)
        .map({ n => factors(n) })
        .foldLeft(Set.empty[Int])({ (left, right) => left union right })
        .product
      cache.put(abc, result)
      result
    }
  }

  val candidates = {
    var retval = 0

    var a = 1
    while (a < limit) {
      var b = a + 1
      while (a + b < limit) {
        val c = a + b
        val as = factors(a)
        val bs = factors(b)
        val cs = factors(c)

        if ((as & bs).isEmpty && (as & cs).isEmpty && (bs & cs).isEmpty && rad(a, b, c) < c)
          retval += c
        b += 1
      }
      a += 1
    }

    retval
  }

  val solution = candidates

  def main(args: Array[String]) = println(solution)
}
