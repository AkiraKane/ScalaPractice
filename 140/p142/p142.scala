package com.daystrom_data_concepts

import Euler.{gcd, natural}
import math.sqrt


object p142 {

  val triples = natural
    .flatMap({ m =>
      natural.takeWhile({ n => n <= m })
        .filter({ n => gcd(m,n) == 1 && ((m-n) % 2 == 1) })
        .map({ n => (m,n) }) })
    .map({ case (m,n) => (m*m - n*n, 2*m*n, m*m + n*n) })

  def isSquare(x: Int) = {
    val root = sqrt(x).toInt
    (root * root == x)
  }

  def check1(a: Int, guess: Stream[(Int, Int, Int)]) = {
    val Stream((c, f, _), (e, d, _)) = guess
    check(a, c, d, e, f)
  }

  def check2(a: Int, guess: Stream[(Int, Int, Int)]) = {
    val Stream((c, f, _), (d, e, _)) = guess
    check(a, c, d, e, f)
  }

  def check3(a: Int, guess: Stream[(Int, Int, Int)]) = {
    val Stream((f, c, _), (e, d, _)) = guess
    check(a, c, d, e, f)
  }

  def check4(a: Int, guess: Stream[(Int, Int, Int)]) = {
    val Stream((f, c, _), (d, e, _)) = guess
    check(a, c, d, e, f)
  }

  def check(a: Int, c: Int, d: Int, e: Int, f: Int) = {
    val z = (e*e - f*f)/2
    val y = (e*e + f*f)/2
    val x = a*a - y

    if (isSquare(x+y) && isSquare(x-y) && isSquare(x+z) && isSquare(x-z) && isSquare(y+z) && isSquare(y-z))
      List((x, y, z, x + y + z))
    else
      List()
  }

  /**
    * x + y = a^2
    * x - y = b^2
    * x + z = c^2
    * x - z = d^2
    * y + z = e^2
    * y - z = e^2
    *
    * Therefore,
    *
    * x + y = a^2 = c^2 + f^2 = e^2 + d^2
    * y = (e^2 + f^2)/2
    * z = (e^2 - f^2)/2
    * x = a^2 - y
    *
    * So we fix a^2 and look for two sets of Pythagorean
    * triples. Which give a x, y, z meeting the description.
    */
  def predicate(a: Int, guess: Stream[(Int, Int, Int)]) =
    (check1(a, guess) ++ check2(a, guess) ++ check3(a, guess) ++ check4(a, guess))

  val solution =
    natural.flatMap({ A =>
      triples.takeWhile({ case (_,_,c) => (c <= 2*A) })
        .flatMap({ case (a,b,c) =>
          natural.map({ k => (a*k, b*k, c*k) })
            .takeWhile({ case (_,_,c) => (c <= A) })
            .filter({ case (_,_,c) => c == A }) })
        .combinations(2)
        .flatMap({ pair => predicate(A, pair) })
    }).head

  def main(args: Array[String]) = println(solution)
}
