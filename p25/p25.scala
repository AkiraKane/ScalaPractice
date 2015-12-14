package com.daystrom_data_concepts

object p25 {
  val zero = BigInt(0)
  val one = BigInt(1)

  val fibs : Stream[BigInt] = zero #:: one #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}
  val indexedFibs = fibs.zip(Stream.from(0))

  def main(args: Array[String]) = {
    println(indexedFibs.filter({ _._1.toString.length == 1000 }).head._2)
  }
}
