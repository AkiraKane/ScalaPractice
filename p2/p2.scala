package com.daystrom_data_concepts

object p2 {
  // http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci/
  lazy val fibs = Euler.fibs

  def main(args: Array[String]) = {
    val list = fibs
      .filter(n => n % 2 == 0)
      .takeWhile(n => n <= 4000000)
    println(list.sum)
  }
}
