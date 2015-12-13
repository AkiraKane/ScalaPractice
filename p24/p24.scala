package com.daystrom_data_concepts

object p24 {

  def factorial(n : Int) = if (n < 1) 1; else List.range(1, n+1).product

  def perm(items : List[Char], n : Int) : List[Char] = {
    if (items.length == 0) List()
    else {
      val size = factorial(items.length - 1)
      val item = List(items(n / size))
      item ++ perm(items diff item, n % size)
    }
  }

  val limit = 1000000

  def main(args: Array[String]) = {
    println(perm("0123456789".toList, limit - 1))
  }
}
