package com.daystrom_data_concepts

import math.{abs, min, max}
import scala.io.Source
import scala.collection.mutable

object p82 {
  val limit = 80
  val dim = limit - 1

  val matrix = Source.fromFile("p82/p082_matrix.txt")
    .mkString.split("\n").toList
    .map(_.split(",").map(_.toInt).toList)

  def columnSum(j: Int, state2: mutable.Map[Int, Seq[Int]]) = {
    state2.getOrElse(j, {
      val result = List.range(0,limit)
        .map(matrix(_)(j))
        .scanLeft(0)(_ + _)

      state2.put(j, result)
      result
    })
  }

  def optimize(
    i: Int, j: Int,
    state1: mutable.Map[(Int,Int), Int] = mutable.Map.empty[(Int,Int), Int],
    state2: mutable.Map[Int, Seq[Int]] = mutable.Map.empty[Int, Seq[Int]]
  ): Int = {
    if (i > dim || j > dim || i < 0 || j < 0) Integer.MAX_VALUE
    else if (j == dim) matrix(i)(j)
    else {
      state1.getOrElse((i,j), {
        val cs = columnSum(j, state2)
        val result = List.range(0,limit)
          .map({ i2 =>
            val currCost = matrix(i)(j)
            val colCost = if (i <= i2) (cs(i2+1) - cs(i+1)); else (cs(i) - cs(i2))
            val tailCost = optimize(i2, j+1, state1, state2)
            currCost + colCost + tailCost
          })
          .reduce(min(_,_))

        state1.put((i,j), result)
        result
      })
    }
  }

  val state1 = mutable.Map.empty[(Int, Int), Int]
  val state2 = mutable.Map.empty[Int, Seq[Int]]

  val solution = {
    List.range(0,limit)
      .map(optimize(_,0,state1,state2))
      .reduce(min(_,_))
  }

  def main(args: Array[String]) = println(solution)
}
