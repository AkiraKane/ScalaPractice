package com.daystrom_data_concepts

import scala.collection.mutable


object p118 {
  type ReturnType = Set[Set[BigInt]]

  def solutions(
    perm: String,
    memo: mutable.Map[String, ReturnType] = mutable.Map.empty[String, ReturnType]
  ): ReturnType = {
    val key = perm
    val cached = memo.get(perm)

    if (perm.length == 0) Set(Set.empty[BigInt])
    else if (cached.nonEmpty) cached.get
    else {
      val result = (1 to perm.length)
        .map({ width =>
          val number = BigInt(perm.take(width))
          val rest = perm.drop(width)
          (number, rest)
        })
        .filter({ pair => pair._1.isProbablePrime(1000) })
        .map({ pair =>
          solutions(perm = pair._2, memo = memo)
            .map({ set => set + pair._1 })
        })
        .foldLeft(Set.empty[Set[BigInt]])(_ union _)

      memo.put(perm, result)
      result
    }
  }

  val memo = mutable.Map.empty[String, ReturnType]

  val solution = "123456789".permutations
    .map({ perm => solutions(perm = perm, memo = memo) })
    .reduce(_ union _)
    .size

  def main(args: Array[String]) = println(solution)
}
