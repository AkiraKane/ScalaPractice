package com.daystrom_data_concepts

import scala.collection.mutable


object p114 {
  val limit = 50

  def combos(
    lastBlack: Boolean = true,
    currentIndex: Int = -1,
    lastIndex: Int = (limit - 1),
    cache: mutable.Map[(Boolean, Int), BigInt] = mutable.Map.empty[(Boolean, Int), BigInt]
  ): BigInt = {
    if (currentIndex > lastIndex) BigInt(0)
    else if (currentIndex == lastIndex) BigInt(1)
    else {
      val key = (lastBlack, currentIndex)
      val cached = cache.get(key)

      if (cached.nonEmpty) cached.get
      else {
        val black = combos(lastBlack = true, currentIndex + 1, lastIndex, cache)
        lazy val red = (3 to (lastIndex - currentIndex))
          .map({ length => combos(lastBlack = false, currentIndex + length, lastIndex, cache) })
          .sum
        val result = black + (if (lastBlack) red; else 0)

        cache.put(key, result)
        result
      }
    }
  }

  val solution = combos()

  def main(args: Array[String]) = println(solution)
}
