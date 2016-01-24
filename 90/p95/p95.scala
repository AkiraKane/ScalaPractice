package com.daystrom_data_concepts

import scala.collection.mutable
import math.min


object p95 {
  val limit = 1000000

  def sopd(n: Int) = {
    Euler.primeFactors(n)
      .map({ case(p,k) =>
        var i = 1
        var pow = 1
        var result = 1
        while (i <= k) {
          pow *= p
          result += pow
          i += 1
        }
        result })
      .product - n
  }

  /* Pre-computed sums of proper divisors */
  val d: Vector[Int] = Vector.range(0,limit+1).map(sopd)

  val chainCache = mutable.Map.empty[Int, Vector[Int]]

  def chain(
    n: Int,
    seen: Set[Int] = Set.empty[Int],
    vector: Vector[Int] = Vector.empty[Int],
    cache: mutable.Map[Int, Vector[Int]] = chainCache
  ): Vector[Int] = {
    cache.getOrElse(n, {
      /* If chain just completed, store it in the cache */
      if (seen.contains(n)) {
        val before = vector.takeWhile(_ != n)
        val after = vector.dropWhile(_ != n) :+ n

        before.foreach({ i => cache.put(i, Vector.empty[Int]) })
        after.foreach({ i => cache.put(i, after) })
        after
      }
      /* If chain not yet complete, recurse */
      else {
        val next = d(n)

        if (next > limit) vector.foreach({ i => cache.put(i, Vector.empty) })
        else chain(next, seen + n, vector :+ n, cache)
        cache.getOrElse(n, Vector.empty[Int])
      }
    })
  }

  val solution = {
    Iterator.iterate(1)(_ + 1).takeWhile(_ < limit).foreach(chain(_))
    chainCache.values
      .reduce({ (l,r) => if (l.length > r.length) l; else r })
      .reduce(min(_,_))
  }

  def main(args: Array[String]) = println(solution)
}
