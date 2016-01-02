package com.daystrom_data_concepts

object p61 {
  val natural = Stream.iterate(1)(_ + 1)

  val triangular = natural.map({ n => n*(n+1)/2 })
  val square     = natural.map({ n => n*n })
  val pentagonal = natural.map({ n => n*(3*n-1)/2 })
  val hexagonal  = natural.map({ n => n*(2*n-1) })
  val heptagonal = natural.map({ n => n*(5*n-3)/2 })
  val octagonal  = natural.map({ n => n*(3*n-2) })

  val lower = 1000
  val upper = 10000
  val size = 6

  val numberStreams = List(triangular, square, pentagonal, hexagonal, heptagonal, octagonal)
    .map({ list => list.dropWhile(_ < lower).takeWhile(_ < upper) })
    .take(size)

  def compatible(a : Int, b : Int) = if (a == -1) true; else ((a % 100) == (b / 100))

  def search(ns : List[Int], streams : Seq[Stream[Int]]) : Option[List[Int]] = {
    if ((ns.length >= size) && (compatible(ns.last, ns.head))) Some(ns)
    else if ((ns.length >= size) || (streams.length == 0)) None
    else {
      val n = if (ns.nonEmpty) ns.last; else -1
      val answer = streams.head
        .filter({ m => compatible(n,m) })
        .map({ m => search(ns ++ List(m), streams.tail) })
        .filter(_ != None)
      if (answer.nonEmpty) answer.head; else None
    }
  }

  lazy val solution = numberStreams.permutations
    .map(search(List.empty[Int], _))
    .filter(_ != None)
    .next

  def main(args: Array[String]) = {
    println(s"$solution ${solution.get.sum}")
  }

}
