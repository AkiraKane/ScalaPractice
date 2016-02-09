package com.daystrom_data_concepts


object p112 {
  val cutoff = 99
  val zeros = BigInt("1000000000000")

  def bouncy(n: BigInt) = {
    val str = n.toString
    val sorted = str.sorted

    (str != sorted && str != sorted.reverse)
  }

  val bouncies = Euler.naturalBig
    .scanLeft(BigInt(0))({ (acc,n) => if (bouncy(n)) acc + 1; else acc })
    .drop(1)

  val bounciesPct = Euler.naturalBig.zip(bouncies)
    .map({ case (i,n) => (i, (zeros * n)/i) })

  val solution = bounciesPct.filter(_._2 >= cutoff * (zeros / 100)).head

  def main(args: Array[String]) = println(solution)
}
