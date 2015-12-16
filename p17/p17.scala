package com.daystrom_data_concepts

object p17 {

  def translate(n : Int) : Int = {
    if (n >= 1000) return "thousand".length + translate(n / 1000) + translate(n % 1000)
    else if (n >= 100) return {
      val extra = if ((n % 100) == 0) 0; else "and".length
      "hundred".length + translate(n / 100) + extra + translate(n % 100)
    }
    else if (n >= 90) return "ninety".length + translate(n % 90)
    else if (n >= 80) return "eighty".length + translate(n % 80)
    else if (n >= 70) return "seventy".length + translate(n % 70)
    else if (n >= 60) return "sixty".length + translate(n % 60)
    else if (n >= 50) return "fifty".length + translate(n % 50)
    else if (n >= 40) return "forty".length + translate(n % 40)
    else if (n >= 30) return "thirty".length + translate(n % 30)
    else if (n >= 20) return "twenty".length + translate(n % 20)
    else if (n == 19) return "nineteen".length
    else if (n == 18) return "eighteen".length
    else if (n == 17) return "seventeen".length
    else if (n == 16) return "sixteen".length
    else if (n == 15) return "fifteen".length
    else if (n == 14) return "fourteen".length
    else if (n == 13) return "thirteen".length
    else if (n == 12) return "twelve".length
    else if (n == 11) return "eleven".length
    else if (n == 10) return "ten".length
    else if (n == 9) return "nine".length
    else if (n == 8) return "eight".length
    else if (n == 7) return "seven".length
    else if (n == 6) return "six".length
    else if (n == 5) return "five".length
    else if (n == 4) return "four".length
    else if (n == 3) return "three".length
    else if (n == 2) return "two".length
    else if (n == 1) return "one".length
    else return 0
  }

  def main(args: Array[String]) = {
    println(List.range(1,1001).map(translate).sum)
  }
}
