package com.daystrom_data_concepts

object p27 {
  def isPrime(n : Int) = {
    var i = math.ceil(math.abs(math.sqrt(n)))
    while (i > 1) { if (n % i == 0) i = 0; else i -= 1 }
    if (i == 1) true; else false
  }

  def score(a : Int, b : Int) = {
    var n = 0
    while (isPrime(n*n + a*n + b)) n += 1
    n
  }

  val limit = 1000

  val solution = (for(
    a <- -limit to limit;
    b <- -limit to limit) yield (a, b, a*b, score(a,b)))
    .reduce({ (x,y) => if (x._4 >= y._4) x; else y })

  def main(args: Array[String]) = {
    println(solution)
  }
}
