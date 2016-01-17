package com.daystrom_data_concepts

object p33 {

  def curious(numer1 : Int, denom1 : Int) = {
    val shared = (numer1.toString.toSet & denom1.toString.toSet) - '0'
    val numer2 = numer1.toString.filter({ c => !shared.contains(c)})
    val denom2 = denom1.toString.filter({ c => !shared.contains(c)})

    if ((numer1 < denom1) && (shared.size > 0) && (numer2.length > 0) && (denom2.size > 0))
      ((numer1.toDouble / denom1.toDouble) == (numer2.toDouble / denom2.toDouble))
    else false
  }

  val prod = (for(
    x <- 10 to 99;
    y <- 10 to 99
    if (curious(x,y))) yield((x, y)))
    .reduce({ (ab, cd) => {
      val (a,b) = ab
      val (c,d) = cd
      (a*c,b*d) }})

  def main(args: Array[String]) = {
    val (a,b) = prod
    println(b / Euler.gcd(a,b))
  }

}
