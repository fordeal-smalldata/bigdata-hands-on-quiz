package demo

import play.api.libs.json._

import scala.util.{Failure, Success, Try}

object DealWithJson {

  def someHeavyJob(): String = ???

  def merge_exception_demo() = {
    val map = Map("key_a" -> "val_a", "key_b" -> "val_b")
    val valC = map.getOrElse("key_c", "")
  }

  def wide_exception_demo() = try {
    //...... 大量可能抛出不同异常的代码
  } catch {
    case e: Exception =>
    // ..... 不分异常类型的简单处理
  }

  def try_to_int(js: JsValue): Either[Throwable, Int] = {
    Right(js).flatMap {
      case JsNumber(v) => Right(v.intValue())
      case JsString(str) => Try {
        str.toInt
      }.toEither
      case unexpected => Left(new Exception(s"unexpected value $unexpected"))
    }
  }

  def main(args: Array[String]): Unit = {
  }
}
