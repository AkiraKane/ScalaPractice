package com.daystrom_data_concepts

import scala.math.{ceil,floor,sqrt}

object Euler {
  lazy private val zero = BigInt(0)
  lazy private val one  = BigInt(1)
  lazy private val two  = BigInt(2)

  // http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci/
  lazy val fibs : Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}
  lazy val fibsBig : Stream[BigInt] = zero #:: one #:: fibsBig.zip(fibsBig.tail).map {n => n._1 + n._2}

  /**
   * Test the primality of an Int.
   */
  def isPrime(n : Int) = {
    if (n == 1) false
    else if (n == 2) true
    else {
      var i = math.ceil(math.sqrt(n))
      while (i > 1) { if (n % i == 0) i = 0; else i -= 1 }
      if (i == 1) true; else false
    }
  }

  /**
   * Test the primality of a BigInt.
   */
  def isPrimeBig(n : BigInt) = {
    if (n == 1) false
    else if (n == 2) true
    else {
      var i = two
      while ((i < n) && (i < n*n)) { if (n % i == 0) i = n + 33; else i += 1 }
      if (i == n + 33) false ; else true
    }
  }

  def isPalindrome(str : String) : Boolean = (str == str.reverse)
  def isPalindrome(n : Int) : Boolean = isPalindrome(n.toString)
  def isPalindrome(n : BigInt) : Boolean = isPalindrome(n.toString)

  lazy val primes = Stream.iterate(2)(_ + 1).filter(isPrime)
  lazy val primesBig = Stream.iterate(two)(_ + 1).filter(isPrimeBig)

  def power(n : Int, k : Int) = Iterator.fill(k)(n).product

  /**
   * Get the prime factors an integer.
   */
  def primeFactors(n : Int) : List[(Int,Int)] = {
    val factorItr = primes.toIterator.takeWhile({ p => p * p <= n }).filter({ p => n % p == 0 })

    if (factorItr.hasNext) {
      val p = factorItr.next
      var m = n / p
      var k = 1
      while (m % p == 0) {
        m /= p
        k += 1
      }
      (p,k) :: primeFactors(m)
    }
    else if (n != 1) List((n,1))
    else List.empty
  }

  /**
   * Computer the value of the  Euler Totient function, $\phi(n)$, for
   * the     given    n.      Uses     observations    given     here:
   * https://en.wikipedia.org/wiki/Euler%27s_totient_function .
   */
  def phi(n : Int) = primeFactors(n).toIterator.map({ p => 1 - 1.0/p._1 }).product * n

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

  /**
   * Use Newton's  method to  find a  BigDecimal approximation  of the
   * square root of a given number.
   */
  def sqrtBig(n : Int, iterations : Int = 100) = {
    val mc = new java.math.MathContext(iterations)
    val N = BigDecimal(n,mc)
    val two = BigDecimal(2,mc)

    var xn = BigDecimal(sqrt(n), mc)
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
  def PellSolve(D : Int) = {
    val start = (one,zero)
    val root = Euler.cfRoot(D).map(_._1)

    Euler.natural.toIterator
      .map({ i => root.take(i).foldRight(start)(Euler.cfStep) })
      .filter({ case (x,y) => x*x - D*y*y == 1 })
      .next
  }


}