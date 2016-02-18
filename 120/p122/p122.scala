package com.daystrom_data_concepts

import scala.collection.mutable
import math.{floor, log, min}


object p122 {
  val limit = 200
  val defaultPath = Stream.iterate(1)(_ * 2).takeWhile(_ <= limit).toList
  val defaultMap = mutable.Map(defaultPath.zip(Stream.iterate(0)(_ + 1)): _*)

  def m(
    path: List[Int] = defaultPath.reverse,
    map: mutable.Map[Int, Int] = defaultMap,
    fromStem: Int = 0
  ): Unit = {
    val n = path.head

    path.filter({ i => i + n <= limit })
      .foreach({ i =>
        val number = (i + n)
        val newPath = number :: path
        val current = map.getOrElse(number, Int.MaxValue)
        val possible = newPath.length - 1

        if (possible <= current) {
          map.put(number, possible)
          m(path = newPath, map = map, fromStem = (fromStem + 1) )
        }
      })
    if (fromStem == 0 &&  path.tail.nonEmpty) m(path.tail, map)
  }

  val solution = {
    m()
    (1 to min(limit, 200)).map({ i => defaultMap.get(i).get }).sum
  }

  def main(args: Array[String]) = println(solution)
}
