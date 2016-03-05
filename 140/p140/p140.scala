package com.daystrom_data_concepts


object p140 {
  val limit = 30

  val P = -9; val Q = -4; val K = -14
  val R = -20; val S = -9; val L = -28

  /**
    * It can be  seen by googling and finding [1]  that the generating
    * function of the coefficients is
    *
    * G(x) = (1 + 3x)/(1 - x - x^2)
    *
    * so that
    *
    * A_{G}(x) = (x + 3x^2)/(1 - x - x^2)
    *
    * Setting A_{G}(x) equal to some integer k and using the quadratic
    * formula  shows that  x  is rational  if and  only  if (1+k)^2  +
    * 4(3+k)k is  a perfect square.   Substituting x := k  and setting
    * that equal  to some y^2  allows the Diophantine  equation solver
    * [2] to  be used.  That  solver does not give  initial solutions,
    * those can be gotten by  brute-forcing the equation for all small
    * solutions.
    *
    * 1. https://oeis.org/A000285
    * 2. https://www.alpertron.com.ar/QUAD.HTM
    */
  val streams = List (
    (BigInt(2), BigInt(7)),
    (BigInt(5), BigInt(14)),
    (BigInt(21), BigInt(50)),
    (BigInt(42), BigInt(97)),
    (BigInt(152), BigInt(343)),
    (BigInt(296), BigInt(665))
  ).map({ pair => Stream.iterate(pair)({ case (x,y) => (P*x + Q*y + K,  R*x + S*y + L) })
    .map({ _._1 })
    .filter({ _ > 0 })
  })

  val solution = Stream.iterate(0)(_ + 1)
    .flatMap({ i => streams.map({ stream => stream(i) }) })
    .take(limit)
    .sum

  def main(args: Array[String]) = println(solution)
}
