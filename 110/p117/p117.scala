package com.daystrom_data_concepts

import scala.collection.mutable


object p117 {
  def combos(
    currentIndex: Int = -1,
    lastIndex: Int,
    cache: mutable.Map[Int, BigInt] = mutable.Map.empty[Int, BigInt]
  ): BigInt = {
    if (currentIndex > lastIndex) BigInt(0)
    else if (currentIndex == lastIndex) BigInt(1)
    else {
      val cached = cache.get(currentIndex)

      if (cached.nonEmpty) cached.get
      else {
        val black = combos(
          currentIndex = currentIndex + 1,
          lastIndex = lastIndex,
          cache = cache
        )
        val red = combos(
          currentIndex = currentIndex + 2,
          lastIndex = lastIndex,
          cache = cache
        )
        val green = combos(
          currentIndex = currentIndex + 3,
          lastIndex = lastIndex,
          cache = cache
        )
        val blue = combos(
          currentIndex = currentIndex + 4,
          lastIndex = lastIndex,
          cache = cache
        )
        val result = black + red + green +blue

        cache.put(currentIndex, result)
        result
      }
    }
  }

  val n = 50
  val solution = combos(lastIndex = (n-1))

  def main(args: Array[String]) = println(solution)
}
