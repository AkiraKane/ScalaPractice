package com.daystrom_data_concepts

import Euler.fibsBig


object p138 {
  // val x = math.sqrt(1.25)

  // def compute(b: Int) = {
  //   val L = math.floor(x * b).toInt
  //   val h = b-1

  //   if (h*h + (b*b)/4 == L*L) Some(L)
  //   else None
  // }

  // val solution = Stream.iterate(1)(_ + 1)
  //   .flatMap(compute)
  //   .take(3)
  //   .toList

  /**
    * The above code gives the sequence List(17, 305, 5473), which can
    * be seen to be F(6n + 3)/2 by searching OEIS.
    */
  val solution = Stream.iterate(3)(_ + 6)
    .map({ n => fibsBig(n)/2 })
    .drop(1).take(12)
    .sum

  def main(args: Array[String]) = println(solution)
}
