package answer

object Answer1 {
  def add(a: Int, b: Int) = a + b

  def main(args: Array[String]): Unit = {
    val a = 1
    val b = 1
    println("1 + 1 = " + add(a, b))

    val rmb: Int = 100000001
    val smallTarget = 100000000

    val ans = if (rmb >= smallTarget) {
      "小目标达成"
    } else {
      "小目标没有达成"
    }
    println(ans)

  }
}
