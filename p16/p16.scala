object p16 {

  def main(args: Array[String]) = {
    var number = BigInt(1)
    var i = 0

    while (i < 1000) {
      number *= 2
      i += 1
    }

    val result = number.toString.map({ _ - '0' }).sum

    println(result)
  }
}
