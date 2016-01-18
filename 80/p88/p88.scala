package com.daystrom_data_concepts

import scala.collection.mutable

object p88 {
  val limit = 12000

  val ns = mutable.Map.empty[Int, Int]

  // Iterate over all constructions of k
  def build(product: Int, sum: Int, terms: Int, start: Int): Unit = {
    val k = (product - (sum - 1)) + terms

    if (k <= limit) {
      ns.get(k) match {
        case None => ns.put(k, product)
        case Some(other) => if (product < other) ns.put(k, product)
      }
      (start to (2*limit / product)).foreach({ factor =>
        build(product * factor, sum + factor, terms + 1, factor)
      })
    }
  }

  val solution = {
    build(1, 0, 1, 2)
    ns.values.filter(_ != 1).toSet.sum
  }

  def main(args: Array[String]) = println(solution)
}
