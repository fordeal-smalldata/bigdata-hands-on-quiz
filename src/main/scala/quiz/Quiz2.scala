package quiz

import java.time.LocalDate

object Quiz2 {

  /**
   * 一段娱乐性较强的求素数代码,难以理解的话可以先跳过直接做下面的习题
   **/
  def isPrime(num: Int) = {
    num > 1 &&
      primeStream.takeWhile(prime => prime < num).forall(prime => num % prime != 0)
  }

  val primeStream: Stream[BigInt] = 2 #:: primeStream.map {
    lastPrime =>
      Iterator.iterate(lastPrime + 1)(x => x + 1)
        .filter {
          mayPrime =>
            primeStream.takeWhile(num => num < lastPrime).forall(num => mayPrime % num != 0) &&
              mayPrime % lastPrime != 0
        }.next()
  }

  def quiz2_1() = {
    println("100以内的素数有:")
    val prettyArr = 0.to(100).filter(isPrime).mkString(
      ???,
      ???,
      ???
    )
    println(prettyArr)
  }

  def quiz2_2() = {
    println("   2019年1季度日历")
    Seq(1, 2, 3).foreach {
      mon =>
        val monBegin = LocalDate.of(2019, mon, 1)
        val dayNumOfMon = monBegin.getMonth.length(monBegin.isLeapYear)
        val days = Iterator.iterate(monBegin)(_.plusDays(1)).take(???).toVector
        val spaceToFill = monBegin.getDayOfWeek.getValue % 7
        println(s"         ${mon}月")
        println(" 日 一 二 三 四 五 六")
        val dasToShow =
          Vector.fill(spaceToFill)(???) ++ days.map {
            date =>
              date.getDayOfMonth.formatted("%02d")
          }
        dasToShow.grouped(???).foreach {
          line =>
            println(line.mkString(???))
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
