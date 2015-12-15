package com.daystrom_data_concepts

object p30 {

  def power5(a : Int) = math.pow(a,5).toInt

  def property(a : Int) = (a == (a.toString.map({ _ - '0'}).map(power5).sum))

  val limit = 5 * power5(9)

  lazy val solution = List.range(10,limit+1).filter(property).sum

  def main(args: Array[String]) = {
    println(solution)
  }
}
