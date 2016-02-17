package com.daystrom_data_concepts

import scala.collection.mutable
import math.{ceil, log}


object p122 {
  def m(
    k: Int,
    seen: Set[Int] = Set.empty[Int],
    cache: mutable.Map[(Int, Set[Int]), Int] = mutable.Map.empty[(Int, Set[Int]), Int]
  ): Int = {
    if (k <= 1) 0
    else if (seen.contains(k)) 0
    // http://wwwhomes.uni-bielefeld.de/achim/addition_chain.html
    else if (Set(31, 56, 44, 46, 41, 80, 42, 45, 60, 39, 54, 51, 96, 35, 52, 29, 50, 43, 68, 38, 37, 72, 49, 66, 65).contains(k)) 7
    else if (Set(28, 22, 23, 40, 21, 30, 27, 48, 26, 25, 34, 19, 36, 33).contains(k)) 6
    else if (Set(14, 11, 20, 15, 24, 13, 17, 18).contains(k)) 5
    else if (Set(7,10,12,9).contains(k)) 4
    else if (Set(5,6).contains(k)) 3
    else {
      val key = (k, seen)
      val cached = cache.get(key)
      val exp = log(k) / log(2)

      if (exp == ceil(exp)) exp.toInt
      else if (cached.nonEmpty) cached.get
      else {
        val result = (1 until k)
          .flatMap({ x =>
            val one = m(x,seen,cache) + m(k-x,seen+x,cache) + 1
            val two = m(k-x,seen,cache) + m(x,seen+(k-x),cache) + 1
            List(one, two) })
          .reduce({ (l,r) => if (l < r) l; else r })

        cache.put((k,seen), result)
        result
      }
    }
  }

  val cache = mutable.Map.empty[(Int, Set[Int]), Int]
  val solution = m(102, cache=cache)

  def main(args: Array[String]) = println(solution)
}
