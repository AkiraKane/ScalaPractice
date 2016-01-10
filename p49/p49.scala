package com.daystrom_data_concepts

object p49 {
  val magic = 3330

  val solution = Euler.primesBig.toIterator
    .dropWhile(_ < 1000)
    .takeWhile(_ < 10000)
    .map({ p => (p, p+magic, p+magic+magic) })
    .filter({ triple => Euler.isPrimeBig(triple._2) && Euler.isPrimeBig(triple._3) })
    .filter({ triple => {
      val one = triple._1.toString.toSet
      val two = triple._2.toString.toSet
      val thr = triple._3.toString.toSet
      (one == two) && (two == thr) }})
    .map({ triple => triple._1.toString ++ triple._2.toString ++ triple._3.toString })
    .drop(1)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
