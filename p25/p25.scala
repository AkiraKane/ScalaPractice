package com.daystrom_data_concepts

object p25 {
  val indexedFibs = Euler.fibsBig.zip(Stream.from(0))

  def main(args: Array[String]) = {
    println(indexedFibs.filter({ _._1.toString.length == 1000 }).head._2)
  }
}
