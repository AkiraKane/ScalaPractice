package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p41 {
  lazy val solution = Iterator.range(9,0,-1)
    .flatMap("123456789".take(_).permutations.map(BigInt(_)).toList.sortWith(_ > _))
    .filter(Euler.isPrimeBig)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
