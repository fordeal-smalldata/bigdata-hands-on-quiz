package demo

object ScalaCallJava {
  def main(args: Array[String]): Unit = {
    val jClass = new AJavaClass
    jClass.aJavaMethod()
    //输出 这是一个Java方法

    import scala.collection.JavaConverters._
    val list = jClass.getJavaList.asScala
    println("转换成Scala的标准库: " + list) // 输出 转换成Scala的标准库: Buffer(1, 0, 2, 4)
    jClass.printList(list.asJava)
    //输出 数组中包含元素:
    //1
    //0
    //2
    //4
  }
}
