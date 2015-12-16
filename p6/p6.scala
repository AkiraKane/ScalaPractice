package com.daystrom_data_concepts

object p6 {
  val oneHundred = List.range(1,101)
  val oneHundredSum = oneHundred.sum

  def main(args: Array[String]) = {
    println(oneHundredSum * oneHundredSum - oneHundred.map(n => n * n).sum)
  }
}
