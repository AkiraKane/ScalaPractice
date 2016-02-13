package com.daystrom_data_concepts

import scala.collection.mutable


object p116 {
  def combos(
    atLeastOneColored: Boolean = false,
    currentIndex: Int = -1,
    lastIndex: Int,
    coloredLength: Int,
    cache: mutable.Map[(Boolean, Int), BigInt] = mutable.Map.empty[(Boolean, Int), BigInt]
  ): BigInt = {
    if (currentIndex > lastIndex) BigInt(0)
    else if (atLeastOneColored && (currentIndex == lastIndex)) BigInt(1)
    else {
      val key = (atLeastOneColored, currentIndex)
      val cached = cache.get(key)

      if (cached.nonEmpty) cached.get
      else {
        val black = combos(
          atLeastOneColored = atLeastOneColored,
          currentIndex = currentIndex + 1,
          lastIndex = lastIndex,
          coloredLength = coloredLength,
          cache = cache
        )
        val colored = combos(
          atLeastOneColored = true,
          currentIndex = currentIndex + coloredLength,
          lastIndex = lastIndex,
          coloredLength = coloredLength,
          cache = cache
        )
        val result = black + colored

        cache.put(key, result)
        result
      }
    }
  }

  val n = 50
  val red = combos(lastIndex = (n-1), coloredLength = 2)
  val green = combos(lastIndex = (n-1), coloredLength = 3)
  val blue = combos(lastIndex = (n-1), coloredLength = 4)
  val solution = red + green + blue

  def main(args: Array[String]) = println(solution)
}
