package com.daystrom_data_concepts


object p130 {
  def a(n: Int) = {
    var i: Int = 1
    var rem: Int = 1

    while (rem % n != 0) {
      rem = (rem * 10 + 1) % n
      i += 1
    }
    i
  }

  val solution = Iterator.iterate(3)(_ + 2)
    .filter(_ % 5 != 0)
    .filter({ n => !(BigInt(n).isProbablePrime(1000)) })
    .filter({ n => (n - 1) % a(n) == 0 })
    .take(25)
    .sum

  def main(args: Array[String]) = println(solution)
}
