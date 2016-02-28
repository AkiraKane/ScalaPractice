package com.daystrom_data_concepts

import math.log
import scala.io.Source


object p96 {
  type Puzzle = Map[(Int, Int), Int]

  def ingest(puzzle: Seq[String]) = {
    val state = puzzle
      .drop(1)
      .flatMap({ row => row.map({ n => n - '0' }) })

    List.range(0,82).zip(state)
      .map({ x => ((x._1 % 9, x._1 / 9), x._2) })
      .toMap
  }

  /* --------------------------------- */

  def colGet(puzzle: Puzzle, x: Int) =
    puzzle
      .filter(_._1._1 == x)
      .map(_._2)
      .filter(_ != 0)
      .toSet

  def rowGet(puzzle: Puzzle, y: Int) =
    puzzle
      .filter(_._1._2 == y)
      .map(_._2)
      .filter(_ != 0)
      .toSet

  def boxGet(puzzle: Puzzle, x0: Int, y0: Int) =
    puzzle
      .filter({ kv =>
        val ((x1, y1), _) = kv
        (((x0 / 3) == (x1 / 3)) && ((y0 / 3) == (y1 / 3))) })
      .map(_._2)
      .filter(_ != 0)
      .toSet

  def possible(puzzle: Puzzle, x: Int, y: Int) = {
    val colSet = colGet(puzzle, x)
    val rowSet = rowGet(puzzle, y)
    val boxSet = boxGet(puzzle, x, y)
    Set(1,2,3,4,5,6,7,8,9) &~ (colSet union rowSet union boxSet)
  }

  /* --------------------------------- */

  def solve(puzzle: Puzzle): Option[Puzzle] = {
    val spots = puzzle.filter(_._2 == 0).map(_._1)

    if (spots.isEmpty) {
      Some(puzzle)
    }
    else {
      val xy = spots.head
      val (x,y) = xy
      val solution = possible(puzzle, x, y).toIterator
        .map({ n => solve(puzzle + (xy -> n)) })
        .filter(_ != None)
      if (solution.nonEmpty) solution.next; else None
    }
  }

  /* --------------------------------- */

  val data = Source.fromFile("90/p96/p096_sudoku.txt")
    .mkString.split("\n").toList
    .grouped(10)
    .map(ingest)
    .map(solve)

  val solution = data.map({
    case Some(solution) =>
      val hundreds = 100 * solution.getOrElse((0,0),-1)
      val tens = 10*solution.getOrElse((1,0),-1)
      val ones = solution.getOrElse((2,0),-1)
      hundreds + tens + ones
    case None => throw new Exception })
    .sum

  def main(args: Array[String]) = println(solution)
}
