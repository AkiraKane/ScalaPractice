package com.daystrom_data_concepts

object p29 {
  val limit = 100

  def power(a : BigInt, b : BigInt) = (List.fill(b.toInt)(a) : List[BigInt]).product

  val solution = (for(
    a <- 2 to 100;
    b <- 2 to 100) yield(power(a,b)))
    .toSet
    .size

  def main(args: Array[String]) = {
    println(solution)
  }
}
