package com.daystrom_data_concepts

import scala.collection.mutable
import java.util.{Comparator, PriorityQueue}

object Dijkstra {

  type Node = (Int, Int)

  private val infty = Integer.MAX_VALUE

  private case class NodeCompare(dist: mutable.Map[Node, Int]) extends Comparator[Node] {
    def compare(l: Node, r: Node): Int =
      dist.getOrElse(l,infty) - dist.getOrElse(r,infty)
  }

  /* https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm */
  def algorithm(src: Node, matrix: Map[Node, Int]) = {
    val matrixKeys = matrix.keys.toSet
    val dist = mutable.Map[Node, Int]()
    val Q = new PriorityQueue(1, NodeCompare(dist))

    dist.put(src,matrix.getOrElse(src,infty))
    Q.add(src)

    while (Q.size() > 0) {
      val u = Q.poll()
      val (ux, uy) = u
      val udist = dist.getOrElse(u, infty)

      List((ux-1,uy), (ux,uy-1), (ux+1,uy), (ux,uy+1))
        .filter(matrixKeys.contains(_))
        .foreach({ v =>
          val alt = udist + matrix.getOrElse(v, infty)
          if (alt < dist.getOrElse(v, infty)) {
            if (Q.contains(v)) Q.remove(v)
            dist.put(v, alt)
            Q.add(v)
          }
        })
    }
    dist
  }
}
