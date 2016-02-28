package com.daystrom_data_concepts

object p43 {

  def pred(n : String) = {
    ((n.substring(1,4).toInt % 2) == 0) &&
    ((n.substring(2,5).toInt % 3) == 0) &&
    ((n.substring(3,6).toInt % 5) == 0) &&
    ((n.substring(4,7).toInt % 7) == 0) &&
    ((n.substring(5,8).toInt % 11) == 0) &&
    ((n.substring(6,9).toInt % 13) == 0) &&
    ((n.substring(7,10).toInt % 17) == 0)
  }

  /* Reduce the cost by fixing the sixth digit to either 0 or 5 (which
   * is required for the predicate to be true). */
  val group1 = "012346789".permutations.map({ str => str.take(5) ++ "5" ++ str.drop(5) })
  val group2 = "123456789".permutations.map({ str => str.take(5) ++ "0" ++ str.drop(5) })
  val solution = (group1 ++ group2).filter(pred).map(BigInt(_)).sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
