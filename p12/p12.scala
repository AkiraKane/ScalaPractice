package com.daystrom_data_concepts

import com.daystrom_data_concepts._

object p12 {

  import scalaz._
  import Scalaz._

  def findFactor(n: BigInt) : Option[BigInt] = {
    val factors = Euler.primesBig.filter(f => n % f == 0)
    val factor = factors(0)
    if (factor != n) Some(factor); else None
  }

  /* https://softwarecorner.wordpress.com/2013/08/29/scalaz-state-monad/ */
  def factorize(n: BigInt) : State[Map[BigInt, Int], Unit] = modify { s : Map[BigInt, Int] => {
      findFactor(n) match {
        case Some(prime) => {(
          for(
              _ <- factorize(n / prime);
              _ <- modify({ s2 : Map[BigInt, Int] => s2 + (prime -> (s2.getOrElse(prime, 0) + 1)) })
            ) yield ()).run(s)._1
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
    val xs = Euler.triangularBig.drop(1).filter(n => score(n) > 500)
    println(xs(0))
  }
}
