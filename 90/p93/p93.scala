package com.daystrom_data_concepts

import scala.collection.mutable

object p93 {
  def search(n: Double, list: Seq[Int]): Boolean = {
    if (n == 0.0 && list.isEmpty) true
    else if (n != 0.0 && list.isEmpty) false
    else {
      val head = list.head
      val tail = list.tail
      List(n + head, n - head, n * head, n / head)
        .map(search(_, tail))
        .exists(_ == true)
    }
  }

  def predicate(n: Double, set: Seq[Int]): Boolean =
    set.permutations
      .map({ permutation => search(n, permutation.toList) })
      .exists(_ == true)

  def score(set: Seq[Int]) =
    Iterator.iterate(1)(_ + 1)
      .takeWhile(predicate(_, set))
      .length

  val solution = (1 to 9).combinations(4)
    .filter({ v => v(0) < v(1) && v(1) < v(2) && v(2) < v(3) })
    .map({ v => (v, score(v)) })
    .reduce({ (x,y) => if (x._2 > y._2) x; else y })

  def main(args: Array[String]) = println(solution)
}
