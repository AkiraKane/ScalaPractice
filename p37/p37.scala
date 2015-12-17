package com.daystrom_data_concepts

object p37 {
  def prime(n : Int) : Boolean = {
    if (n == 1) return false

    var m : Int = 2
    while((m <= math.ceil(math.sqrt(n)).toInt) && (m < n)) {
      if ((n % m) == 0) return false
      m += 1
    }
    return true
  }

  def shave(n : Int) = {
    val str = n.toString
    val left = List.range(1,str.length)
      .map(str.drop(_))
      .map(_.toInt)
    val right = List.range(1,str.length)
      .map(str.take(_))
      .map(_.toInt)
    left ++ right
  }

  def pred(n : Int) = shave(n).forall(prime)

  lazy val solution = Iterator.iterate(8)(_ + 1)
    .filter(prime)
    .filter(pred)
    .take(11)
    .sum

  def main(args: Array[String]) = {
    println(solution)
  }

}
