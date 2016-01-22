package com.daystrom_data_concepts

import math.{floor, sqrt}

object p94 {
  val limit = 1000000000

  lazy val xs = Euler.natural.takeWhile(_ <= limit)

  /*
   * Use Pythagorean  triples to generate  near-equilateral triangles.
   * Such  a  triangle  can  be  thought of  as  two  right  triangles
   * back-to-back  so  that  the  hypotenuses   of  the  two  are  the
   * equal-length sides of the one.
   *
   * From https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
   * we have
   *
   *    a := m^2 - n^2
   *    b := 2mn
   *    c := m^2 + n^2
   *
   * so that 2a = c + 1 which implies m^2 - 1 == 3n^2
   * or else 2b = c + 1 which imples m^2 + n^2 - 4mn + 1 == 0
   */
  val ms = Stream.iterate(1)(_ + 1).takeWhile(_ < 15812)

  /* b and c */
  val bc = ms.map({ m => (m, sqrt(5*m*m - 1) - 2*m) })
    .filter({ case (m,n) => (m > 0) && (n > 0) })
    .map({ case (m,n) => ((m*m + n*n), 4*m*n) })

  /* a and c */
  val ac = ms.map({ m => (m, sqrt((m*m - 1) / 3)) })
    .filter({ case (m,n) => (m > 0) && (n > 0) })
    .map({ case (m,n) => ((m*m + n*n), 2*(m*m - n*n)) })

  val solution = (ac ++ bc)
    .filter({ case (one,two) => (one % 1.0 == 0.0) && (two % 1.0 == 0.0) && (one + 1 == two) })
    .map({ case(one, two) => (one + one + two).toInt })
    .sum

  def main(args: Array[String]) = println(solution)
}
