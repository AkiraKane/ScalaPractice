package com.daystrom_data_concepts

import scala.collection.mutable

object p74 {
  val state = mutable.Map.empty[BigInt, Int]

  def record(list: List[BigInt], offset: Int = 0) =
    list.zip(Euler.natural).map({ case(n,m) => state.put(n, m+offset) })

  def factorial(n: Int) =
    n match {
      case 0 => 1
      case 1 => 1
      case 2 => 2
      case 3 => 6
      case 4 => 24
      case 5 => 120
      case 6 => 720
      case 7 => 5040
      case 8 => 40320
      case 9 => 362880
    }

  def step(n: BigInt) = n.toString.map({ digit => BigInt(factorial(digit - '0')) }).sum

  def chain(n: BigInt, list: List[BigInt] = List.empty) : Unit = {
    val m = state.get(n)
    if (m != None) record(list, m.get)
    else if (list.contains(n)) record(list)
    else chain(step(n), n :: list)
  }

  val solution = {
    var i = 1
    while(i < 1000000) {
      chain(i)
      i += 1
    }
    state.values.filter(_ == 60).toList.length
  }

  def main(args: Array[String]) = {
    println(solution)
  }
}
