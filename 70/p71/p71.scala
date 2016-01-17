package com.daystrom_data_concepts

object p71 {
  val limit = 1000000
  val fraction = 3.0 / 7

  lazy val solution = Euler.natural.take(limit)
    .map({ d =>
      val n = (fraction * d).toInt
      val gcd = Euler.gcd(n,d)
      (n/gcd, d/gcd, n.toDouble/d) })
    .filter(_._3 < fraction)
    .sortWith(_._3 < _._3)
    .last

  def main(args: Array[String]) = {
    println(solution)
  }
}
