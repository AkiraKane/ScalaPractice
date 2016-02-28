package com.daystrom_data_concepts

object p54 {
  import scala.io.Source

  val rankMultiplier  = BigInt("1000000000000000")
  val cardMultiplier  = BigInt("1000000000000")

  def score(hand : (Seq[Int], Seq[Char])) = {
    val (cards, suits) = hand
    val cardsSorted = cards.sorted
    val kinds = cards.groupBy(identity)
    val kindsList = kinds.map(_._2.length).toList
    val minorScore = cardsSorted.zip(List(1, 15, 15*15, 15*15*15, 15*15*15*15)).map({ pair => pair._1 * pair._2 }).sum
    val majorScore : BigInt =
      if ((cards.toSet == Set(10, 11, 12, 13, 14)) && (suits.toSet.size == 1)) { // Royal Flush
        10*rankMultiplier
      }
      else if ((cardsSorted.last - cardsSorted.head == 4) && (cards.toSet.size == 5) && (suits.toSet.size == 1)) { // Straight Flush
        9*rankMultiplier +
        cardMultiplier*cardsSorted.last
      }
      else if (kindsList.contains(4)) { // Four of a Kind
        8*rankMultiplier +
        cardMultiplier*kinds.filter(_._2.length == 4).head._1
      }
      else if (kindsList.contains(3) && kindsList.contains(2)) { // Full House
        7*rankMultiplier +
        cardMultiplier*kinds.filter(_._2.length == 3).head._1
      }
      else if (suits.toSet.size == 1) { // Flush
        6*rankMultiplier +
        cardMultiplier*cardsSorted.last
      }
      else if ((cardsSorted.last - cardsSorted.head == 4) && (cards.toSet.size == 5)) { // Straight
        5*rankMultiplier +
        cardMultiplier*cardsSorted.last
      }
      else if (kindsList.contains(3)) {  // Three of a Kind
        4*rankMultiplier +
        cardMultiplier*kinds.filter(_._2.length == 3).head._1
      }
      else if (kindsList.filter(_ == 2).length == 2) { // Two Pairs
        val pairs = kinds.filter(_._2.length == 2).map(_._1).toList.sorted
        3*rankMultiplier +
        cardMultiplier*pairs.last
      }
      else if (kindsList.filter(_ == 2).length == 1) { // One Pairs
        2*rankMultiplier +
        cardMultiplier*kinds.filter(_._2.length == 2).head._1
      }
      else 0

    majorScore + minorScore
  }

  def digest(hand : Seq[String]) = {
    val cards = hand.map(_.head).map({ card =>
      card match {
        case 'T' => 10
        case 'J' => 11
        case 'Q' => 12
        case 'K' => 13
        case 'A' => 14
        case other => other - '0'
      }})
    val suits = hand.map(_.last)
    (cards, suits)
  }

  def playerOneWins(line : String) = {
    val List(one, two) = line.grouped(3).map(_.trim).grouped(5).toList
    score(digest(one)) > score(digest(two))
  }

  lazy val solution = Source.fromFile("50/p54/p054_poker.txt").getLines
    .filter(playerOneWins(_))
    .length

  def main(args: Array[String]) = {
    println(solution)
  }
}
