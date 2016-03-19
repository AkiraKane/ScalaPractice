package com.daystrom_data_concepts


object p149 {
  val n = 2000

  def generateTable() = {
    val table = Array.ofDim[Long](n, n)

    @inline def translate(i : Long) = (((i - 1) % n).toInt, ((i - 1) / n).toInt)

    var k: Long = 1; while (k <= 55) {
      val (x,y) = translate(k.toInt)
      table(x)(y) = ((100003L - 200003L*k + 300007L*k*k*k) % 1000000L) - 500000L
      k += 1
    }
    k = 56; while (k <= n*n) {
      val (x,y) = translate(k)
      val (x1,y1) = translate(k - 24)
      val (x2,y2) = translate(k - 55)
      table(x)(y) = ((table(x1)(y1) + table(x2)(y2) + 1000000L) % 1000000L) - 500000L
      k += 1
    }
    table
  }

  val table = generateTable

  def horizontal(y: Int) =
    for (x <- 0 until n) yield table(x)(y)

  def vertical(x: Int) =
    for (y <- 0 until n) yield table(x)(y)

  def diagonal(x: Int, y: Int) = {
    val limit = math.min(n - x, n - y)
    for (i <- 0 until limit) yield table(x + i)(y + i)
  }

  def otherDiagonal(x: Int, y: Int) = {
    val limit = math.min(n - x, y + 1)
    for (i <- 0 until limit) yield table(x + i)(y - i)
  }

  /**
    * https://en.wikipedia.org/wiki/Maximum_subarray_problem
    *
    * def max_subarray(A):
    *  max_ending_here = max_so_far = 0
    *  for x in A:
    *     max_ending_here = max(0, max_ending_here + x)
    *     max_so_far = max(max_so_far, max_ending_here)
    * return max_so_far
    */
  def kadane(seq: Seq[Long]): Long = {
    var max_ending_here: Long = 0
    var max_so_far: Long = 0
    seq.foreach({ x =>
      max_ending_here = math.max(0, max_ending_here + x)
      max_so_far = math.max(max_so_far, max_ending_here)
    })
    max_so_far
  }

  val solution = {
    var result: Long = 0
    var i = 0; while (i < n) {
      val local = List(
        kadane(horizontal(i)),
        kadane(vertical(i)),
        kadane(diagonal(0, i)),
        kadane(diagonal(i, 0)),
        kadane(otherDiagonal(0, i)),
        kadane(otherDiagonal(i, n-1))
      ).max
      result = math.max(result, local)
      i += 1
    }
    result
  }

  def main(args: Array[String]) = println(solution)
}
