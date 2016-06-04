package com.daystrom_data_concepts


object p153 {
  val limit = 5

  def divisor(a: Int, b: Int) = {
    val sos = a*a + b*b
    val d1 = sos / (Euler.gcd(a, sos))  // $a$ supplies a factor of $\frac{a}{gcd(a,a^{2}+b^{2})}$
    val d2 = sos / (Euler.gcd(b, sos))  // $b$ supplies a factor of $\frac{b}{gcd(b,a^{2}+b^{2})}$
    val gcd = Euler.gcd(d1, d2)

    // If $n$ is divisible by $a + bi$, then $n$ must be divisible by
    // both $d_{1}$ and $d_{2}$; $n$ must be divisible by the number
    // returned below.
    (d1 / gcd) * (d2 / gcd) * gcd
  }

  val answer = {
    var total = 0

    var a = 1; while (a <= limit) {
      var b = 0; while (b <= limit) {
          (a, b, divisor(a,b)) match {
            case (a, 0, d) =>
              val score = a * (limit/d)
              println(s"a=$a score=$score")
              total += score
            case (a, b, d) =>
              val score = 2 * a * (limit/d)
              println(s"$a±${b}i score=$score")
              total += score
        }
        b += 1;
      }
      a += 1;
    }

    total
  }

  def main(args: Array[String]) = println(answer)
}
