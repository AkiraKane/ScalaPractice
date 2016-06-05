package com.daystrom_data_concepts


object p152 {
  val limit = 80

  // Factors of 2, 3, 5, and 7 appear in the sample output, so they
  // are sufficient to solve the ≤ 45 case.  13, 39, and 52 are the
  // only factors of 13 that appears in the ≤ 80 case, and they always
  // appear together or not at all.
  val factors = (2 to 80).filter({ n => BigInt(n).isProbablePrime(1000) }).drop(4)
  val rootOne = (2*2*2*2*2*2*3*3*3*5*5*7*7*13).toLong
  val one = rootOne * rootOne
  val denoms = (3 to limit).filter({ n => !factors.exists({ m => n % m == 0 }) }).toArray
  val inverseSquares = denoms.map({ k => (one / k) / k }).toArray
  val tails = (0 until inverseSquares.length).map({ i => inverseSquares.drop(i).sum }).toArray

  def tabulate(residual: Long, i: Int, solution: List[Int] = List.empty[Int]): Int = {
    if (residual == 0) 1
    else if (residual < 0) 0
    else if (i >= tails.length) 0
    else if (residual > tails(i)) 0
    else {
      val yes = tabulate(residual - inverseSquares(i), i+1, denoms(i) :: solution)
      val no = tabulate(residual, i+1, solution)
      yes + no
    }
  }

  val thirteens = List(13, 39, 52).map({ k => (one / k) / k }).sum
  val answer = tabulate(one / 4, 0) + tabulate((one / 4) - thirteens, 0)

  def main(args: Array[String]) = println(answer)
}
