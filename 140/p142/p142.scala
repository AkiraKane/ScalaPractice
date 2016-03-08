package com.daystrom_data_concepts

import Euler.gcd
import math.sqrt


object p142 {

  val triples = Stream.iterate(1)(_ + 1)
    .flatMap({ m =>
      Stream.iterate(1)(_ + 1)
        .takeWhile({ n => n <= m })
        .filter({ n => gcd(m,n) == 1 && ((m-n) % 2 == 1) })
        .map({ n => (m,n) }) })
    .map({ case (m,n) => (m*m - n*n, 2*m*n, m*m + n*n) })

  val solution = 42
  
  def main(args: Array[String]) = println(solution)
}
