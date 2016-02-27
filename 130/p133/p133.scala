package com.daystrom_data_concepts

import Euler.{ gcd, primes, primeFactors }


object p133 {
  val limit = 100000

  // The length of a cycle in the sequence R(i) mod p
  def cycle(p: Int) = {
    var i = 1
    var rem = 1

    if ((p % 2) == 0 || (p % 5) == 0) throw new Exception
    else {
      while (rem % p != 0) {
        rem = (rem * 10 + 1) % p
        i += 1
      }
      i
    }
  }

  // Does the sequence R(10^{i}) mod p include 0?
  def sometimes(p: Int) =
    primeFactors(cycle(p)).forall({ case (p,k) => p == 2 || p == 5})

  // Does the sequence R(10^{i}) mod p not include 0?
  def never(p: Int) = !sometimes(p)

  val solution =
    (2 #:: 5 #:: // Re-introduce 2 and 5 since they must be part of the sum
      (3 #:: primes.drop(3)) // Exclude 2 and 5 since they cause problems for the `cycle` function
      .takeWhile(_ < limit)
      .filter(never)
    ).sum

  def main(args: Array[String]) = println(solution)
}
