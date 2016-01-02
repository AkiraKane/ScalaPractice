package com.daystrom_data_concepts

import scala.math.{ceil,sqrt}

object Euler {
  lazy private val zero = BigInt(0)
  lazy private val one  = BigInt(1)
  lazy private val two  = BigInt(2)

  // http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci/
  lazy val fibs : Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}
  lazy val fibsBig : Stream[BigInt] = zero #:: one #:: fibsBig.zip(fibsBig.tail).map {n => n._1 + n._2}

  def isPrime(n : Int) = {
    if (n == 1) false
    else if (n == 2) true
    else {
      var i = math.ceil(math.sqrt(n))
      while (i > 1) { if (n % i == 0) i = 0; else i -= 1 }
      if (i == 1) true; else false
    }
  }

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

  def gcd(u : Int, v : Int) : Int = if (v != 0) gcd(v, u % v); else u
  def gcdBig(u : BigInt, v : BigInt) : BigInt = if (v != 0) gcdBig(v, u % v); else u
}
