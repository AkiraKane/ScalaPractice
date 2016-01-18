package com.daystrom_data_concepts

import scala.collection.mutable

object p88 {
  val limit = 1200

  def elaborate(fs: List[(Int, Int)]) = fs.flatMap({ case(factor,mult) => List.fill(mult)(factor) })

  def factorize(n: Int) = elaborate(Euler.primeFactors(n))

  val cache = mutable.Map.empty[List[Int], List[List[Int]]]

  def enumerate(fs: List[Int]): List[List[Int]] = {
    val length = fs.length

    if (length < 1) List(List.empty[Int])
    else cache.getOrElse(fs, {
      val result =
        (1 to length).map({ i =>
          val prod = fs.take(i).product
          val rest = fs.drop(i)
          rest.permutations
            .flatMap({ lst => enumerate(lst.sorted) })
            .map(prod :: _)
        }).foldLeft(List.empty[List[Int]])(_ ++ _)

      cache.put(fs, result)
      result
    })
  }

  // Compute the k-set for n
  def ks(n: Int): Set[Int] = {
    val factors = factorize(n).sorted
    enumerate(factors.sorted)
      .map({ lst => n - lst.sum + lst.length })
      .toSet
  }

  // k-sets for each natural number
  lazy val kss = Euler.natural.map({ i => (i,ks(i)) })

  // For each k, give the smallest natural number whose k-set contains it
  lazy val indices = Euler.natural.drop(1).takeWhile(_ <= limit)
    .map({ i => kss.filter(_._2.contains(i)).head._1 })

  val solution = indices.distinct.sum

  def main(args: Array[String]) = println(solution)
}
