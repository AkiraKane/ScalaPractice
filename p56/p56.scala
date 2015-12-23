package com.daystrom_data_concepts

object p56 {
  import math.max

  val limit = 100

  lazy val solution = Iterator.iterate(BigInt(1))(_ + 1)
    .map({ a => Iterator.fill(limit)(a)
      .scanLeft(BigInt(1))(_ * _)
      .map(_.toString.map(_ - '0').sum)
      .reduce(max(_,_)) })
    .take(limit)
    .reduce(max(_,_))

  def main(args: Array[String]) = {
    println(solution)
  }

}
