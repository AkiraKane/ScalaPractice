package com.daystrom_data_concepts

object p45 {

  def isHexagonal(n : BigInt) = (Euler.hexagonalBig.takeWhile(_ <= n).last == n)

  lazy val solution = Euler.pentagonalBig.toIterator
    .filter(isHexagonal(_))
    .drop(2)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
