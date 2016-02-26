package com.daystrom_data_concepts


object p131 {
  val limit = 1000000

  val primes = BigInt(2) #:: Stream.iterate(BigInt(3))(_ + 2).filter(_.isProbablePrime(1000))

  val cubes = Stream.iterate(1)(_ + 1).map({ n => n*n*n }).sliding(2).toStream

  def isCube(n: BigInt) = {
    val root = math.round(math.pow(n.toInt, (1/3.0))).toInt
    (n == root*root*root)
  }

  def pred(p: BigInt) =
    cubes.takeWhile({ case Stream(a,b) => b - a <= p })
      .filter({ case Stream(a,b) => b - a == p }) // key idea: prime must be difference of consecutive cubes
      .flatten
      .map({ n => n + p })
      .filter({ m => isCube(m) })
      .nonEmpty

  val solution = primes.takeWhile(_ < limit).filter(pred).length

  def main(args: Array[String]) = println(solution)
}
