package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p51 {
  def change(p : Int) = {
    val pStr = p.toString

    /* For every allowable n less than or equal to the length of the decimal representation of p ... */
    Iterator.range(1, pStr.length).map({ n => {
      val changes = List.fill(n)(true) ++ List.fill(pStr.length - n)(false)
      val perms = changes.permutations.filter(_.last == false)

      /* ... for every choice of n digits to change ... */
      perms.map({ perm =>
        if (pStr.zip(perm).filter(_._2).map(_._1).toSet.size == 1) {
          /* ... for every allowable choice of a digit to put in those n places ... */
          "0123456789".map({ digit =>
            pStr.zip(perm)
              .map({ pair => if (pair._2 == true) digit; else pair._1 })
              .mkString })
            .filter(_.head != '0')
            .map(_.toInt)
            .filter(Euler.isPrime)
            .length
        } else 0
      })
        .reduce(math.max(_,_)) }})
      .foldLeft(0)(math.max(_,_))
  }

  lazy val solution = Euler.primes.toIterator
    .takeWhile(_ < 1000000)
    .map({ p => (p, change(p)) })
    .filter(_._2 == 8)
    .next

  def main(args: Array[String]) = {
    println(solution)
  }
}
