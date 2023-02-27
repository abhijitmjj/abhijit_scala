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
