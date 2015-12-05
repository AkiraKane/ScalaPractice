object p10 {
  val below = 2000000
  val divisors = List.range(2,1415)
  val primes = List.range(2,below)
    .filter(n => divisors
      .takeWhile(d => d < n && d < math.sqrt(n) + 1)
      .forall(p => n % p != 0))
    .map(n => BigInt(n))

  def main(args: Array[String]) = {
    println(primes.sum)
  }
}
