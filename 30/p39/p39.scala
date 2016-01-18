package com.daystrom_data_concepts

object p39 {

  def triangles(p : Int) = {
    for(
      a <- List.range(1,p);
      b <- List.range(1,p);
      if ((a <= b) && (a + b + math.sqrt(a*a + b*b) == p))) yield ((a,b))
  }

  val solution = List.range(1,1001)
    .map({ n => (n, triangles(n).length) })
    .reduce({ (x, y) => if (x._2 > y._2) x; else y })

  def main(args: Array[String]) = {
    println(solution._1)
  }
}
