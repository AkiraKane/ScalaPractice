package com.daystrom_data_concepts


object p150 {
  // val n = 1000

  // def generateTable() = {
  //   val size = 500500
  //   val table = Array.ofDim[Long](size)

  //   var t: Long = 0
  //   var k = 1; while (k <= size) {
  //     t = (615949L*t + 797807L) % (1L<<20)
  //     table(k-1) = t - (1L<<19)
  //     k += 1
  //   }
  //   table
  // }

  val n = 6

  def generateTable() = {
    val size = 21
    val table = List(15L, -14L, -7L, 20L, -13L, -5L, -3L, 8L, 23L, -26L, 1L, -4L, -5L, -18L, 5L, -16L, 31L, 2L, 9L, 28L, 3L).toArray
    table
  }

  val table = generateTable

  def readFromTable(col: Int, row: Int) = {
    val rowOffset = ((row * (row - 1)) / 2)
    val offset = rowOffset + col - 1
    table(offset)
  }

  /**
    * https://en.wikipedia.org/wiki/Maximum_subarray_problem
    */
  def kadane(seq: Seq[Long]): Long = {
    var min_ending_here: Long = 0
    var min_so_far: Long = 0
    seq.foreach({ x =>
      min_ending_here = math.min(0, min_ending_here + x)
      min_so_far = math.min(min_so_far, min_ending_here)
    })
    min_so_far
  }

  def score(col: Int) = {
    val rows = (n to col by -1)
    val diags = rows.map({ row =>
      (0 to (n-row)).map({ i => readFromTable(col + i, row + i) }).sum
    })
    kadane(diags.scanLeft(0L)(_ + _).drop(1))
  }

  // val solution = (1 to n).map(score) //.min
  val solution = score(3)

  def main(args: Array[String]) = println(solution)
}
