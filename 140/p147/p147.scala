package com.daystrom_data_concepts


object p147 {

  // Well-known formulae
  def aligned(n: Int, m: Int) = m*(m+1)*n*(n+1)/4
  def diagonal(n: Int, m: Int) = n*((2*m-n)*(4*n*n-1) - 3)/6

  val solution = {
    var result: BigInt = 0

    var x = 1; while (x <= 47) {
      var y = 1; while (y <= 43) {
        result += aligned(x,y)
        result += diagonal(math.min(x,y), math.max(x,y))
        y += 1
      }
      x += 1
    }
    result
  }

  def main(args: Array[String]) = println(solution)
}
