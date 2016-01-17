package com.daystrom_data_concepts

object p5 {

  def removeFactors(n : Int, list : Stream[Int]) : Int = {
    list match {
      case (x #:: xs) => {
        if (n % x == 0) removeFactors(n/x, list.tail)
        else removeFactors(n, list.tail)
      }
      case _ => n
    }
  }

  val numbers : Stream[(Int, Int)] = (1,1) #:: numbers.map { pair =>
    val previousIndex = pair._1
    val currentIndex = previousIndex + 1
    val priorReduced = numbers.take(previousIndex).map(pair2 => pair2._2)
    val reduced = removeFactors(currentIndex, priorReduced)
    (currentIndex, reduced)
  }

  def main(args: Array[String]) = {
    println(numbers.take(20).map(pair => pair._2).product)
  }
}
