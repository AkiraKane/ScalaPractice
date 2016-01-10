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

  val solution = Iterator.iterate(BigInt("123689"))(_ + 1)
     /* 7 is observed before all others, 0 is observed after all others. */
    .map("7" ++ _.toString ++ "0")
    .filter(predicate).next

  def main(args: Array[String]) = println(solution)
}
