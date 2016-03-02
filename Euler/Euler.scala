package com.daystrom_data_concepts

import scala.collection.mutable
import scala.math.{ceil,floor,sqrt,pow,max}

object Euler {
  lazy private val zero  = BigInt(0)
  lazy private val one   = BigInt(1)
  lazy private val two   = BigInt(2)
  lazy private val three = BigInt(3)

  /* http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci/ */
  lazy val fibs : Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}
  lazy val fibsBig : Stream[BigInt] = zero #:: one #:: fibsBig.zip(fibsBig.tail).map {n => n._1 + n._2}

  /**
   * Test the primality of an Int.
   */
  def isPrime(n: Int) = BigInt(n).isProbablePrime(1000)

  /**
    * Test the primality of a BigInt.
    */
  def isPrimeBig(n: BigInt) = n.isProbablePrime(1000)

  def isPalindrome(str : String) : Boolean = (str == str.reverse)
  def isPalindrome(n : Int) : Boolean = isPalindrome(n.toString)
  def isPalindrome(n : BigInt) : Boolean = isPalindrome(n.toString)

  lazy val primes = 2 #:: Stream.iterate(3)(_ + 2).filter(isPrime)
  lazy val primesBig = two #:: Stream.iterate(three)(_ + 2).filter(isPrimeBig)

  def power(n : Int, k : Int) = Iterator.fill(k)(n).product

  /**
   * Get the prime factors an integer.
   */
  def primeFactors(n : Int) : List[(Int,Int)] = {
    val factorItr = primes.toIterator.takeWhile({ p => p * p <= n }).filter({ p => n % p == 0 })

    if (n == 1) List.empty
    else if (factorItr.hasNext) {
      val p = factorItr.next
      var m = n / p
      var k = 1
      while (m % p == 0) {
        m /= p
        k += 1
      }
      (p,k) :: primeFactors(m)
    }
    else List((n,1))
  }

  def primeFactorsBig(n : BigInt) : List[(BigInt,Int)] = {
    val factorItr = primesBig.toIterator.takeWhile({ p => p * p <= n }).filter({ p => n % p == 0 })

    if (n == 1) List.empty
    else if (factorItr.hasNext) {
      val p = factorItr.next
      var m = n / p
      var k = 1
      while (m % p == 0) {
        m /= p
        k += 1
      }
      (p,k) :: primeFactorsBig(m)
    }
    else List((n,1))
  }

  /**
   * Compute the value  of the Euler Totient  function, $\phi(n)$, for
   * the     given    n.      Uses     observations    given     here:
   * https://en.wikipedia.org/wiki/Euler%27s_totient_function .
   */
  def phi(n : Int) = primeFactors(n).toIterator
    .map({ case(p,k) => pow(p,k-1).toInt * (p-1) }).product

  lazy val natural = Stream.iterate(1)(_ + 1)
  lazy val triangular = natural.map({ n => n*(n+1)/2 })
  lazy val square     = natural.map({ n => n*n })
  lazy val pentagonal = natural.map({ n => n*(3*n-1)/2 })
  lazy val hexagonal  = natural.map({ n => n*(2*n-1) })
  lazy val heptagonal = natural.map({ n => n*(5*n-3)/2 })
  lazy val octagonal  = natural.map({ n => n*(3*n-2) })

  lazy val naturalBig = Stream.iterate(one)(_ + 1)
  lazy val triangularBig = naturalBig.map({ n => n*(n+1)/2 })
  lazy val squareBig     = naturalBig.map({ n => n*n })
  lazy val pentagonalBig = naturalBig.map({ n => n*(3*n-1)/2 })
  lazy val hexagonalBig  = naturalBig.map({ n => n*(2*n-1) })
  lazy val heptagonalBig = naturalBig.map({ n => n*(5*n-3)/2 })
  lazy val octagonalBig  = naturalBig.map({ n => n*(3*n-2) })

  /**
   * Compute the gcd of two Ints or two BigInts.
   */
  def gcd(u : Int, v : Int) : Int = if (v != 0) gcd(v, u % v); else u
  def gcdBig(u : BigInt, v : BigInt) : BigInt = if (v != 0) gcdBig(v, u % v); else u

  /*
   * https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
   *
   * function extended_gcd(a, b)
   *  s := 0;    old_s := 1
   *  t := 1;    old_t := 0
   *  r := b;    old_r := a
   *  while r ≠ 0
   *    quotient := old_r div r
   *    (old_r, r) := (r, old_r - quotient * r)
   *    (old_s, s) := (s, old_s - quotient * s)
   *    (old_t, t) := (t, old_t - quotient * t)
   * output "Bézout coefficients:", (old_s, old_t)
   * output "greatest common divisor:", old_r
   * output "quotients by the gcd:", (t, s)
   */
  def extendedEuclidean(a: Int, b: Int) = {
    var s = 0; var old_s = 1
    var t = 1; var old_t = 0
    var r = b; var old_r = a

    while (r != 0) {
      val quotient = old_r / r
      val new_r = old_r - quotient * r; old_r = r; r = new_r
      val new_s = old_s - quotient * s; old_s = s; s = new_s
      val new_t = old_t - quotient * t; old_t = t; t = new_t
    }
    (old_s, old_t, old_r, t, s)
  }

  /**
   * Use Newton's  method to  find a  BigDecimal approximation  of the
   * square root of a given number.
   */
  def sqrtBig(n : BigInt, iterations : Int = 100) = {
    val mc = new java.math.MathContext(iterations)
    val N = BigDecimal(n,mc)
    val two = BigDecimal(2,mc)

    var xn = BigDecimal(1, mc)
    var i = iterations
    while (i >= 0) {
      val change = (xn - N/xn)/two
      xn -= change
      i -= 1
    }
    xn
  }

  /**
   * Find the continued fraction representation of a BigDecimal.
   */
  def continuedFraction(x : BigDecimal) = {
    val mc = new java.math.MathContext(x.precision)
    val zero = BigDecimal(0)
    val one = BigDecimal(1, mc)
    val fractional = x % one
    val whole = (x - fractional).toInt

    Stream.iterate((whole,fractional))({ case(_,fractional) =>
      val x = if (fractional != zero) one/fractional; else zero
      val fractional1 = x % one
      ((x - fractional1).toInt, fractional1)})
  }

  /**
   * Find the continued fraction representation of a square root.
   */
  def cfRoot(S : Int) = {
    val m0 = 0
    val d0 = 1
    val a0 = floor(sqrt(S)).toInt

    if (a0 * a0 == S) Stream.iterate((a0,0,0))({ _ => (0,0,0) })
    else {
      Stream.iterate((a0, d0, m0))({ case(an,dn,mn) =>
        // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
        val mn1 = dn*an - mn
        val dn1 = (S - mn1*mn1)/dn
        val an1 = floor((a0 + mn1)/dn1).toInt
        (an1, dn1, mn1)
      })
    }
  }

  /**
   * A function to incrementally  compute the fractional approximation
   * of  a continued  fraction.   This  function is  to  be used  with
   * foldRight, e.g. cf.foldRight((one,zero))(cfStep).
   */
  def cfStep(an : Int, acc : (BigInt, BigInt)) = {
    /* a_{n} + \frac{denom}{numer} */
    val numer = acc._1
    val denom = acc._2
    val numerNext = an * numer + denom
    val denomNext = numer
    val gcd = gcdBig(numerNext, denomNext)
    (numerNext / gcd, denomNext / gcd)
  }

  /**
   * A     solver    for     Pell's     equation.     According     to
   * https://en.wikipedia.org/wiki/Pell%27s_equation,  if  (x,y) is  a
   * solution, then  x/y approximates  sqrt(D).  It  is also  the case
   * that  the continued  fraction approximation  of sqrt(D)  produces
   * rational  approximations of  that root,  so this  function simply
   * successively  generates  possible  solutions from  the  continued
   * fraction until an actual solution is found.
   */
  def PellSolutions(D: Int) = {
    val start = (one,zero)
    val root = cfRoot(D).map(_._1)

    natural.toIterator
      .map({ i => root.take(i).foldRight(start)(cfStep) })
      .filter({ case (x,y) => x*x - D*y*y == 1 })
  }

  def PellSolve(D: Int) = PellSolutions(D).next

  /**
   * Find the longest common subsequence of two sequences.  This uses
   * the algorithm from
   * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem#Computing_the_length_of_the_LCS
   */
  def LCSLength[T](X: Seq[T], Y: Seq[T]) = {
    val m = X.length
    val n = Y.length
    val C = mutable.Map.empty[(Int,Int),Int]

    var i = 0
    while (i < m) {
      var j = 0
      while (j < n) {
        if (X(i) == Y(j)) C.put((i,j), C.getOrElse((i-1,j-1),0) + 1)
        else C.put((i,j), max(C.getOrElse((i,j-1),0), C.getOrElse((i-1,j),0)))
        j += 1
      }
      i += 1
    }
    C.getOrElse((m-1,n-1),0)
  }
}
