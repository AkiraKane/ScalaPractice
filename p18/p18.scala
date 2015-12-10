object p18 {

  val data = Vector(
    Vector(75),
    Vector(95, 64),
    Vector(17, 47, 82),
    Vector(18, 35, 87, 10),
    Vector(20, 4, 82, 47, 65),
    Vector(19, 1, 23, 75, 3, 34),
    Vector(88, 2, 77, 73, 7, 63, 67),
    Vector(99, 65, 4, 28, 6, 16, 70, 92),
    Vector(41, 41, 26, 56, 83, 40, 80, 70, 33),
    Vector(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
    Vector(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
    Vector(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
    Vector(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
    Vector(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
    Vector(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23))

  def f(n : Int, m : Int, memo: Map[(Int, Int), Int]) : Map[(Int, Int), Int] = {
    if (n == 14) memo + ((n, m) -> data(n)(m))
    else {
      val here = data(n)(m)
      val memoPrime = f(n + 1, m + 1, f(n + 1, m + 0, memo))
      val left  = memoPrime.get(n + 1, m + 0).get
      val right = memoPrime.get(n + 1, m + 1).get
      memo + ((n, m) -> (here + math.max(left, right)))
    }
  }

  def f(n : Int, m : Int) : Option[Int] = f(n, m, Map.empty).get((n, m))

  def main(args: Array[String]) = {
    println(f(0,0))
  }
}
