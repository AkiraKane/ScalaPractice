package com.daystrom_data_concepts

object p63 {
  def power(a : Int, b : Int) = Iterator.fill(b)(BigInt(a)).product.toString

  def nDigitPowers(p : Int) = {
    Iterator.range(1,10).map(power(_,p))
      .dropWhile(_.length < p)
      .takeWhile(_.length == p)
      .length
  }

  lazy val solution = Iterator.range(1,200).map({ n => nDigitPowers(n) }).reduce(_ + _)

  def main(args: Array[String]) = {
    println(solution)
  }

}
