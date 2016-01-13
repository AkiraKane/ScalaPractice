package com.daystrom_data_concepts

import math.min
import scala.io.Source
import scala.collection.mutable

object p81 {
  val dim = 80 - 1

  val matrix = Source.fromFile("p81/p081_matrix.txt")
    .mkString.split("\n").toList
    .map(_.split(",").map(_.toInt).toList)

  def optimize(i: Int, j: Int, state: mutable.Map[(Int,Int), Int] = mutable.Map.empty[(Int,Int), Int]): Int = {
    if (i > dim || j > dim) Integer.MAX_VALUE
    else if (i == dim && j == dim) matrix(i)(j)
    else {
      val ij = (i,j)
      state.getOrElse(ij, {
        val right = optimize(i+1, j+0, state)
        val down  = optimize(i+0, j+1, state)
        val result = matrix(i)(j) + min(right, down)

        state.put(ij, result)
        result
      })
    }
  }

  val solution = optimize(0,0)

  def main(args: Array[String]) = println(solution)
}
