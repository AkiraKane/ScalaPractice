package com.daystrom_data_concepts

import scala.io.Source


object p107 {
  type TreeType = Set[Int]
  type EdgeType = ((Int, Int), Int)

  val size = 40

  val data = Source.fromFile("100/p107/p107_network.txt")
    .mkString.split("\n")
    .map({ line => line.split(",").toList })
    .zip(0 until size)
    .flatMap({ case (line,i) =>
      line
        .map({ str => if (str == "-") -1; else str.toInt })
        .zip(0 until size)
        .filter(_._1 != -1)
        .map({ case (weight, j) => ((i,j), weight) }) })
    .filter({ case((i,j), _) => i >= j })
    .sortWith(_._2 < _._2)
    .toList

  /*
   * Kruskal's Algorithm for finding Minimum Weight Spanning Trees.
   * https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
   */
  def kruskal(
    weight: Int = 0,
    trees: Set[TreeType] = (0 until size).map({ i => Set(i) }).toSet,
    edges: List[EdgeType] = data
  ): Int = {
    if (edges.isEmpty) weight
    else {
      val ((i, j), w) = edges.head
      val ij = Set(i,j)
      val meeting = trees.filter({ tree => (tree & ij).nonEmpty })

      if (meeting.size != 2) kruskal(weight, trees, edges.tail)
      else {
        val List(tree1, tree2) = meeting.toList
        kruskal(weight + w, trees - tree1 - tree2 + (tree1 union tree2), edges.tail)
      }
    }
  }

  lazy val solution = data.map(_._2).sum - kruskal()

  def main(args: Array[String]) = println(solution)
}
