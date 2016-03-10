package com.daystrom_data_concepts

import Euler.natural

import scala.collection.mutable
import math.{acos, cos, round, sqrt, toRadians}


object p143 {
  val limit = 1200

  @inline def toricelli(a: Int, b: Int, c: Int) = {
    val angle1 = acos((a*a + b*b - c*c) / (2.0*a*b))
    val angle2 = toRadians(60)
    val a_to_n = a*a + b*b - 2*a*b*cos(angle1 + angle2)
    val root = round(sqrt(a_to_n)).toInt

    if (root * root == a_to_n) root; else 0
  }

  def triangles() = {
    val set = mutable.Set.empty[Int]
    var x = 0

    var a = 1; while (a <= limit) {
      var b = a+1; while (a + b <= limit) {
        var c = b+1; while (c <= (a + b)) {
          x += 1
          val numerator = a*a + b*b - c*c
          val denominator = 2.0*a*b
          if ((numerator / denominator) >= -0.5) {
            set += toricelli(a, b, c)
          }
          c += 1
        }
        b += 1
      }
      a += 1
    }
    (x, set)
  }

  val solution = triangles

  def main(args: Array[String]) = println(solution)
}
