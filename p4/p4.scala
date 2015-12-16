package com.daystrom_data_concepts

object p4 {
  import scala.math

  def isPalindrome(n : Int) = {
    val str = n.toString
    str == str.reverse
  }

  val candidates = for (
    x <- List.range(999,99,-1);
    y <- List.range(999,99,-1);
    if isPalindrome(x*y)) yield x*y

  def main(args: Array[String]) = {
    println(candidates.reduce(math.max))
  }
}
