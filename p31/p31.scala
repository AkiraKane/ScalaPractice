package com.daystrom_data_concepts

object p31 {
  import scala.collection.mutable

  def f(n : Int, coins : List[Int]) : Int = {
    if (n > 0) coins.map({ m => f(n-m, coins.filter({ _ >= m})) }).sum
    else if (n == 0) 1
    else 0
  }

  def main(args: Array[String]) = {
    println(f(200, List(1,2,5,10,20,50,100,200)))
  }
}
