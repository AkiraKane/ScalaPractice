package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p37 {
  def shave(n : Int) = {
    val str = n.toString
    val left = List.range(1,str.length)
      .map(str.drop(_))
      .map(_.toInt)
    val right = List.range(1,str.length)
      .map(str.take(_))
      .map(_.toInt)
    left ++ right
  }

  def pred(n : Int) = shave(n).forall(Euler.isPrime)

  lazy val solution = Iterator.iterate(8)(_ + 1)
    .filter(Euler.isPrime)
    .filter(pred)
    .take(11)
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }

}
