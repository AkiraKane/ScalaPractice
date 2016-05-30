package com.daystrom_data_concepts

import scala.collection.mutable


object p151 {

  val cache = mutable.Map.empty[List[String], Double]

  /**
    * Pull a piece of paper from the envelope and perform the
    * appropriate cuts.
    */
  def pull(paper: String): List[String] = {
    val pattern = List("A2", "A3", "A4", "A5")
    paper match {
      case "A1" => pattern
      case "A2" => pattern.drop(1)
      case "A3" => pattern.drop(2)
      case "A4" => pattern.drop(3)
      case "A5" => pattern.drop(4)
      case _ => throw new Exception
    }
  }

  /**
    * For any particular scenario, enumerate all of the possible
    * scenarios that can result from it (where each possibility is
    * equally probable).
    */
  def enumerate(scenario: List[String]): List[List[String]] = {
    val result = Array.fill[List[String]](scenario.length)(null)

    var i = 0; while (i < scenario.length) {
      result(i) = scenario.take(i) ++ pull(scenario(i)) ++ scenario.drop(i+1)
      i += 1
    }

    result.toList.map(_.toList)
  }

  /**
    * Given a scenario, compute the expected of adjacent scenarios
    * that are singletons plus one if this is a singleton, plus zero
    * otherwise..
    */
  def calculate(scenario: List[String]): Double = {
    val key = scenario.sorted

    (cache.get(key), scenario) match {
      case (Some(fraction), _) => fraction
      case (None, List()) => 0
      case (None, List(singleton)) => {
        val denominator = 1
        val numerator = 1 + calculate(pull(singleton)) // this singleton, plus those from all descendant states
        val value = numerator / denominator
        cache.put(key, value)
        value
      }
      case (None, key) => {
        val denominator = key.length
        val numerator = enumerate(scenario).map(calculate).sum // this non-singleton, plus those from all descendant states
        val value =  numerator / denominator
        cache.put(key, value)
        value
      }
    }
  }

  val answer = calculate(List("A1")) - 1 - 1 // remove the first and last batch, which are guaranteed to be singletons

  def main(args: Array[String]) = println(answer)
}
