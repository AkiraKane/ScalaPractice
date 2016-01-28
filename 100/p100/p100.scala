package com.daystrom_data_concepts


object p100 {
  val cutoff = BigInt("1000000000000")

  val solution = {
    var blue = BigInt(85)
    var total = BigInt(85 + 35)

    while (total < cutoff) {
      val oldBlue = blue
      /* https://www.alpertron.com.ar/JQUAD.HTM */
      blue = 3*blue + 2*total - 2
      total = 4*oldBlue + 3*total - 3
    }
    blue
  }

  def main(args: Array[String]) = println(solution)
}
