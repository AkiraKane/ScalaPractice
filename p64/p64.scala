package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p64 {
  val precision = 150
  val limit = 10000

  def odd(n : Int) = {
    val cf = Euler.cfRoot(n).map(_._1)
    if (cf(1) == 0) false
    else {
      val head = cf(0)
      val period = cf.indexWhere(_ == 2*head)
      period % 2 == 1
    }
  }

  lazy val solution = Iterator.range(2,limit+1).filter(odd).length

  def main(args: Array[String]) = {
    println(solution)
  }

}
