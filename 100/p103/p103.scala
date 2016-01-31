package com.daystrom_data_concepts


object p103 {
  val limit = 4

  val start = List(20,31,38,39,40,42,45) // Use "rule" on n == 6 solution.  The fact that this is the actual solution is amusing.

  def subPred1(ns: List[Int]) = {
    (ns(0) + ns(1) > ns(6)) &&
    (ns(0) + ns(1) + ns(2) > ns(5) + ns(6)) &&
    (ns(0) + ns(1) + ns(2) + ns(3) > ns(4) + ns(5) + ns(6))
  }

  def subPred2(ns: List[Int]) = {
    ns.toSet.subsets.toList.combinations(2).forall({ case List(set1, set2) =>
      if ((set1 & set2).nonEmpty) true // Non-disjoint so trivially true
      else set1.sum != set2.sum
    })
  }

  def pred(ns: List[Int]) = {
    subPred1(ns) && subPred2(ns)
  }

  def transmute(deltas: List[Int]) = start.zip(deltas).map({ pair => pair._1 + pair._2 })

  val solution = {
    val abcdefg = for (
      a <- (-limit to limit);
      b <- (-limit to limit);
      c <- (-limit to limit);
      d <- (-limit to limit);
      e <- (-limit to limit); // The gap between the first two and the last one allows limit
      f <- (-limit to limit);
      g <- (-limit to limit)
      if (((a+b+c+d) - (e+f+g)) >= 0); // First four must be larger than last three
      if (((a+b+c) - (f+g)) >= -1); // First three must be larger than last two
      if (a-b < 11); // Second larger than first (maintaining sorted order)
      if (b-c < 7);  // Third larger than second
      if (c-d < 1);  // do.
      if (d-e < 1);
      if (e-f < 2);
      if (f-g < 3);
      if (a+b+c+d+e+f+g <= 0)) yield List(a,b,c,d,e,f,g)
    abcdefg
      .map(transmute)
      .filter(pred)
      .map({ list => (list, list.sum) })
      .reduce({ (left,right) => if (left._2 < right._2) left; else right })
  }

  def main(args: Array[String]) = println(solution)
}
