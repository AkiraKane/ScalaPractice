package com.daystrom_data_concepts


object p128 {
  val one = BigInt(1)
  val two = BigInt(2)

  val limit = 2000

  val seed = Stream.iterate(one)(_ + 1)
    .map({ n => 6*n })
    .scanLeft(two)(_ + _)

  val begin = seed
    .sliding(4).map({ _.toList })
    .map({ case List(x0, x, x2, x3) =>
      val a = x2
      val b = x2 + 1
      val c = x + 1
      val d = x0
      val e = x2 - 1
      val f = x3 - 1
      (x, List(a-x, b-x, c-x, x-d, e-x, f-x)) })

  val end = seed
    .sliding(4).map({ _.toList })
    .map({ case List(x0, x1, x2, x3) =>
      val x = x2 - 1
      val a = x3 - 1
      val b = x1
      val c = x0
      val d = x1 - 1
      val e = x2 - 2
      val f = x3 - 2
      (x, List(a-x, x-b, x-c, x-d, x-e, f-x)) })

  val solution = Iterator.continually({ List(begin.next, end.next) }).flatten
    .filter(_._2.filter(_.isProbablePrime(1000)).length == 3)
    .drop(limit-3)
    .next

  def main(args: Array[String]) = println(solution)
}
