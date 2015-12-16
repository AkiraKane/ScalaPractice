package com.daystrom_data_concepts

object p3 {
  import scala.math

  def isPrime(n : Int) = {
    val squareRoot = math.sqrt(n).toInt + 1
    val factors = Stream.range(squareRoot, 0, -1).filter(x => n % x == 0)
    factors(0) == 1
  }

  val N = BigInt("600851475143")
  val newton : Stream[BigInt] = (N / 1000000) #:: newton.map(x => x/2 + N/(2*x))
  val sqrtN = newton(33).toInt + 1
  val primeFactors = Stream.range(sqrtN, 1, -1).filter(x => N % x == 0).filter(isPrime)

  def main(args: Array[String]) = {
    println(primeFactors(0))
  }
}
