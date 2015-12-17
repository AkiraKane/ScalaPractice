package com.daystrom_data_concepts

object p35 {

  val limit = 1000000
  val sqrtLimit = 1000

  def prime(n : Int) = List.range(2,sqrtLimit+1).takeWhile(_ < n).forall(n % _ != 0)

  def allRotations(n : Int) : List[Int] = {
    val str = n.toString
    List.range(0,str.length)
      .map({ m => str.drop(m) ++ str.take(m) })
      .map(_.toInt)
  }

  def pred(n : Int) = allRotations(n).forall(prime)

  val solution = Stream.from(0).take(limit).drop(2).filter(pred)

  def main(args: Array[String]) = {
    println(solution.length)
  }

}
