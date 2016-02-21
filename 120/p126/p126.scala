package com.daystrom_data_concepts

import scala.collection.mutable


object p126 {
  val limit = 32768

  def count(x: Int, y: Int, z: Int, n: Int) =
    2*(x*y + y*z + x*z) + 4*(x + y + z + n - 2)*(n - 1)

  def countAll(m: Int) = {
    val list = mutable.ArrayBuffer.empty[Int]

    var x = 1
    while (count(x, x, x, 1) <= m) {
      var y = x
      while (count(x, y, x, 1) <= m) {
        var z = y
        while (count(x, y, z, 1) <= m) {
          var n = 1
          while (count(x, y, z, n) <= m) {
            list += count(x, y, z, n)
            n += 1
          }
          z += 1
        }
        y += 1
      }
      x += 1
    }

    list
  }

  val solution = countAll(limit)
    .groupBy(identity)
    .mapValues(_.length)
    .filter(_._2 == 1000)
    .map(_._1)
    .reduce(math.min)

  def main(args: Array[String]) = println(solution)
}
