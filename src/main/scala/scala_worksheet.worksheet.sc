import utils.JsonBuilder
val answer = 2;
println(s"The answer is ${answer}.")
val x = 1
x
1.to(10).map(_ * 2).foreach(println)
import org.json4s._
import org.json4s.jackson.JsonMethods._
// create a dummy JSON object
val json = parse("""{"id": 1, "name": "object_1", "value": 1.23, "is_active": true}""")
pretty(render(json))
val numObjects = 3
// create a dummy JSON object
    val jsonObjects = (1 to numObjects).map { i =>
      JObject(
        "id" -> JInt(i),
        "name" -> JString(s"object_$i"),
        "value" -> JDouble(1.23 * i),
        "is_active" -> JBool(i % 2 == 0)
      )
    }
    val jsonString = jsonObjects.map(x => pretty(render(x))).mkString("\n")
    println(jsonString)
import scala.util.Random
def generateRoutingNumber: String = {
  val random = new Random()
  val prefix = f"${random.nextInt(1000)}%03d"
  val suffix = f"${random.nextInt(100)}%02d"
  val checksum = (7 * prefix.charAt(0).asDigit + 3 * prefix.charAt(1).asDigit + prefix.charAt(2).asDigit +
    7 * suffix.charAt(0).asDigit + 3 * suffix.charAt(1).asDigit) % 10

  s"$prefix$checksum$suffix"
}
generateRoutingNumber
generateRoutingNumber
val random = new Random()
val xy = random.between(1, 13)
//XXXXYYYYC
val prefix = f"${List(random.between(1, 13), random.between(21, 33), random.between(61,73))(random.nextInt(3))}%02d"
val prefix_next = f"${random.between(0, 100)}%02d"
val xxxx = prefix + prefix_next
val yyyy = f"${random.between(0, 10001)}%04d"
val number = xxxx + yyyy

val checksum = (3 * number.charAt(0).asDigit + 7 * number.charAt(1).asDigit + number.charAt(2).asDigit +
  3 * number.charAt(3).asDigit + 7 * number.charAt(4).asDigit + number.charAt(5).asDigit +
  3 * number.charAt(6).asDigit + 7 * number.charAt(7).asDigit)
val rem = checksum % 10 
val diff = 10 - checksum % 10
val routing_number = number.toInt*10 + diff
s"$xxxx$yyyy$diff"
import com.mifmif.common.regex.Generex
//date regex
val dateRegex = new Generex("202[0-3][0-12]")
dateRegex.random()
val transactionKeyRegex = new Generex("202[0-3][0-1][0-2][0-3][0-1][0-9][0-5][0-9][0-5][0-9][0-5][0-9][0-9]{2}")
transactionKeyRegex.random()
// generate a random valid date in the format YYYYMMDD
def generateDate: String = {
  val random = new Random()
  val year = random.between(2020, 2024)
  val month = random.between(1, 13)
  val day = random.between(1, 29)
  f"$year%04d$month%02d$day%02d"
}
generateDate

// generate a random date-time in format "transactionLocalDateTime": "2022-05-27T12:00:00.000Z"
def generateDateTime: String = {
  val random = new Random()
  val year = random.between(2020, 2024)
  val month = random.between(1, 13)
  val day = random.between(1, 29)
  val hour = random.between(0, 24)
  val minute = random.between(0, 60)
  val second = random.between(0, 60)
  val millisecond = random.between(0, 1000)
  f"$year%04d-$month%02d-$day%02dT$hour%02d:$minute%02d:$second%02d.$millisecond%03dZ"
}
generateDateTime
case class BaseTransactionBType(
    accountKey: String = "",
    overrideTypeCd: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "accountKey" -> JString(accountKey),
      "overrideTypeCd" -> JString(overrideTypeCd)
    )
  }
}
val baseTransactionBType = BaseTransactionBType("123456789", "123456789")
baseTransactionBType.toJObj()
compact(render(baseTransactionBType.toJObj()))
val fields = BaseTransactionBType.getClass.getDeclaredFields
import org.json4s._
import org.json4s.native.Serialization.write
implicit val formats: Formats = DefaultFormats
Extraction.decompose(BaseTransactionBType("123456789", "123456789"))(DefaultFormats)
write(BaseTransactionBType("123456789", "123456789"))
import org.json4s._
import org.json4s.native.Serialization.write

trait Jsonable {
  def toJson(): JValue = Extraction.decompose(this)(DefaultFormats)
  def toJObj(): JObject = JObject(Extraction.decompose(this)(DefaultFormats).asInstanceOf[JObject].obj)

  def toJString(): String = write(this)(DefaultFormats)
}
None.map(x => x).getOrElse(JNothing)

import org.json4s.{DefaultFormats, JField, JObject, JString, JValue}
JField("accountKey", JString("123456789"))


BaseTransactionBType("123456789", "123456789").toJObj()

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._


val config = parse("""
  {
    "accountKey": true,
    "overrideTypeCd": false
  }
""")


// val json1 = parse("""
//   [
//     {
//       "accountKey": "123456789",
//       "overrideTypeCd": "123456789"
//     }
//   ]
// """)

// val filteredJson = json.transform {
//   case JArray(arr) => JArray(arr.map(obj => filterFields(obj, config)))
// }

// println(pretty(render(filteredJson)))


//jsonObjects2.map(x => filterFields(x, fieldsToKeep))

JObject(("age", JInt(10)) :: Nil) transformField {
  case ("age", JInt(x)) => ("age", JInt(x+1))
}
val json_A = parse("""
  {
    "title": "title",
    "amount": {
      "originalCurrencyCd": "USD",
      "originalAmount": 100.0,
      "normalizedOriginalAmount": 100.0,
      "regionNormalizedOriginalAmount": 100.0,
      "accountAmount": 0.0,
      "oppAccountAmount": 0.0
    },
    "accountKey": "123456789"
  }
""")
    //val fieldsToKeep = if args.nonEmpty && args.length == 2 then parse(scala.io.Source.fromFile(args(1).trim)("UTF-8").mkString) else parse(getClass.getResourceAsStream("/config.json"))
    //val fieldsToKeep = parse(if args.nonEmpty then parse(args(1)) else getClass.getResourceAsStream("/config.json"))
    
    //val jsonObjects3 = jsonObjects2.map(x => filterFields(x, fieldsToKeep))

val fields_to_keep = parse("""
  {
    "accountKey": true,
    "overrideTypeCd": false,
      "amount": {
      "originalCurrencyCd": false,
      "originalAmount": true,
      "normalizedOriginalAmount": true,
      "regionNormalizedOriginalAmount": true,
      "accountAmount": true,
      "oppAccountAmount": true
    }
  }
""")
// 
// write a function filterFields(json: JValue, fields_to_keep: JValue): JValue
// to filter fields recursively and accumulate the result in a new JObject
// if fieldName is not in configFields, then remove it
// add ability to work on json arrays




// test the function
val filter_fields = parse("""
  {
    "accountKey": true,
    "overrideTypeCd": false,
      "amount": {
      "originalCurrencyCd": false,
      "originalAmount": true,
      "normalizedOriginalAmount": true,
      "regionNormalizedOriginalAmount": true,
      "accountAmount": true,
      "oppAccountAmount": true
    },
    "c": [{
      "d": true,
      "e": false
    },
    {
      "d": true,
      "e": false}]
  }
""")
// create a json object that has all the fields
val json_obj = parse("""
  {
    "accountKey": "123456789",
    "overrideTypeCd": "123456789",
    "amount": {
      "originalCurrencyCd": "USD",
      "originalAmount": 100.0,
      "normalizedOriginalAmount": 100.0,
      "regionNormalizedOriginalAmount": 100.0,
      "accountAmount": 0.0,
      "oppAccountAmount": 0.0
    },
    "c": [{
      "d": "d",
      "e": "e"
    },
    {
      "d": "d",
      "e": "e"
    }]
  }
""")
def filterFields(json: JValue, fields_to_keep: JValue): JValue = {
  json match {
    case JObject(fields) => {
      val filtered_fields = fields.map {
        case (fieldName, fieldValue) => {
          (fields_to_keep \ fieldName) match {
            case JBool(true) => Some(fieldName -> fieldValue)
            case JObject(_) => Some(fieldName -> filterFields(fieldValue, fields_to_keep \ fieldName))
            case JArray(_) => {
              fieldValue match {
                case JArray(arr) => {
                  val filtered_arr = arr.zipWithIndex.map({
                                      //case (x, index) => Some(index.toString -> filterFields(x, fields_to_keep \ fieldName))
                                      case (x, index) => Some(index.toString -> filterFields(x, (fields_to_keep \ fieldName)(index)))
                                                      })
                  //Some(fieldName -> JArray(filtered_arr.flatten.map(x => x._2)))
                  Some(fieldName -> JArray(filtered_arr.flatten.map(x => x._2)))
                }
                case _ => None
                }
              }
            case _ => None
            }
          }
        }
        JObject(filtered_fields.flatten)
      }
      case _ => json
    }
}
compact(render(filterFields(json_obj, filter_fields)))


// filterFields(json_A, fields_to_keep)
// //filterFields(json_A, fields_to_keep) \ "amount"
// //filterFields(json_A, fields_to_keep) \ "amount" \ "originalCurrencyCd"
// //filterFields(json_A, fields_to_keep) \ "amount" \ "originalAmount"
// filterFields(json_A, fields_to_keep) \ "accountKey"
// filterFields(json_A, fields_to_keep) \ "overrideTypeCd"
// filterFields(json_A, fields_to_keep) \ "title"


// fields_to_keep \ "amount"
// json_A \ "amount"
// JObject(("age", JInt(10)) :: Nil) transformField {
//   case ("age", JInt(x)) => ("age", JInt(x+1))
// }
// // check if JValue has a field or not


// json_A \ "amounta"
// compact(render(filterFields(json_A, fields_to_keep)))
//create an array of 1,2,3,4,5
val arr = (1 to 5).toArray
//get index of each element in the array
val arr_with_index = arr.zipWithIndex.toList
(json_obj \ "c").transform {
  case JArray(arr) => arr.zipWithIndex.map {
    case (x, index) => {
      val filtered = Some(index.toString -> x)
      filtered
    }
  }
}
// docker run -v /home/abhgupta/workspace/abhijit_scala/src/main/resources/config.json:/app/config.json --rm abhijitscala 2 /app/config.json
compact(render((json_obj \ "c").transform {
  case JArray(arr) => arr.zipWithIndex.map {
    case (x, index) => {
      val filtered = Some(index.toString -> x)
      filtered
    }
  }
}))