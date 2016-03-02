package com.daystrom_data_concepts

import Euler.fibsBig


object p137 {
  val n = 15

  /**
    * From the page [1]  we have A_{F}(x) = x/(1 - (x  + x^2)).  If we
    * are looking at instances where A_{F}(k) is a positive integer k,
    * the quadratic formula implies that x is rational if and only if
    *
    * (1+k)^{2} + 4k^{2}
    *
    * is a perfect square.  When  "74049690" is googled, the OEIS page
    * that gives the solution [2] is the first hit.
    *
    * 1. https://math.stackexchange.com/questions/338740/the-generating-function-for-the-fibonacci-numbers,
    * 2. https://oeis.org/A081018,
    */
  val solution = (0 until n).map({ i => fibsBig(4*i + 3) }).sum

  def main(args: Array[String]) = println(solution)
}
