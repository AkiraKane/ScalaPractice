package com.daystrom_data_concepts

import math.pow


object p101 {
  def power(b: Int, e: Int) = Iterator.fill(e)(BigDecimal(b)).product

  val xs = Stream.iterate(1)(_ + 1)
  val ys = xs.map({ n => 1 - n + power(n,2) - power(n,3) + power(n,4) - power(n,5) + power(n,6) - power(n,7) + power(n,8) - power(n,9) + power(n,10) })
  // val ys = xs.map({ n => power(n,3) })

  def bigL(x: Double, k: Int) =
    (0 to k).map({ j => ys(j)*ell(x,j,k) }).sum

  def ell(x: Double, j: Int, k: Int) =
    (0 to k).filter(_ != j).map({ m => ((BigDecimal(x) - xs(m))/(xs(j) - xs(m))) }).product

  def fit(k: Int) = {
    val op = xs.map({ x => bigL(x,k) })
    op.zip(ys).dropWhile({ pair => pair._1 == pair._2 }).head._1
  }

  val solution = (0 until 10).map(fit).sum

  def main(args: Array[String]) = println(solution)
}
