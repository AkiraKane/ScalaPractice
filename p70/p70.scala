package com.daystrom_data_concepts

/**
 * This is a rather unsatisfying heuristic solution.
 */
object p70 {
  val limit = 10000000

  val range = Euler.primes.takeWhile({ p => p * p <= 3 * limit })

  def best(n : Int) = {
    range
      .toIterator
      .takeWhile({ m => m * n < limit })
      .map({ m =>
        val nm = n*m
        val phi = (n-1)*(m-1)
        (nm, phi, nm.toDouble / phi) })
      .filter({ triple  =>
        val (nm, phi, _) = triple
        (nm.toString.sorted == phi.toString.sorted) })
      .foldLeft((-1,0,n.toDouble))({ (left, right) => if (left._3 < right._3) left; else right })
  }

  lazy val solution = range.map(best)
    .filter(_._1 != -1)
    .reduce({ (left, right) => if (left._3 < right._3) left; else right })

  def main(args: Array[String]) = {
    println(solution)
  }
}
