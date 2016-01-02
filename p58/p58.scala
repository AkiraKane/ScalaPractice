package com.daystrom_data_concepts

object p58 {
  def isPrime(n : Int) =
    if (n != 1) Iterator.iterate(2)(_ + 1).takeWhile({m => m * m <= n}).forall(n % _ != 0)
    else false

  val oddNumbers = Stream.iterate(1)(_ + 2)

  val spirals = oddNumbers.map({ n =>
    if (n == 1) (0,1)
    else {
      val sq = n*n
      val corner1 = sq - (n-1)
      val corner2 = corner1 - (n-1)
      val corner3 = corner2 - (n-1)

      (List(sq, corner1, corner2, corner3).filter(isPrime(_)).length,4)
    }})
    .scanLeft((0,0))({ (ab,cd) => (ab._1 + cd._1, ab._2 + cd._2) })
    .drop(1)
    .map({ case (n,d) => n.toFloat / d })
    .zip(oddNumbers)

  val solution = spirals.drop(1).dropWhile(_._1 > 0.10).head._2

  def main(args: Array[String]) = {
    println(solution)
  }
}
