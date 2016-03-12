package com.daystrom_data_concepts

import Euler.{gcd, natural, naturalBig}
import math.{ceil, sqrt}


object p143 {
  val limit = 120000

  val squares = naturalBig.takeWhile(_ <= limit).map({ i => i*i }).toSet

  // http://www.geocities.ws/fredlb37/node9.html
  val primitiveTriples = natural
    .takeWhile(_ < ceil(sqrt(limit)))
    .flatMap({ m =>
      natural
        .takeWhile(_ < m)
        .filter({ n => (m-n) % 3 != 0 && gcd(m,n) == 1})
        .map({ n => ((m*m - n*n), (2*m*n + n*n), (m*m + n*n + m*n)) })
    })
    .filter({ case (p,r,_) => p+r <= limit })

  val triples = primitiveTriples
    .flatMap({ case (p,r,c) =>
      natural
        .map({ k => (k*p, k*r, k*c) })
        .takeWhile({ case (p,r,c) => p+r <= limit })
    })

  val solution = (triples ++ triples.map({ case (p,r,c) => (r,p,c) }))
    .groupBy({ case (p,r,c) => p }).values
    .flatMap({ list =>
      list.combinations(2)
        .flatMap({ case Stream((p, r, c), (_, q, b)) =>
          val a2 = BigInt(q)*q + BigInt(r)*r + BigInt(q)*r

          if (p + q + r <= limit && squares.contains(a2)) Some(p + q + r)
          else None
        })
    })
    .toSet.sum

  def main(args: Array[String]) = println(solution)
}
