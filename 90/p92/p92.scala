package com.daystrom_data_concepts

import scala.collection.mutable

object p92 {

  /* Naive: 123 and 321 give the same answer. */
  def chain(n: Int, cache: mutable.Map[Int, Boolean] = mutable.Map.empty[Int, Boolean]): Boolean = {
    if (n == 1) return false
    else if (n == 89) return true
    else {
      cache.getOrElse(n, {
        val next = n.toString
          .map({ char =>
            val digit = char - '0'
            digit * digit })
          .sum
        val result = chain(next, cache)

        cache.put(n, result)
        result
      })
    }
  }

  val limit = 10000000
  val state = mutable.Map.empty[Int, Boolean]
  val solution = Iterator.iterate(1)(_ + 1)
    .takeWhile(_ < limit)
    .filter(chain(_, state))
    .length

  def main(args: Array[String]) = println(solution)
}
