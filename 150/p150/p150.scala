package com.daystrom_data_concepts


object p150 {
  val n = 1000

  def generateTable() = {
    val size = 500500
    val table = Array.ofDim[Long](size)

    var t: Long = 0
    var k = 1; while (k <= size) {
      t = (615949L*t + 797807L) % (1L<<20)
      table(k-1) = t - (1L<<19)
      k += 1
    }
    table
  }

  val table = generateTable

  def getRow(row: Int) = {
    val offset = ((row * (row - 1)) / 2)
    table.drop(offset).take(row)
  }


  // https://github.com/nayuki/Project-Euler-solutions/blob/master/python/p150.py
  val rowSums = (1 to n).map({ row => getRow(row).scanLeft(0L)(_ + _).toArray }).toArray
  val solution = {
    var result = 0L
    var i = 0; while (i < n) {
      var j = 0; while (j <= i) {
        var currentSum = 0L
        var k = i; while (k < n) {
          currentSum += rowSums(k)(k - i + 1 + j) - rowSums(k)(j)
          result = math.min(currentSum, result)
          k += 1
        }
        j += 1
      }
      i += 1
    }
    result
  }

  def main(args: Array[String]) = println(solution)
}
