package com.daystrom_data_concepts

import scala.collection.mutable
import com.daystrom_data_concepts._
import math.{floor, sqrt}

object p75 {
  val limit = 1500000

  val xs = Euler.natural.takeWhile(_ <= limit)

  /*
   * Use the generating formula from
   * https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
   * to generate all pairs (m,n) so that
   *
   *    a := m^2 - n^2
   *    b := 2mn
   *    c := m^2 + n^2
   *
   * is a primitive Pythagorean triple.
   */
  val pairs = xs.takeWhile({ m => 2*m*m + 2*m <= limit })
    .flatMap({ m =>
      xs.takeWhile({ n => (n < m) && (2*m*m + 2*m*n <= limit) })
        .filter({ n => ((m - n) % 2 == 1) && (Euler.gcd(m,n) == 1) })
        .map({ n => (m,n) })
    })

  val solution = pairs.flatMap({ case(m,n) =>
    val abc = 2*m*m + 2*m*n
    val ks = Euler.natural
    ks.map({ k => k*abc }).takeWhile(_ <= limit)
  })
    .groupBy(identity)
    .filter(_._2.length == 1)
    .size


  def main(args: Array[String]) = {
    println(solution)
  }
}
