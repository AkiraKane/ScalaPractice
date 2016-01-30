package com.daystrom_data_concepts

import scala.io.Source


object p102 {
  type Point = (Double, Double)
  type Triangle = (Point, Point, Point)

  /* Orientation Test: https://www.cs.cmu.edu/~quake/robust.html */
  def test(a: Point, b: Point, c: Point) = {
    val (ax, ay) = a
    val (bx, by) = b
    val (cx, cy) = c
    (ax-cx)*(by-cy)-(ay-cy)*(bx-cx)
  }

  def pred(triangle: Triangle) = {
    val (a, b, c) = triangle
    val z = (0.0, 0.0)
    val tests = List(test(a,b,z), test(b,c,z), test(c,a,z))
     .map({ x => if (x > 0) 1; else if (x < 0) -1; else 0 }).sum
    ((tests == -3) || (tests == 3))
  }

  val data = Source.fromFile("100/p102/p102_triangles.txt")
    .mkString.split("\n")
    .map(_.split(",").map(_.toDouble).toList)
    .map({ case List(ax, ay, bx, by, cx, cy) => ((ax, ay), (bx, by), (cx, cy)) })
    .toStream

  val solution = data.filter(pred).length

  def main(args: Array[String]) = println(solution)
}
