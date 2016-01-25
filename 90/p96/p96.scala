package com.daystrom_data_concepts

import math.log
import scala.io.Source


object p99 {
  def ingest(puzzle: Seq[String]) = {
    puzzle
      .drop(1)
      .flatMap({ row =>
        row.map({ n =>
          (n - '0') match {
            case 0 => List.range(1,10).toSet
            case n: Int => Set(n)
          }
        })
      })
    .toArray
  }

  /* --------------------------------- */

  def get(array: Array[Set[Int]], x: Int, y: Int): Set[Int] = array(9*y + x)

  def put(array: Array[Set[Int]], x: Int, y: Int, set: Set[Int]): Unit = (array(9*y + x) = set)

  /* --------------------------------- */

  def known(list: Seq[Set[Int]]) = {
    // list.flatMap({ set => set.toList.map({ n => (n, 1.0/set.size) }) })
    //   .groupBy(_._1)
    //   .mapValues({ list => list.map(_._2).sum })
    //   .filter(_._2 >= 1)
    //   .map(_._1)
    //   .toSet
    list.filter(_.size == 1).flatten.toSet
  }

  def rowKnown(array: Array[Set[Int]], x: Int, y: Int) =
    known(List.range(0,9).filter(_ != x).map({ i => get(array, i, y) }))

  def colKnown(array: Array[Set[Int]], x: Int, y: Int) =
    known(List.range(0,9).filter(_ != y).map({ i => get(array, x, i) }))

  def boxKnown(array: Array[Set[Int]], x: Int, y: Int) = {
    val xs = (x/3) match {
      case 0 => (0 until 3)
      case 1 => (3 until 6)
      case 2 => (6 until 9)
    }
    val ys = (y/3) match {
      case 0 => (0 until 3)
      case 1 => (3 until 6)
      case 2 => (6 until 9)
    }

    known(for (col <- xs.filter(_ != x); row <- ys.filter(_ != y)) yield get(array, col, row))
  }

  def allKnown(array: Array[Set[Int]], x: Int, y: Int) = {
    val row = rowKnown(array, x, y)
    val col = colKnown(array, x, y)
    val box = boxKnown(array, x, y)

    (row union col union box)
  }

  /* --------------------------------- */

  def display(array: Array[Set[Int]]) = {
    var y = 0
    while (y < 9) {
      var x = 0
      while (x < 9) {
        val before = get(array, x, y)
        if (before.size == 1) print(before.toList.head); else print(0)
        x += 1
      }
      println
      y += 1
    }
  }

  def pass(array: Array[Set[Int]]) = {
    var x = 0
    while (x < 9) {
      var y = 0
      while (y < 9) {
        val before = get(array, x, y)
        val known = allKnown(array, x, y)
        val after = before &~ known
        put(array, x, y, after)
        y += 1
      }
      x += 1
    }
  }

  def solve(array: Array[Set[Int]]) =
    while (array.toList.filter(_.size == 1).length < 81)
      pass(array)

  /* --------------------------------- */

  val data = Source.fromFile("90/p96/p096_sudoku.txt")
    .mkString.split("\n").toList
    .grouped(10)
    .map(ingest)

  val solution = 33

  def main(args: Array[String]) = println(solution)
}
