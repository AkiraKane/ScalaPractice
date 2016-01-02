package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p61 {
  val lower = 1000
  val upper = 10000
  val size = 6

  val numberStreams =
    List(Euler.triangular,
      Euler.square,
      Euler.pentagonal,
      Euler.hexagonal,
      Euler.heptagonal,
      Euler.octagonal)
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
