package com.daystrom_data_concepts

import math.pow


object p111 {

  def createTemplate(x: Int, digits: Int) = {
    Stream.iterate(x)(_ / 2)
      .map(_ % 2 == 1)
      .take(digits)
      .toList
  }

  def fillIn(template: List[Boolean], y: BigInt, d: Int): BigInt = {
    val numbers = y.toString.map(_ - '0')
    if (numbers.contains(d)) BigInt(4)
    else {
      val extra = List.fill(template.filter(_ == false).length - numbers.length)(0)
      val fill = (extra ++ numbers).toIterator

      template
        .map({ bool => if (bool) d; else fill.next })
        .foldLeft(BigInt(0))({ (acc, digit) => 10*acc + digit })
    }
  }

  def M(n: Int, d: Int) = {
    (1 until n).reverse.toIterator.map({ m =>
      Stream.range(0, pow(2,n).toInt)
        .map(createTemplate(_, n))
        .filter(_.filter(_ == true).length == m)
        .flatMap({ tmpl =>
          if (tmpl.last == true && ((d % 2) == 0 || d == 5)) Stream.empty[BigInt]
          else Stream.range(BigInt(0), Stream.fill(n-m)(BigInt(10)).product).map({ y => fillIn(tmpl, y, d) })
        })
        .filter(_.toString.length == n)
        .filter(_.isProbablePrime(333)) // Wow
    })
      .filter(_.nonEmpty)
      .next
      .toList
  }

  val solution = (0 to 9).flatMap({ d => M(10,d) }).sum

  def main(args: Array[String]) = println(solution)
}
