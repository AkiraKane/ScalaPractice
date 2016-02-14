package com.daystrom_data_concepts

import math.{log, round, pow}


object p119 {
  def pred1(pair: (Int, Int)) = {
    val x = pair._2 % 10
    val y = pair._1 % 10

    (x match {
      case 0 => List(0)
      case 1 => List(1)
      case 2 => List(2,4,6,8)
      case 3 => List(1,3,7,9)
      case 4 => List(4,6)
      case 5 => List(5)
      case 6 => List(6)
      case 7 => List(1,3,7,9)
      case 8 => List(2,4,6,8)
      case 9 => List(1,9)
    }).contains(y)
  }

  def pred2(pair: (Int, Int)) = {
    val n = pair._1
    val b = pair._2
    val e = round(log(n) / log(b)).toInt

    (pow(b,e) == n)
  }

  val solution = Euler.natural.drop(9)
    .map({ n => (n, n.toString.map(_ - '0').sum) })
    .take(10000000)
    .filter(pred1).filter(pred2)
    .toList

  def main(args: Array[String]) = println(solution)
}
