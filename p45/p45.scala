package com.daystrom_data_concepts

object p45 {

  val triangle = Iterator.from(1).map(BigInt(_)).map({ n => (n*n + n) / 2 })
  val pentagonal = Stream.from(1).map(BigInt(_)).map({ n => (3*n*n - n) / 2})
  val hexagonal = Stream.from(1).map(BigInt(_)).map({ n => 2*n*n - n })

  def isPentagonal(n : BigInt) = (pentagonal.takeWhile(_ <= n).last == n)
  def isHexagonal(n : BigInt) = (hexagonal.takeWhile(_ <= n).last == n)

  lazy val solution = triangle
    .filter(isPentagonal(_))
    .filter(isHexagonal(_))
    .drop(2)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
