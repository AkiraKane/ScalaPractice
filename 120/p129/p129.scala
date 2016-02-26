package com.daystrom_data_concepts


object p129 {
  val limit = 1000000

  def a(n: Int) = {
    var i: Int = 1
    var rem: Int = 1

    while (rem % n != 0) {
      rem = (rem * 10 + 1) % n
      i += 1
    }
    i
  }


  val solution = Iterator.iterate(limit + 1)(_ + 2)
    .filter(_ % 5 != 0)
    .map({ n => (n, a(n)) })
    .filter(_._2 > limit)
    .next

  def main(args: Array[String]) = println(solution)
}
