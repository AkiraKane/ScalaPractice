package com.daystrom_data_concepts

object p42 {
  import scala.io.Source

  val triangles = Stream.from(1).map({ n => n*(n+1)/2 })

  def score(str : String) = str.map(_ - 'A' + 1).sum

  def isTriangle(n : Int) = triangles.takeWhile(_ <= n).exists(_ == n)

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