package com.daystrom_data_concepts

object p1 {
  def main(args: Array[String]) = {
    val list = List.range(1,1000)
      .filter(n => (n % 3 == 0) || (n % 5 == 0))
    println(list.sum)
  }
}
