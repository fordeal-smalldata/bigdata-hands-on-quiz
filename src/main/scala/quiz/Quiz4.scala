package quiz

object Quiz4 {
  def numToDaxie(num: Int): String = ???

  def main(args: Array[String]): Unit = {
    val numForTest = Seq(1, 1024, 50000, 50010, 500019, Int.MaxValue)
    numForTest.foreach {
      num =>
        val daxie = numToDaxie(num)
        println(s"$num 的中文大写形式为 $daxie")
    }
  }
}
