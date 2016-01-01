package com.daystrom_data_concepts

object p59 {
  import scala.io.Source

  val data = Source.fromFile("p59/p059_cipher.txt")
    .mkString.split(",")
    .map(_.trim.toInt)

  val groupedData = data.grouped(3).filter(_.length == 3).toStream

  def search() = {
    var key1 = 'a'.toInt
    while (key1 <= 'z'.toInt) {
      var key2 = 'a'.toInt
      while (key2 <= 'z'.toInt) {
        var key3 = 'a'.toInt
        while (key3 <= 'z'.toInt) {
          val key = List(key1, key2, key3).map(_.toChar)
          val text = groupedData
            .map(_.zip(key)
              .map({case (l,k) => (l ^ k).toChar})
              .toList)
            .reduce({ (x,y) => x ++ y })
            .mkString

          println(key)
          println(text)

          key3 += 1
        }
        key2 += 1
      }
      key1 += 1
    }
  }

  def main(args: Array[String]) = {
    val key = List('g','o','d')
    var i = 0
    var sum = 0
    while (i < data.length) {
      sum += data(i) ^ key(i % 3).toInt
      i += 1
    }
    println(sum)
  }

}
