package com.daystrom_data_concepts


object p106 {

  def score(n: Int) = {
    val subsets = (0 until n).toSet.subsets.toStream

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
      .length
  }

  val solution = score(12)

  def main(args: Array[String]) = println(solution)
}
