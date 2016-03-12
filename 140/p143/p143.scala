package com.daystrom_data_concepts

import Euler.{gcd, natural}
import math.{ceil, round, sqrt}


object p143 {
  val limit = 120000

  // http://www.geocities.ws/fredlb37/node9.html
  val primitiveTriples = natural
    .takeWhile(_ <= ceil(sqrt(limit)))
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
      (list ++ list).combinations(2)
        .flatMap({ case Stream((p, r, c), (_, q, b)) =>
          val a2 = q*q + r*r + q*r

          if (p + q + r < limit) {
            lazy val a = round(sqrt(a2)).toInt
            lazy val angle1 = (a*a + b*b - c*c)/(2.0*a*b)
            lazy val angle2 = (a*a + c*c - b*b)/(2.0*a*c)
            lazy val angle3 = (c*c + b*b - a*a)/(2.0*c*b)

            if (a*a == a2 && angle1 > -0.5 && angle2 > -0.5 && angle3 > -0.5)
              Some(p + q + r)
            else
              None
          }
          else
            None
        })
    })
    .toList.distinct.sum

  def main(args: Array[String]) = println(solution)
}
