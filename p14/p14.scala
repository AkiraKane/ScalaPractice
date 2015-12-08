object p14 {

  val limit = BigInt(1000000)
  val zero = BigInt(1)
  val one = BigInt(1)
  val two = BigInt(2)

  def collatz(n : BigInt) : Map[BigInt, BigInt] = collatz(n, Map((one -> one)))

  def collatz(n : BigInt, map : Map[BigInt, BigInt]) : Map[BigInt, BigInt] = {
    map.get(n) match {
      case Some(_) => map
      case None => {
        val nPrime = if (n % 2 == 0) n / 2; else (3 * n) + 1
        val mapPrime = collatz(nPrime, map)
        mapPrime + (n -> (1 + mapPrime.getOrElse(nPrime, zero)))
      }
    }
  }

  def main(args: Array[String]) = {
    var i = 1
    var map = Map((one -> one))
    while (i < limit) {
      map = collatz(i, map)
      i += 1
    }
    val best = map.filter({ _._1 < limit }).foldLeft((zero, zero))({ (x,y) => if (x._2 > y._2) x; else y })
    println(best)
  }
}
