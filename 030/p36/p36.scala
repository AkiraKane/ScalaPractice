package com.daystrom_data_concepts

object p36 {

  val limit = 1000000

  def pred(n : Int) = {
    val str = n.toString
    val binStr = n.toBinaryString
    ((str == str.reverse) && (binStr == binStr.reverse))
  }

  val solution = Stream.from(0).take(limit).filter(pred).sum

  def main(args: Array[String]) = {
    println(solution)
  }

}
