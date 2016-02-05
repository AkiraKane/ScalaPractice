package com.daystrom_data_concepts


object p108 {
  def factors(n: Int) = Euler.natural.takeWhile(_ < n).filter(n % _ == 0)

  /* https://www.alpertron.com.ar/JQUAD.HTM */
  def score(n: Int) = {
    val pos = factors(n*n)
    val all = (pos ++ pos.map(_ * -1))

    all
      .map({ factor =>
        val other = (n*n)/factor
        val x = factor + n
        val y = other + n
        if (x >= y) (x,y); else (y,x) })
      .distinct
      .filter({ case (x, y) => (x > 0) && (y > 0) })
      .length
  }

  val solution = score(4)

  def main(args: Array[String]) = println(solution)
}
