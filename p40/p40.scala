package com.daystrom_data_concepts

object p40 {

  val limit = 1000000

  val itr = Iterator.range(1,limit).flatMap(_.toString)

  val digits = List(0, 1, 10, 100, 1000, 10000, 100000, 1000000)

  def grab(itr : Iterator[Char], state : List[Int]) : List[Int] = {
    if (state.length > 1) {
      val List(i,j) = state.take(2)
      val itr2 = itr.drop(j - i - 1)
        (itr2.next - '0').toInt :: grab(itr2, state.tail)
    } else List.empty
  }

  val solution = grab(itr, digits).product

  def main(args: Array[String]) = {
    println(solution)
  }
}
