package com.daystrom_data_concepts


object p145 {
  val limit = 1000000000

  @inline def reverse(n: Int): Int = {
    var result = 0
    var m = n; while (m > 0) {
      result *= 10
      result += m % 10
      m /= 10
    }
    result
  }

  @inline def allOdd(n: Int): Boolean = {
    var m = n; while (m > 0) {
      if (((m % 10) % 2) != 1) return false
      m /= 10
    }
    true
  }

  @inline def predicate(n: Int): Boolean = {
    if (n % 10 != 0) {
      val m = reverse(n)
      allOdd(n + m)
    }
    else false
  }

  val solution = {
    var count = 0
    var i = 0; while(i < limit) {
      if (predicate(i)) count += 1
      i += 1
    }
    count
  }

  def main(args: Array[String]) = println(solution)
}
