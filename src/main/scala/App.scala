object App {
  def main(args: Array[String]): Unit = {
    type Duck = {def main(args: Array[String]): Unit}
    println(s"执行 ${args(0)}")
    println()
    import scala.reflect.runtime.universe
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(args(0))
    val obj = runtimeMirror.reflectModule(module)
    val duck = obj.instance.asInstanceOf[Duck]
    duck.main(args.tail)
  }
}
