object p15 {
  type StateMap = Map[(Int, Int), BigInt]

  val zero = BigInt(0)
  val one = BigInt(1)

  def f(n : Int, m : Int, state : StateMap) : StateMap = {
    state.get((n, m)) match {
      case Some(_) => state
      case None => {
        if ((n < 1) || (m < 1)) state + ((n, m) -> one)
        else {
          val statePrime = f(n, m-1, f(n-1, m, state))
          val x1 = statePrime.getOrElse((n-1, m), zero)
          val x2 = statePrime.getOrElse((n, m-1), zero)
          statePrime + ((n, m) -> (x1 + x2))
        }
      }
    }
  }

  def main(args: Array[String]) = {
    val state = f(20,20, Map.empty)
    println(state.get((20,20)))
  }
}
