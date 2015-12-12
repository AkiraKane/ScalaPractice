object p21 {

  def d(n : Int) : Int = List.range(1,n).filter({ n % _ == 0 }).sum

  def amicable(n : Int) : Boolean = {
    val a = d(n)
    val b = d(a)
    if (a != b) b == n; else false
  }

  val limit = 10000

  def main(args: Array[String]) = {
    println(List.range(1,limit).filter(amicable).sum)
  }
}
