package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p66 {
  val limit = 1000

  lazy val solution = Euler.natural.take(limit)
    .map({ i => (i, Euler.PellSolve(i)._1) })
    .reduce({ (left, right) => if (left._2 > right._2) left; else right })

  def main(args: Array[String]) = {
    println(solution)
  }

}
