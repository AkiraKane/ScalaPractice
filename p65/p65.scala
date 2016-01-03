package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p65 {
  def sumOfDigits(n : BigInt) = n.toString.map(_ - '0').sum

  val zero = BigInt(0)
  val one = BigInt(1)
  val limit = 100
  val e = (List(2) #:: Stream.iterate(List(1,2,1))({ case List(_,twoK,_) => List(1,twoK+2,1) })).flatten

  lazy val solution = e.take(limit).foldRight((one,zero))(Euler.cfStep)

  def main(args: Array[String]) = {
    println(sumOfDigits(solution._1))
  }

}
