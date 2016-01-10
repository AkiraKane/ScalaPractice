package com.daystrom_data_concepts

import scala.collection.mutable
import com.daystrom_data_concepts._

object p76 {
  val pattern = Stream.continually(List(1,1,-1,-1)).flatten

  val generalizedPentagonal = Stream.iterate(1)(_ + 1)
    .flatMap({ n => List(n, -n) })
    .map({ n => n*(3*n - 1)/2 })

  val state = mutable.Map.empty[Int,Int]

  /* Use the formula from https://en.wikipedia.org/wiki/Partition_(number_theory)#Generating_function */
  def partition(n: Int): Int = {
    if (n < 0) 0
    else if (n <= 1) 1
    else {
      state.getOrElse(n, {
        val ks = generalizedPentagonal.map({ k => n-k }).takeWhile(_ >= 0).map(partition)
        val result = ks.zip(pattern).map({ x => x._1 * x._2 }).sum
        state.put(n, result)
        result
      })
    }
  }

  val solution = partition(100) - 1

  def main(args: Array[String]) = {
    println(solution)
  }
}
