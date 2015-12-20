package com.daystrom_data_concepts

object p45 {

  val pentagonal = Iterator.from(1).map(BigInt(_)).map({ n => (3*n*n - n) / 2})
  val hexagonal = Stream.from(1).map(BigInt(_)).map({ n => 2*n*n - n })

  def isHexagonal(n : BigInt) = (hexagonal.takeWhile(_ <= n).last == n)

  lazy val solution = pentagonal
    .filter(isHexagonal(_))
    .drop(2)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
