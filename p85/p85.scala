package com.daystrom_data_concepts

import math.abs

object p85 {
  val target = 2000000
  val limit = 201

  def score(x: Int, y: Int) =
    abs((for (i <- 1 to x; j <- 1 to y) yield (i * j)).sum - target)

  val solution = (
    for(i <- 1 to limit; j <- 1 to limit; if (i <= j)) yield ((i,j), score(i,j))
  ).sortWith(_._2 < _._2).head

  def main(args: Array[String]) = println(solution)
}
