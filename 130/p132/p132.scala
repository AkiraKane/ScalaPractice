package com.daystrom_data_concepts


object p132 {

  def cycleLength(n: Int) = {
    var i = 1
    var rem = 1

    while (rem % n != 0) {
      rem = (rem * 10 + 1) % n
      i += 1
    }
    i
  }

  val number = List.fill(9)(10).product

  def predicate(p: BigInt) = (number % cycleLength(p.toInt) == 0)

  val primes = 3 #:: Stream.iterate(BigInt(7))(_ + 2).filter(_ % 5 != 0).filter(_.isProbablePrime(1000))

  // If the cycle length divides 10^9, then the prime divides R(10^9)
  val solution = primes.filter(predicate).take(40).sum

  def main(args: Array[String]) = println(solution)
}
