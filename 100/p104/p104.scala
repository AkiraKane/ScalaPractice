package com.daystrom_data_concepts

import scala.io.Source


object p104 {
  val ns = (1 to 9).map(_ + '0').toSet

  def first9(n: BigInt): BigInt = {
    var m = n
    while (m > BigInt("1000000000000000000")) m /= 1000000000
    while (m > 1000000000) m /= 10
    m
  }

  def pred1(n: BigInt) = {
    val one = (n % 1000000000).toString.toSet == ns
    lazy val two = first9(n).toString.toSet == ns
    one && two
  }

  lazy val solution = {
    var fn2 = BigInt(1)
    var fn1 = BigInt(1)
    var i = 3
    var fn = fn1 + fn2

    while(!pred1(fn)) {
      fn2 = fn1
      fn1 = fn
      fn = fn1 + fn2
      i += 1
    }
    i
  }

  def main(args: Array[String]) = println(solution)
}
