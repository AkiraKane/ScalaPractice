package com.daystrom_data_concepts

object p62 {
  lazy val cubes = Euler.natural.map({ n =>
    val bigN = BigInt(n)
    val cube = bigN * bigN * bigN
    cube.toString
  })

  def sameLength(n : String, m : String) = (n.length == m.length)

  def sameDigits(n : String, m : String) = (n.sorted == m.sorted)

  val size = 5

  def pred(n : String) = {
    val perms = cubes
      .dropWhile({ m => !sameLength(n,m) })
      .takeWhile({ m => sameLength(n,m) })
      .filter({ m => sameDigits(n,m) })
      .length
    (perms == size)
  }

  lazy val solution = cubes.filter(pred).head

  def main(args: Array[String]) = {
    println(solution)
  }

}
