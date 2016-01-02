package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p42 {
  import scala.io.Source

  def score(str : String) = str.map(_ - 'A' + 1).sum

  def isTriangle(n : Int) = Euler.triangular.takeWhile(_ <= n).exists(_ == n)

  val solution = Source.fromFile("p42/p042_words.txt")
    .mkString.split(",").toList
    .map({ str => str.stripPrefix("\"").stripSuffix("\"") })
    .map(_.toString)
    .map(score(_))
    .filter(isTriangle)
    .toList.length

  def main(args: Array[String]) = {
    println(solution)
  }
}
