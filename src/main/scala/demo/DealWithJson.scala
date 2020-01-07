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

  def try_to_int(js: JsValue): Try[Int] = {
    Success(js).flatMap {
      case JsNumber(v) => Success(v.intValue())
      case JsString(str) => Try {
        str.toInt
      }
      case unexpected => Failure(new Exception(s"unexpected content $unexpected"))
    }
  }

  def head_by_space(str: Option[String]): Option[String] = {
    str.flatMap(_.split(" ").headOption)
  }

  def head_by_space_str(str: Option[String]): String = {
    str.flatMap(_.split(" ").headOption).getOrElse("")
  }

  def most_detailed_json_lookup() = {
    val json: JsValue = ???
    json \ "key" match { //匹配一个JsLookupResult
      //有这个键,列出所有可能的情况
      case JsDefined(value) => value match {
        case JsNull => ???
        case boolean: JsBoolean => ???
        case JsNumber(value) => ???
        case JsString(value) => ???
        case JsArray(value) => ???
        case JsObject(underlying) => ???
      }
      case undefined: JsUndefined =>
        //处理没有这个键的情况,下方的处理情况是抛出了一个异常说明应该有这个键却没有
        throw new Exception(s"error occurred when try to get key from $json : ${undefined.validationError}")

    }
  }

  def simplified_json_lookup() = {
    val json: JsValue = ???
    val expectedInt = (json \ "key").as[Int]
  }

  def simplified_json_lookup2() = {
    val json: JsValue = ???
    val expectedInt = (json \ "key").asOpt[Int]
  }

  def simplified_json_lookup3() = {
    val json: JsValue = ???
    val expectedInt = (json \ "key").asOpt[JsValue].map {
      case JsNumber(num) => num.toInt
      case JsString(str) => str.toInt
      case unexpected => throw new Exception(unexpected.toString())
    }
  }

  def try_head_by_space_(str: String): Try[String] = Try {
    str.split(" ")(1)
  }

  def try_to_int(str: String): Try[Int] = Try {
    str.toInt
  }

  def keep_even_number(num: Int): Option[Int] = Option(num).filter(_ % 2 == 0)

  def main(args: Array[String]): Unit = {
    val num =
      for (head <- try_head_by_space_("aaa 233").toEither;
           num <- try_to_int(head).toEither;
           even <- keep_even_number(num).toRight(new Exception(s"$num is not even")))
        yield even

    num match {
      case Right(res) => println(s"success fully get number $res")
      case Left(e) => println(e)
      // java.lang.Exception: 233 is not even
    }
  }
}
