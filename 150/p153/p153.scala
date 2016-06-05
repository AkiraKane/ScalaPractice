package com.daystrom_data_concepts


object p153 {
  val limit = 100000000

  // def divisor(a: Int, b: Int) = {
  //   val sos = a*a + b*b
  //   val d1 = sos / (Euler.gcd(a, sos))  // $a$ supplies a factor of $\frac{a}{gcd(a,a^{2}+b^{2})}$
  //   val d2 = sos / (Euler.gcd(b, sos))  // $b$ supplies a factor of $\frac{b}{gcd(b,a^{2}+b^{2})}$
  //   val gcd = Euler.gcd(d1, d2)

  //   // If $n$ is divisible by $a + bi$, then $n$ must be divisible by
  //   // both $d_{1}$ and $d_{2}$; $n$ must be divisible by the number
  //   // returned below.
  //   (d1 / gcd) * (d2 / gcd) * gcd
  // }

  def tabulate(n: Int) = {
    var answer: BigInt = 0

    // Rational integer divisors.
    (1 to n).foreach({ i =>
      answer += ((n / i) * i)
    })

    // Gaussian integer divisors.  Let $a$ go from $1$ to $sqrt{n}$.
    // It is the fact that a and b are coprime that allows us to stop
    // at $sqrt{n}$ rather than $n$, which makes this feasible.
    var a = 1; while (a*a <= limit) {
      var b = 1; while (b <= a) {
        if (Euler.gcd(a,b) == 1) {
          val contribution =
            if (a == b) 2*a // a ± ai
            else 2*a + 2*b    // a ± bi and b ± ai
          val factor = a*a + b*b
            (1 to n / factor).foreach({ i =>
              answer += (n /(i * factor))*i*contribution
            })
        }
        b += 1
      }
      a += 1
    }
    answer
  }

  val answer = tabulate(limit)

  def main(args: Array[String]) = println(answer)
}
