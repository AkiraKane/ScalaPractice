package com.daystrom_data_concepts

import scala.math.{log, pow}


object p154 {
  val limit = 200000

  /* The number of powers of m in n */
  def powers(m: Int)(n: Int) = {
    val p = (log(limit) / log(m)).toInt
      (p to 0 by -1).toStream
      .filter({ i =>
        val power = pow(m, i).toInt
        ((n % power) == 0)
      })
      .head
  }

  /* The number of powers of two in n! */
  val factorialTwos = (1 to limit).map(powers(2)).scanLeft(0)(_ + _).toArray

  /* The number of powers of five in n! */
  val factorialFives = (1 to limit).map(powers(5)).scanLeft(0)(_ + _).toArray

  val answer = factorialFives(limit/2) + 2*factorialFives(limit/4)

  def main(args: Array[String]) = println(answer)
}
