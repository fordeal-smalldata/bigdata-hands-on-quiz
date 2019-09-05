package quiz

object Quiz3 {
  def newtonSqrt(num: Double, accuracy: Double = 0.00001) = ???

  def main(args: Array[String]): Unit = {
    val accuracy = 0.00001
    val numsforTest = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(s"牛顿迭代法求平方根,精度为 $accuracy")
    for (num <- numsforTest) {
      val res = newtonSqrt(num, accuracy)
      println(s"$num 的平方根是 $res")
    }
  }
}
