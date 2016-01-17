package com.daystrom_data_concepts

object p20 {

  def main(args: Array[String]) = {
    val factorial = (List.range(1,101) : List[BigInt]).product

    println(factorial.toString.map({ _ - '0' }).sum)
  }
}
