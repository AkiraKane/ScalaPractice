package com.daystrom_data_concepts

object p34 {

  def factorial(n : Int) = (1 to n).product

  def curious(n : Int) = (n.toString.map(_ - '0').map(factorial).sum == n)

  def main(args: Array[String]) = {
    var sum = 0
    var i = 10
    while (i <= 10000000) {
      if (curious(i)) sum += i
      i += 1
    }
    println(sum)
  }

}
