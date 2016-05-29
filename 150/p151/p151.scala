package com.daystrom_data_concepts

import scala.collection.mutable


object p151 {

  val cache = mutable.Map.empty[(Int, List[String]), Vector[(Int, Int)]]
  val maxBatch = 15

  /**
    * Pull a piece of paper from the envelope and perform the
    * appropriate cuts.
    */
  def pull(paper: String): Array[String] = {
    val pattern = Array("A2", "A3", "A4", "A5")
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
    * Given a batch number (≤ maxBatch) and a scenario, compute a
    * vector of pairs of integers.  The first integer in each pair is
    * the number of length-one scenarios which can result, and the second
    * is the total number of scenarios which can result.
    */
  def calculate(batch: Int, scenario: List[String]): Vector[(Int, Int)] = {
    val key = (batch, scenario.sorted)

    cache.get(key) match {
      case Some(vector) => vector
      case None => {
        if (batch <= maxBatch) {
          val scenarios = enumerate(scenario)
          val lists = scenarios.map({ e => calculate(batch + 1, e) })
          val num = if (scenario.length == 1) 1; else 0
          val denom = 1
          val value = (num, denom) +:
            (0 until maxBatch - batch)
            .toVector
            .map({ i =>
              val here = lists.map({ list => list(i) })
              val num = here.map(_._1).sum
              val denom = here.map(_._2).sum
              (num, denom)
            })

          cache.put(key, value)
          value
        }
        else Vector.empty[(Int, Int)]
      }
    }
  }

  val answer = calculate(0, List("A1"))

  def main(args: Array[String]) = println(answer)
}
