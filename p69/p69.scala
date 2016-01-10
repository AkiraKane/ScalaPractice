package com.daystrom_data_concepts

object p69 {
  val limit = 1000000

  val solution = Euler.natural.toIterator
    .takeWhile(_ <= limit)
    .map({ n => (n, n / Euler.phi(n)) })
    .reduce({ (left,right) => if (left._2 > right._2) left; else right })

  def main(args: Array[String]) = {
    println(solution)
  }

}
