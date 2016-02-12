package com.daystrom_data_concepts

import scala.collection.mutable


object p114 {
  def combos(
    lastBlack: Boolean = true,
    currentIndex: Int = -1,
    lastIndex: Int,
    minRedLength: Int,
    cache: mutable.Map[(Boolean, Int), BigInt] = mutable.Map.empty[(Boolean, Int), BigInt]
  ): BigInt = {
    if (currentIndex > lastIndex) BigInt(0)
    else if (currentIndex == lastIndex) BigInt(1)
    else {
      val key = (lastBlack, currentIndex)
      val cached = cache.get(key)

      if (cached.nonEmpty) cached.get
      else {
        val black = combos(lastBlack = true, currentIndex + 1, lastIndex, minRedLength, cache)
        lazy val red = (minRedLength to (lastIndex - currentIndex))
          .map({ length => combos(lastBlack = false, currentIndex + length, lastIndex, minRedLength, cache) })
          .sum
        val result = black + (if (lastBlack) red; else 0)

        cache.put(key, result)
        result
      }
    }
  }

  def main(args: Array[String]) = {
    println(s"F(3,50)=${combos(lastIndex=49, minRedLength=3)}")
    println(s"F(50,167)=${combos(lastIndex=166, minRedLength=50)} F(50,168)=${combos(lastIndex=167, minRedLength=50)}")
  }
}
