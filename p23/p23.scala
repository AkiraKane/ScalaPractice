object p23 {

  def d(n : Int) : Int = List.range(1,n).filter({ n % _ == 0 }).sum

  def abundant(n : Int) : Boolean = d(n) > n

  val limit = 28123

  val abundants = List.range(1, limit).filter(abundant)

  val sumsOfAbundants = abundants.flatMap({ a =>
    abundants
      .takeWhile({ b => ((b <= a) && ( a + b <= limit ))})
      .map({ b => a + b })
  }).toSet

  val notSumsOfAbundants = List.range(1, limit+1).filter({ !sumsOfAbundants.contains(_) })

  def main(args: Array[String]) = {
    println(notSumsOfAbundants.sum)
  }
}
