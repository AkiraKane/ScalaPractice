package com.daystrom_data_concepts

import math.{min, max, sqrt}

object p85 {
  val limit = 1000000

  def dist(a: Int, b: Int, c: Int) =
    min(sqrt(a*a + (b+c)*(b+c)), min(sqrt((a+c)*(a+c) + b*b), sqrt((a+b)*(a+b) + c*c)))

  def pred(a: Int, b: Int, c: Int) = (dist(a,b,c) % 1.0 == 0.0)

  def score(M: Int) = {
    var score = 0

    var a = 1; while (a <= M) {
      var b = a; while (b <= M) {
        var c = b; while (c <= M) {
          if (pred(a,b,c)) score += 1
          c += 1
        }
        b += 1
      }
      a += 1
    }
    score
  }

  // Narrowed by manual binary search before-hand.  This is more of a
  // proof than a constructive solution.
  val solution = Iterator.iterate(1816)(_ + 1).filter(i => score(i) > limit).next

  def main(args: Array[String]) = println(solution)
}
