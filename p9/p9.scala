object p9 {
  import scala.math

  val abc = for(
    a <- List.range(1,1001);
    b <- List.range(1,1001)) yield (a,b, math.sqrt(a*a + b*b))
  val abc1000 = abc
    .filter(triple => triple._1 + triple._2 + triple._3 == 1000)

  def main(args: Array[String]) = {
    val triangle = abc1000(0)
    println(triangle._1 * triangle._2 * triangle._3.toInt)
  }
}
