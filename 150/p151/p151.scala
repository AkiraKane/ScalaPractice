package com.daystrom_data_concepts


object p151 {

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
  def scenarios(scenario: Array[String]): Array[Array[String]] = {
    val result = Array.fill[Array[String]](scenario.length)(scenario)

    var i = 0; while (i < scenario.length) {
      result(i) = scenario.take(i) ++ pull(scenario(i)) ++ scenario.drop(i+1)
      i += 1
    }
    result
  }

  val all = Iterator.iterate(Array(Array("A1")))({ array =>
    array.flatMap({ contents =>
      scenarios(contents).filter(_.length <= 17)
    })
  })
    .take(9)
    .map({ array =>
      val n = array.filter(_.length == 1).length.toDouble
      val d = array.length
      n / d
    })
    .toList

  def main(args: Array[String]) = println(all)
}
