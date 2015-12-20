package com.daystrom_data_concepts

object p52 {

  val spread = 6

  def pred(n : BigInt) = {
    List.range(1,spread+1)
      .map(_ * n)
      .map(_.toString.toSet)
      .sliding(2)
      .forall({ pair => pair.head == pair.last })
  }

  lazy val solution = Iterator.iterate(BigInt(2))(_ + 1).filter(pred(_)).next

  def main(args: Array[String]) = {
    println(solution)
  }
}
