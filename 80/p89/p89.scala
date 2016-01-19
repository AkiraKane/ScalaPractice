package com.daystrom_data_concepts

import scala.io.Source

object p89 {
  def romanRead(n: String) = {
    var prev: Char = 0
    var total: Int = 0

    n.foreach({ c =>
      c match {
        case 'I' => total += 1
        case 'V' => if (prev == 'I') total += 3; else total += 5
        case 'X' => if (prev == 'I') total += 8; else total += 10
        case 'L' => if (prev == 'X') total += 30; else total += 50
        case 'C' => if (prev == 'X') total += 80; else total += 100
        case 'D' => if (prev == 'C') total += 300; else total += 500
        case 'M' => if (prev == 'C') total += 800; else total += 1000
      }
      prev =  c
    })
    total
  }

  def romanWrite(n: Int): String = {
    if (n >= 1000) "M" ++ romanWrite(n - 1000)
    else if (n >= 900) "CM" ++ romanWrite(n - 900)
    else if (n >= 500) "D" ++ romanWrite(n - 500)
    else if (n >= 400) "CD" ++ romanWrite(n - 400)
    else if (n >= 100) "C" ++ romanWrite(n - 100)
    else if (n >= 90) "XC" ++: romanWrite(n - 90)
    else if (n >= 50) "L" ++ romanWrite(n - 50)
    else if (n >= 40) "XL" ++ romanWrite(n - 40)
    else if (n >= 10) "X" ++ romanWrite(n - 10)
    else if (n >= 9) "IX" ++ romanWrite(n - 9)
    else if (n >= 5) "V" ++ romanWrite(n - 5)
    else if (n >= 4) "IV" ++ romanWrite(n - 4)
    else if (n > 0) "I" ++ romanWrite(n - 1)
    else ""
  }

  def score(n: String) = n.length - romanWrite(romanRead(n)).length

  lazy val data = Source.fromFile("80/p89/p089_roman.txt")
    .mkString.split("\n").toList

  val solution = data.map(score).sum

  def main(args: Array[String]) = println(solution)
}
