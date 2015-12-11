object p19 {

  def advance(today : (Int, Int, Int, Int)) : (Int, Int, Int, Int) = {
    val (year, month, day, weekDay) = today
    val nextWeekDay = (weekDay + 1) % 7
    val endOfMonth = month match {
      case 9 => 30
      case 4 => 30
      case 6 => 30
      case 11 => 30
      case 2 => if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 29; else 28
      case _ => 31
    }

    if (day + 1 > endOfMonth) {
      if (month == 12) (year + 1, 1, 1, nextWeekDay)
      else (year, month + 1, 1, nextWeekDay)
    } else {
      (year, month, day + 1, nextWeekDay)
    }
  }

  def date(today : (Int, Int, Int, Int)) : (Int, Int, Int) = (today._1, today._2, today._3)

  def main(args: Array[String]) = {
    var current = (1900, 1, 1, 1)
    var sundays = 0

    while (date(current) != (1901, 1, 1)) current = advance(current)

    while (date(current) != (2001, 1, 1)) {
      if ((current._4 == 0) && (current._3 == 1)) sundays += 1
      current = advance(current)
    }

    println(s"Current: ${current}")
    println(s"Sundays: ${sundays}")
  }
}
