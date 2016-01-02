package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p35 {

  val limit = 1000000
  val sqrtLimit = 1000

  def allRotations(n : Int) : List[Int] = {
    val str = n.toString
    List.range(0,str.length)
      .map({ m => str.drop(m) ++ str.take(m) })
      .map(_.toInt)
  }

  def pred(n : Int) = allRotations(n).forall(Euler.isPrime)

  val solution = Stream.from(0).take(limit).drop(2).filter(pred)

  def main(args: Array[String]) = {
    println(solution.length)
  }

}
