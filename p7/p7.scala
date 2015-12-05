object p7 {

  def coprime(n : BigInt, list : Stream[BigInt]) : BigInt = {
    if (list.forall(p => n % p != 0)) return n
    else return (coprime(n + 1, list))
  }

  val primes : Stream[BigInt] = 2 #:: primes.map { n =>
    val smallerPrimes = n #:: primes.takeWhile(p => p < n)
    coprime(n + 1, smallerPrimes)
  }

  def main(args: Array[String]) = {
    println(primes(10001 - 1))
  }
}
