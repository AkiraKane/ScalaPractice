package com.daystrom_data_concepts

import math.floor

object p94 {
  val limit = 1000000000

  def isInt(x: Double) = x == floor(x)

  val pairs = Euler.PellSolutions(3)

  /*
   * Express  solution  in  terms  of Pell's  Equation.   There  is  a
   * triangle with  equal sides  of length  $a$ and  a third  side $b$
   * where $\abs{a - b} = 1$ so that $(\frac{3a ± 1}{2})^2 - 3y^2 = 1.
   */
  val solution = pairs
    .drop(1) // Drop infeasible primitive solution
    .takeWhile(_._1 < 2 * limit).toList
    .map({ case (x,y) =>
      val a1 = (2 * x.toInt + 1)/3.0
      val b1 = a1 + 1
      val area1 = (b1 * y.toInt)/2.0
      val a2 = (2 * x.toInt - 1)/3.0
      val b2 = a2 - 1
      val area2 = (b2 * y.toInt)/2.0

      if (isInt(a1) && isInt(b1) && isInt(area1)) (a1.toInt, b1.toInt)
      else if (isInt(a2) && isInt(b2) && isInt(area2)) (a2.toInt, b2.toInt)
      else (0, 0)
    })
    .map({ case (a,b) => 2*a + b })
    .filter(_ < limit)
    .sum

  def main(args: Array[String]) = println(solution)
}
