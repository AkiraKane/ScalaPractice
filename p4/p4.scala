package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p4 {
  import scala.math.max

  val candidates = for (
    x <- List.range(999,99,-1);
    y <- List.range(999,99,-1);
    if Euler.isPalindrome(x*y)) yield x*y

  def main(args: Array[String]) = {
    println(candidates.reduce(max))
  }
}
