package com.daystrom_data_concepts

import math.max
import scala.io.Source
import scala.collection.mutable

object p79 {
  val logs = Source.fromFile("p79/p079_keylog.txt")
    .mkString.split("\n").toList

  def predicate(str: String) : Boolean = {
    /* 4 and 5 do not appear in that data, so they cannot appear in any
     * minimal solution. */
    if (str.contains('4') || str.contains('5')) false
    else logs.forall({ log => Euler.LCSLength(str,log) == 3 })
  }

  /* 7 is observed before all  others, 0 is observed after all others,
   * so they are constrained to be first and last, respectively. 4 and
   * 5 do  not appear  as noted  above.  All  other digits  appear, so
   * start the search from 123689 instead of 1. */
  val solution = Iterator.iterate(BigInt("123689"))(_ + 1)
    .map("7" ++ _.toString ++ "0")
    .filter(predicate)
    .next

  def main(args: Array[String]) = println(solution)
}
