package com.daystrom_data_concepts

import math.{abs, sqrt}


object p143 {
  type PointType = (Double, Double)

  val firstPoint: PointType = (0.0, 10.1)
  val secondPoint: PointType = (1.4, -9.6)

  def step(ps: (PointType, PointType)) = {
    val ((x0, y0), (x1, y1)) = ps

    /*
     * The equation for the normal at p1 comes from [1].  After solving
     * for y using [2], it is written as y = ax + c, where
     *
     * a := \frac{y_{1}}{4x_{1}}
     * c := \frac{3y_{1}}{4}
     *
     * 1. http://www.emathzone.com/tutorials/math-results-and-formulas/equations-of-tangent-and-normal-to-a-ellipse.html
     * 2. http://www.wolframalpha.com/
     */
    val a = y1 / (4.0 * x1)
    val c = (3.0 * y1) / 4.0

    /*
     * The reflection of p0 across the normal comes form [3].
     *
     * 3. https://stackoverflow.com/questions/3306838/algorithm-for-reflecting-a-point-across-a-line
     */
    val d = (x0 + (y0 - c) * a) / (1.0 + a*a)
    val (x0prime, y0prime) = (2.0*d - x0, 2.0*d*a - y0 + 2.0*c)

    /* The line between p1 and p2 is represented as y = mx + b */
    val m = (y0prime - y1) / (x0prime - x1)
    val b = (y1 - m*x1)

    /* y = mx + b is plugged into 4x^2 + y^2 = 100  to find the next point */
    val x2 = {
      val term1 = 2*math.sqrt(-b*b + 25.0*m*m + 100.0)
      val term2 = -b*m
      val denom = m*m + 4.0
      val lo = (-term1 + term2) / denom
      val hi = (term1 + term2) / denom

      if (abs(lo - x1) > abs(hi - x1)) lo; else hi
    }
    val y2 = m*x2 + b

    ((x1, y1), (x2, y2))
  }

  val solution = Stream.iterate((firstPoint, secondPoint))(step)
    .takeWhile({ case ((_, _), (x, y)) => abs(x) > 0.01 || y < 0.0 })
    .length

  def main(args: Array[String]) = println(solution)
}
