package com.daystrom_data_concepts

object p91 {
  val limit = 50

  def predicate(quad: (Int, Int, Int, Int)) = {
    val (x1, y1, x2, y2) = quad
    val a = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)
    val b = x1*x1 + y1*y1
    val c = x2*x2 + y2*y2
    if ((x1 == 0) && (y1 == 0)) false
    else if ((x2 == 0) && (y2 == 0)) false
    else if ((x1 == x2) && (y1 == y2)) false
    else if (x1 > x2) false
    else if ((x1 == x2) && (y1 > y2)) false
    else ((a + b == c) || (a + c == b) || (b + c == a))
  }

  val candidates = for(
    x1 <- (0 to limit);
    y1 <- (0 to limit);
    x2 <- (0 to limit);
    y2 <- (0 to limit)) yield (x1,x2,y1,y2)

  val solution = candidates.filter(predicate).length

  def main(args: Array[String]) = println(solution)
}
