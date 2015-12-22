package com.daystrom_data_concepts

object p55 {
  val limit1 = 10000
  val limit2 = 50

  def palindrome(str : String) = (str == str.reverse)

  def lychrel(n : BigInt) = {
    Iterator.iterate(n)({ n => n + BigInt(n.toString.reverse) })
      .drop(1)
      .take(limit2)
      .map(_.toString)
      .filter(palindrome(_))
      .take(1)
      .isEmpty
  }

  lazy val solution = Iterator.from(1)
    .take(limit1-1)
    .filter(lychrel(_))
    .length

  def main(args: Array[String]) = {
    println(solution)
  }
}
