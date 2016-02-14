package com.daystrom_data_concepts

import math.{ceil, max}


object p120 {
  /**
    * 2an is the remainder for n = 2k+1.
    *
    * 2an ≡ 0 mod a^2, implies 2an = a^2, implies n = a/2.
    *
    * Maximized at n = (a-1)/2.
    */
  def maxR(a: Int) = 2*a*((a-1)/2)

  val solution = (3 to 1000).map(maxR).sum

  def main(args: Array[String]) = println(solution)
}
