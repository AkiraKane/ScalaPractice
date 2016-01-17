package com.daystrom_data_concepts

object p38 {
  val limit = 1000000000
  val numbers = List.range(1,10)
  val chunks = numbers.map({ n => numbers.take(n) }).drop(1)

  def concatProd(n : Int, list : List[Int]) = list.map(_ * n).map(_.toString).reduce(_ ++ _)

  def panDigital(str : String) = ((str.length == 9) && ((str.toSet - '0').size == 9))

  def chunkMax(list : List[Int]) = {
    Iterator.range(1, limit)
      .map(concatProd(_, list))
      .takeWhile(_.length < 10)
      .filter(panDigital)
      .map(_.toInt)
      .foldLeft(-1)(math.max(_,_))
  }

  lazy val solution = chunks.map(chunkMax(_)).reduce(math.max(_,_))

  def main(args: Array[String]) = {
    println(solution)
  }
}
