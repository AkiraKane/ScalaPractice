package com.daystrom_data_concepts

object p68 {

  def valueOf(a: Int, b:Int, c:Int) = a+b+c

  def predicate(list: List[Int]) : Boolean = {
    list match {
      case List(a,b,c,d,e,f,g,h,i,j) =>
        lazy val agh = valueOf(a,g,h)
        lazy val bhi = valueOf(b,h,i)
        lazy val cij = valueOf(c,i,j)
        lazy val djf = valueOf(d,j,f)
        lazy val efg = valueOf(e,f,g)

        if (!((a<b) && (a<c) && (a<d) && (a<e))) false
        else if (!((agh == bhi && bhi == cij && cij == djf && djf == efg))) false
        else if (!((b == 10 || c == 10 || d == 10 || e == 10))) false
        else true
    }
  }

  def permToNumber(list: List[Int]) = {
    list.map(_.toString) match {
      case List(a,b,c,d,e,f,g,h,i,j) =>
        BigInt(a ++ g ++ h ++ b ++ h ++ i ++ c ++ i ++ j ++ d ++ j ++ f ++ e ++ f ++ g)
    }
  }

  val solution = List.range(1,11).permutations
    .filter(predicate)
    .map(permToNumber)
    .reduce({ (a,b) => if (a > b) a; else b })

  def main(args: Array[String]) = {
    println(solution)
  }
}
