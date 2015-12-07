object p12 {

  import scalaz._
  import Scalaz._

  lazy val triangles : Stream[BigInt] = 1 #:: triangles.zip(Stream.from(2)).map({ pair => pair._1 + pair._2 })

  def coprime(n : BigInt, list : Stream[BigInt]) : BigInt = {
    if (list.forall(p => n % p != 0)) return n
    else return (coprime(n + 1, list))
  }

  lazy val primes : Stream[BigInt] = 2 #:: primes.map { n =>
    val smallerPrimes = n #:: primes.takeWhile(p => p < n)
    coprime(n + 1, smallerPrimes)
  }

  def findFactor(n: BigInt) : Option[BigInt] = {
    val factors = primes.filter(f => n % f == 0)
    val factor = factors(0)
    if (factor != n) Some(factor); else None
  }

  def factorize(n: BigInt) : State[Map[BigInt, Int], Unit] = modify { s : Map[BigInt, Int] =>
    {
      findFactor(n) match {
        case Some(prime) => {
          val (s1, _) = (for(
            _ <- factorize(n / prime);
            _ <- modify({ s2 : Map[BigInt, Int] => s2 + (prime -> (s2.getOrElse(prime, 0) + 1)) })
          ) yield ()).run(s)
          s1
        }
        case None => s + (n -> (s.getOrElse(n, 0) + 1))
      }
    }
  }

  def divisors(u : Unit) = gets { s : Map[BigInt, Int] =>
    s.map({ _._2 }).map({ _ + 1}).product
  }

  def score(n : BigInt) = factorize(n).flatMap(divisors).run(Map.empty[BigInt, Int])._2

  def main(args: Array[String]) = {
    val xs = triangles.drop(1).filter(n => score(n) > 500)
    println(xs(0))
  }
}
