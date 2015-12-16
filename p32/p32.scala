package com.daystrom_data_concepts

object p32 {

  import scala.collection.mutable

  val memo = mutable.Set[Int]()

  def panDigital(i : Int, j : Int, k : Int) = {
    val str = (i.toString + j.toString + k.toString).sorted
    (str == "123456789")
  }

  def main(args: Array[String]) = {
    var i = 0
    var j = 0

    while (i < 10000) {
      j = 0
      while (j < 10000) {
        val k = i * j
        if (panDigital(i, j, k)) memo += k
        j += 1
      }
      i += 1
    }

    println(memo.sum)
  }
}
