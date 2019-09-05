package answer

object Answer4 {
  def numToDaxie(num: Int) = {
    val cNums = "零壹贰叁肆伍陆柒捌玖"
    val eNums = "0123456789"
    val divs = Seq("", "万", "亿")
    val smallDivs = Seq("", "十", "百", "千")

    def deZero(str: String): String = {
      val res = str.replace("零零", "零")
      if (res.contains("零零")) deZero(res) else res
    }

    val e2c = eNums.zip(cNums).toMap
    val res = num.toString
      .reverse.grouped(4)
      .toSeq.zip(divs).reverse
      .map {
        case (reversedNum, div) =>
          val nums = reversedNum.zip(smallDivs).reverse
          val smallNum = nums.map {
            case (num, smallDiv) =>
              val c = e2c(num)
              if (c == '零') {
                if (smallDiv == "") ""
                else c.toString
              }
              else s"$c$smallDiv"
          }.mkString
          val dezeroed = deZero(smallNum)
          if (dezeroed == "零") "" else s"$dezeroed$div"
      }

    res.mkString
  }

  def main(args: Array[String]): Unit = {
    val numForTest = Seq(1, 1024, 50000, 50010, 500019, Int.MaxValue)
    numForTest.foreach {
      num =>
        val daxie = numToDaxie(num)
        println(s"$num 的中文大写形式为 $daxie")
    }
  }
}
