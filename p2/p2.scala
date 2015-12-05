object p2 {
  // http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci/
  lazy val fibs : Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}

  def main(args: Array[String]) = {
    val list = fibs
      .filter(n => n % 2 == 0)
      .takeWhile(n => n <= 4000000)
    println(list.sum)
  }
}
