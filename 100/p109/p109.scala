package com.daystrom_data_concepts


object p109 {
  type ScoreType = (Char, Int)

  def value(score: ScoreType) = {
    score._1 match {
      case 'S' => score._2 * 1
      case 'D' => score._2 * 2
      case 'T' => score._2 * 3
    }
  }

  val scores = {
    val nonBull = for (a <- List('S', 'D', 'T'); b <- (0 to 20)) yield(a, b)
    nonBull ++ List(('S', 25), ('D', 25))
  }

  val triples =
    (for (a <- scores; b <- scores; c <- scores) yield List(a,b,c)).toList
      .map({ triple => triple.filter({ score => score._2 != 0 }) })
      .filter(_.nonEmpty)
      .filter({ triple => triple.head._1 == 'D' })
      .map({ triple => triple.head :: triple.tail.sorted })
      .distinct

  val solution = triples
    .filter({ triple => triple.map(value).sum < 100 })
    .length

  def main(args: Array[String]) = println(solution)
}
