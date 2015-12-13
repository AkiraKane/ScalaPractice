package com.daystrom_data_concepts

object p26 {

  def cycle(n : Int) : Int = cycle(n, List((0, 1)))

  def cycle(n : Int, list : List[(Int, Int)]) : Int = {
    val oldRemainder = list.head._2
    val quotient = (oldRemainder * 10) / n
    val remainder = (oldRemainder * 10) % n
    val next = (quotient, remainder)

    if (list.indexOf(next) >= 0) list.indexOf(next)
    else cycle(n, next :: list)
  }

  val limit = 1000

  val solution = List.range(1,limit)
    .map({ n => (n, cycle(n)) })
    .reduce({ (pair1, pair2) => if (pair1._2 >= pair2._2) pair1; else pair2 })

  def main(args: Array[String]) = {
    println(solution)
  }
}
