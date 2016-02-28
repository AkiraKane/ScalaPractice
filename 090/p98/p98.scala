package com.daystrom_data_concepts

import math.{max, sqrt, floor}
import scala.io.Source


object p98 {
  def isSquare(n: Int): Boolean = {
    val root = sqrt(n)
    (root == floor(root))
  }

  def score(list: List[String]) = {
    val List(left, right) = list
    val length = left.length

    "0123456789".combinations(length).map({ chunk1 =>
      chunk1.permutations.map({ chunk2 =>
        val mapping = left.zip(chunk2).toMap
        val leftMapped = left.map({ c => mapping.getOrElse(c,'X') })
        val rightMapped = right.map({ c => mapping.getOrElse(c, 'X') })
        val leftNum = leftMapped.toInt
        val rightNum = rightMapped.toInt

        if (leftMapped.head == '0' || rightMapped.head == '0') -1
        else if (!isSquare(leftNum) || !isSquare(rightNum)) -1
        else max(leftNum, rightNum)
      }).reduce(max(_,_))
    }).reduce(max(_,_))
  }

  val quote = "\""

  val data = Source.fromFile("90/p98/p098_words.txt")
    .mkString.split(",")
    .map(_.stripPrefix(quote).stripSuffix(quote))
    .filter(_.size >= 5) // From a short test-run, this is known to be at least five
    .toList
    .groupBy(_.sorted)
    .filter(_._2.length > 1)
    .flatMap(_._2.combinations(2).toList)

  val solution = data.map(score).reduce(max(_,_))

  def main(args: Array[String]) = println(solution)
}
