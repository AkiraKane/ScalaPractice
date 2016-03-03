package com.daystrom_data_concepts


object p136 {
  val limit = 50000000

  val counts = new Array[Int](limit+1)

  def compute() = {
    var x = 1; while (x <= limit) {
      var y = 1; while (x * y <= limit) {
        val n = x * y
        val d = (x + y) / 4
        val a = y - d
        if (3*d*d + 2*a*d - a*a == n && a > 0) counts(n) += 1
        y += 1
      }
      x += 1
    }
  }

  val solution = {
    compute()
    counts.filter({ _ == 1 }).size
  }

  def main(args: Array[String]) = println(solution)
}
