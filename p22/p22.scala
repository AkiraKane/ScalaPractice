package com.daystrom_data_concepts

object p22 {
  import scala.io.Source

  def score(name : String) : Int = name.map(_ - 'A' + 1).sum

  val solution = Source.fromFile("p22/p022_names.txt")
    .mkString.split(",").toList
    .map({ str => str.stripPrefix("\"").stripSuffix("\"") })
    .map(_.toString)
    .sorted
    .map(score)
    .zip(Stream.from(1))
    .map({ tuple => tuple._1 * tuple._2 })
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
