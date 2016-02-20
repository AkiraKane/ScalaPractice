package com.daystrom_data_concepts


object p125 {
  val limit = 100000000

  val squares = Stream.iterate(BigInt(1))(_ + 1)
    .map({ n => n * n })
    .takeWhile(_ < limit)

  def palindrome(n: BigInt) = {
    val str = n.toString
    (str == str.reverse)
  }

  def palindromes(ns: Stream[BigInt]) = {
    ns.scanLeft(BigInt(0))({ (acc,n) => acc + n })
      .takeWhile(_ < limit)
      .drop(2) // Drop the zero added by scanLeft, as well as the
               // first item of the running sum, which is the sum of
               // only one square.
      .filter(palindrome)
  }

  def allPalindromes(ns: Stream[BigInt]) = {
    var result = Stream.empty[BigInt]
    var numbers = ns

    while (numbers.nonEmpty) {
      result ++= palindromes(numbers)
      numbers = numbers.tail
    }
    result.distinct
  }

  val solution = allPalindromes(squares).sum

  def main(args: Array[String]) = println(solution)
}
