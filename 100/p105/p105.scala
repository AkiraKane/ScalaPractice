package com.daystrom_data_concepts

import scala.io.Source


object p105 {
  /* Predicate for the second rule */
  def pred2(ns: Seq[Int]) = {
    val fromLeft = ns.scanLeft(0)(_ + _).drop(2)
    val fromRight = ns.reverse.scanLeft(0)(_ + _).drop(1)
    fromLeft.zip(fromRight).forall({ case(l,r) => l > r })
  }

  /* Predicate for the first rule */
  def pred1(ns: Seq[Int]) = {
    val n = ns.length
    val subsets = ns.toSet.subsets.toStream

    Iterator.iterate(2)(_ + 1).takeWhile(_ <= n/2)
    /* Pairs of subsets */
      .flatMap({ i =>
        subsets.filter(_.size == i).combinations(2) })
    /* Must be disjoint */
      .filter({ case Stream(set1, set2) =>
        (set1 & set2).isEmpty })
    /* Must be sufficient overlap */
      .filter({ case Stream(set1, set2) =>
        val list1 = set1.toList.sorted
        val list2 = set2.toList.sorted
        val relationships = list1.zip(list2)
          .map({ case (a,b) => if (a < b) -1; else if (a == b) 0; else 1 })

        relationships.toSet == Set(-1,1) })
    /* Make sure sums are different */
      .forall({ case Stream(set1, set2) =>
        set1.sum != set2.sum })
  }

  val data = Source.fromFile("100/p105/p105_sets.txt")
    .mkString.split("\n")
    .map({ elts => elts.split(",").toList.map(_.toInt).sorted })
    .toList

  val solution = data
    .filter(pred2)
    .filter(pred1)
    .map(_.sum)
    .sum

  def main(args: Array[String]) = println(solution)
}
