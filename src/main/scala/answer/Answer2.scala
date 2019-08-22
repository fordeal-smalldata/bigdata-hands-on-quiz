package answer

import java.time.LocalDate

import quiz.Quiz2

object Answer2 {

  def quiz2_1() = {
    println("100以内的素数有:")
    val prettyArr = 0.to(100).filter(Quiz2.isPrime).mkString(
      "[",
      ",",
      "]"
    )
    println(prettyArr)
  }

  def quiz2_2() = {
    println("   2019年1季度日历")
    Seq(1, 2, 3).foreach {
      mon =>
        val monBegin = LocalDate.of(2019, mon, 1)
        val dayNumOfMon = monBegin.getMonth.length(monBegin.isLeapYear)
        val days = Iterator.iterate(monBegin)(_.plusDays(1)).take(dayNumOfMon).toVector
        val spaceToFill = monBegin.getDayOfWeek.getValue % 7
        println(s"         ${mon}月")
        println(" 日 一 二 三 四 五 六")
        val dasToShow =
          Vector.fill(spaceToFill)("  ") ++ days.map {
            date =>
              date.getDayOfMonth.formatted("%02d")
          }
        dasToShow.grouped(7).foreach {
          line =>
            println(line.mkString(" "))
        }
        println()
    }
  }

  def main(args: Array[String]): Unit = {
    quiz2_1()
    println()
    quiz2_2()
  }
}
