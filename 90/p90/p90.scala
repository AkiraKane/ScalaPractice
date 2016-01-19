package com.daystrom_data_concepts

object p90 {
  val squares = List(
    List(List(0, 1)),
    List(List(0, 4)),
    List(List(0, 9), List(0, 6)),
    List(List(1, 6), List(1, 9)),
    List(List(2, 5)),
    List(List(3, 6), List(3, 9)),
    List(List(4, 9), List(4, 6)),
    List(List(6, 4), List(9, 4)),
    List(List(8, 1))
  )

  def predicate(cubes: List[Set[Int]]) = {
    cubes match {
      case List(cube1, cube2) =>
        squares.forall({ square =>
          square.exists({ perm =>
            val List(first, second) = perm
            (cube1.contains(first) && cube2.contains(second)) ||
            (cube1.contains(second) && cube2.contains(first))
          })
        })
    }
  }

  val arrangements = List.range(0,10).combinations(6).toStream.combinations(2)

  val solution = arrangements
    .map({ arr => List(arr.head.toSet, arr.last.toSet) })
    .filter(predicate)
    .length

  def main(args: Array[String]) = println(solution)
}
