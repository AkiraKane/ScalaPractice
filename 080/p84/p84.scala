package com.daystrom_data_concepts

import scala.util.Random

object p84 {
  val r = new Random()
  val sides = 4

  def roll() = r.nextInt(sides) + 1

  def card() = r.nextInt(16) + 1

  def nextR(loc: Int): Int = {
    loc match {
      case 7 => 15
      case 22 => 25
      case 36 => 5
      case _ => throw new Exception
    }
  }

  def nextU(loc: Int): Int = {
    loc match {
      case 7 => 12
      case 22 => 28
      case 36 => 12
      case _ => throw new Exception
    }
  }

  def chest(loc: Int, dbls: Int): (Int, Int) = {
    card match {
      case 1 => (0, dbls)
      case 2 => (10, dbls)
      case _ => (loc, dbls)
    }
  }

  def chance(loc: Int, dbls: Int): (Int, Int) = {
    card match {
      case 1 => (0, dbls)
      case 2 => (10, dbls)
      case 3 => (11, dbls)
      case 4 => (24, dbls)
      case 5 => (39, dbls)
      case 6 => (5, dbls)
      case 7 => (nextR(loc), dbls)
      case 8 => (nextR(loc), dbls)
      case 9 => (nextU(loc), dbls)
      case 10 => (loc - 3, dbls)
      case _ => (loc, dbls)
    }
  }

  def turn(loc: Int, dbls: Int): (Int, Int) = {
    val one = roll
    val two = roll
    val locNext = (loc + one + two) % 40
    val dblsNext = if (one == two) dbls + 1; else 0

    locNext match {
      case 30 => (10, dblsNext)
      case 2 => chest(2, dblsNext)
      case 17 => chest(17, dblsNext)
      case 33 => chest(33, dblsNext)
      case 7 => chance(7, dblsNext)
      case 22 => chance(22, dblsNext)
      case 36 => chance(36, dblsNext)
      case i => {
        if (dblsNext >= 3) (10, 0)
        else (i, dblsNext)
      }
    }
  }

  val solution = Stream.iterate((0, 0))({ data => turn(data._1, data._2) })
    .take(1000000)
    .map(_._1)
    .groupBy(identity)
    .mapValues(_.length).toList
    .filter({ case (k,v) => Set(2,17,33,7,22,26).contains(k) == false })
    .sortWith(_._2 > _._2)
    .take(3)

  def main(args: Array[String]) = println(solution)
}
