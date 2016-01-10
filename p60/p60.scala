package com.daystrom_data_concepts

object p60 {
  def compatible(a : Int, b : Int) : Boolean =
    Euler.isPrime((a.toString ++ b.toString).toInt) && Euler.isPrime((b.toString ++ a.toString).toInt)

  val size = 5
  val limit = 10000

  def search(solution : List[Int], candidates : Stream[Int]) : Unit = {
    if (solution.length < size) {
      candidates.foreach({ n =>
        val nextSolution = n :: solution
        val nextCandidates = candidates.dropWhile(_ <= n).filter(compatible(_,n))
        search(nextSolution, nextCandidates) })
    }
    else if (solution.length >= size) {
      println(s"${solution} ${solution.sum}")
    }
  }

  lazy val primes = Stream.iterate(2)(_ + 1).filter(Euler.isPrime)

  lazy val candidates = primes
    .filter({ p => (p % 3 == 0) || (p % 3 == 1) })
    .takeWhile({ p => p <= limit })

  def main(args: Array[String]) = {
    println(search(List.empty[Int], candidates))
  }

}
