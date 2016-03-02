package com.daystrom_data_concepts


object p135 {
  val limit = 1000000

  def solutions(n: Int) = {
    var count = 0

    var x = 1
    while (x*x <= n) {
      if (n % x == 0) {
        val d = (x + n/x) / 4
        val a0 = n/x - d
        val a1 = x - d
        if (3*d*d + 2*a0*d - a0*a0 == n && a0 > 0) count += 1
        if (x != n/x && 3*d*d + 2*a1*d - a1*a1 == n && a1 > 0) count += 1
      }
      x += 1
    }
    count
  }

  val solution = Stream.iterate(1)(_ + 1)
    .takeWhile(_ <= limit)
    .filter({ n => solutions(n) == 10 })
    .length

  def main(args: Array[String]) = println(solution)
}
