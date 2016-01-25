package com.daystrom_data_concepts

import math.log
import scala.io.Source


object p99 {

  val data = Source.fromFile("90/p99/p099_base_exp.txt")
    .mkString.split("\n")
    .map(_.split(",").toList)
    .map({ case List(b,e) => e.toInt * log(b.toInt) })
    .zip(Euler.natural)

  val solution = data.reduce({ (l,r) => if (l._1 > r._1) l; else r })._2

  def main(args: Array[String]) = println(solution)
}
