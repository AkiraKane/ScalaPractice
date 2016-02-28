package com.daystrom_data_concepts

import math.{abs, min, max}
import scala.io.Source
import scala.collection.mutable

object p83 {
  val dim = 80
  val limit = dim - 1

  val data = Source.fromFile("80/p83/p083_matrix.txt")
    .mkString.split("\n").toList
    .map(_.split(",").map(_.toInt).toList)

  // val matrix = Map[Dijkstra.Node, Int](
  //   ((0,0), 131), ((1,0), 673), ((2,0), 234), ((3,0), 103), ((4,0), 18),
  //   ((0,1), 201), ((1,1), 96), ((2,1), 342), ((3,1), 965), ((4,1), 150),
  //   ((0,2), 630), ((1,2), 803), ((2,2), 746), ((3,2), 422), ((4,2), 111),
  //   ((0,3), 537), ((1,3), 699), ((2,3), 497), ((3,3), 121), ((4,3), 956),
  //   ((0,4), 805), ((1,4), 732), ((2,4), 524), ((3,4), 37), ((4,4), 331)
  // )

  val matrix = (for(i <- 0 to limit; j <- 0 to limit) yield ((i,j), data(j)(i))).toMap

  val solution = Dijkstra.algorithm((0,0), matrix).get((limit,limit))

  def main(args: Array[String]) = println(solution)
}
