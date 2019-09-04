package demo

object ScalaCallJava {
  def main(args: Array[String]): Unit = {
    (new AJavaClass).aJavaMethod()
    //输出 这是一个Java方法
  }
}
