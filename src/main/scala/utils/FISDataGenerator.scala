package utils
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.{DefaultFormats, JField, JObject, JString, JValue}
import java.io.PrintWriter
import java.io.File
import scala.util.Random
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.net.URLEncoder
import com.mifmif.common.regex.Generex
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import utils.XMLFileReader._



object GenRegexObject {
  val nameRegex = new Generex("[A-Z][a-z]{3,8}\\s[A-Z][a-z]{3,10}")
  val lastNameRegex = new Generex("[A-Z][a-z]{3,8}")
  val addressRegex = new Generex("[A-Z][a-z]{3,8}\\s[A-Z][a-z]{3,10}\\s[A-Z][a-z]{3,10}")
  val cityRegex = new Generex("[A-Z][a-z]{3,8}")
  val stateRegex = new Generex("[A-Z]{2}")
  val zipRegex = new Generex("[0-9]{5}")
  val phoneRegex = new Generex("[0-9]{3}-[0-9]{3}-[0-9]{4}")
  val originatorToBeneficiaryInfoRegex = new Generex("[A-Z][a-z]{3,8}\\s[A-Z][a-z]{3,10}\\s[A-Z][a-z]{3,10}\\s[A-Z][a-z]{3,10}")
  val accountNumberRegex = new Generex("[0-9]{13,14}")
  val amountRegex = new Generex("[0-9]{1,10}\\.[0-9]{2}")
}

object GenerateMultipleJson {

  def generateRoutingNumber: String = {
    val random = new Random()
    val prefix = f"${List(random.between(1, 13),
                          random.between(21, 33),
                          random.between(61,73))(random.nextInt(3))}%02d"
    val prefix_next = f"${random.between(0, 100)}%02d"
    val xxxx = prefix + prefix_next
    val yyyy = f"${random.between(0, 10001)}%04d"
    val number = xxxx + yyyy

    val checksum = (3 * number.charAt(0).asDigit + 7 * number.charAt(1).asDigit + number.charAt(2).asDigit +
      3 * number.charAt(3).asDigit + 7 * number.charAt(4).asDigit + number.charAt(5).asDigit +
      3 * number.charAt(6).asDigit + 7 * number.charAt(7).asDigit)
    val rem = checksum % 10 
    val diff = 10 - checksum % 10
    s"$xxxx$yyyy$diff"
  }

  def generateDate: String = {
    val random = new Random()
    val year = random.between(2020, 2024)
    val month = random.between(1, 13)
    val day = random.between(1, 29)
    f"$year%04d$month%02d$day%02d"
  }

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

//   def filterFields(json: JValue, fieldsToKeep: JValue): JValue = {
//   (json, fieldsToKeep) match {
//     case (JObject(jsonFields), JObject(configFields)) => {
//       val filteredFields = jsonFields.map {
//         case (fieldName, fieldValue) => {
//           configFields.find(_._1 == fieldName) match {
//             case Some((_, JBool(true))) => (fieldName, fieldValue)
//             case Some((_, JBool(false))) => (fieldName, JNothing)
//             case Some((_, JObject(configFields))) => (fieldName, filterFields(fieldValue, JObject(configFields)))
//             case _ => (fieldName, fieldValue)
//           }
          
//         }
//       }
//       JObject(filteredFields)
//     }
//     case _ => json
//   }
// }
  def filterFields(json: JValue, configFields: JValue): JValue = {
    json match {
      case JObject(fields) => {
        val filteredFields = fields.map {
          case JField(fieldName, value) => {
            configFields \ fieldName match {
              case JNothing => None
              case JBool(true) => Some(JField(fieldName, value))
              case JBool(false) => None
              case JObject(_) => Some(JField(fieldName, filterFields(value, configFields \ fieldName)))
              case _ => None
            }
          }
        }
        JObject(filteredFields.flatten)
      }
      case _ => json
    }
  }


  def main(args: Array[String]): Unit = {
    //get the number of JSON objects to generate from the command line
    val numObjects = if args.nonEmpty then args(0).toInt else 10 // number of JSON objects to generate
    // take numObjects number of entries from 
    val country_currency = readCountryCurrencyCodes().filter(x => x(1) != "NA" && x(1).trim != "").toMap

    
    // take second element of country_currency_random
    val fileName = "sample_data.log" // output file name
    val random = new Random()
    // take random numObjects number of entries from country_currency shuffle
    //val country_currency_random = scala.util.Random.shuffle(country_currency).take(numObjects)
    val country_currency_random = (1 to numObjects).map(i => country_currency.toSeq(random.nextInt(country_currency.toSeq.size)))
    val countries = country_currency_random.map(_(0)).toList
    val currencies = country_currency_random.map(_(1)).toList
    val transactionLocalDateTime = LocalDateTime.of(2022, 5, 27, 12, 0, 0)

    val payeeAccounts = (1 to numObjects).map(i => GenRegexObject.accountNumberRegex.random())
    
    val amounts = (1 to numObjects).map(i => GenRegexObject.amountRegex.random().toDouble)
    
    val transactionKeyRegex = new Generex(s"${generateDate}[0-9]{5}")
    val transactionKeys = (1 to numObjects).map(i => transactionKeyRegex.random())
    
    val transactionLocalDateTimes = (1 to numObjects).map(i => generateDateTime)
  
    val accountKeys = (1 to numObjects).map(i => new Generex(s"466\\.${List("DP", "GL")((new Random()).nextInt(2))}\\.[0-9]{7}").random())
    
    val jsonObjects = (1 to numObjects).map { i =>
      JObject(
        //"id" -> JInt(i),

        "amount" -> AmountType(
          normalizedOriginalAmount = amounts(i - 1),
          originalCurrencyCd = currencies(i - 1),
          originalAmount = (f"${random.nextDouble()}%.02f").toDouble * 1000000,
          regionNormalizedOriginalAmount = (f"${random.nextDouble()}%.02f").toDouble * 1000000,
          accountAmount = (f"${random.nextDouble()}%.02f").toDouble * 1000000,
          oppAccountAmount = (f"${random.nextDouble()}%.02f").toDouble * 1000000,
        ).toJObj(),

        "baseTransactionA" -> BaseTransactionAType(
          channel = List("ONLINE", "OFFLINE", "MOBILE", "ATM")(random.nextInt(4)),
          resendDueToFailureInd = List(true, false)(random.nextInt(2)),
          sourceCd = s"WireSystem_${random.nextInt(10) + 1}",
          transactionLocalDateTime = transactionLocalDateTimes(i-1),
          partyKey = s"466.${random.nextInt(1000)}",
          transactionNormalizedDateTime = transactionLocalDateTimes(i-1)
        ).toJObj(),
        
        "baseTransactionB" -> BaseTransactionBType(
          accountKey = accountKeys(i-1),
        ).toJObj(),

        "baseTransactionC" -> BaseTransactionCType(
          transactionKey = transactionKeys(i-1),
          transactionType = if countries(i-1) == "US" then "Domestic" else "International",
        ).toJObj(),

        "monetaryTransactionB" -> MonetaryTransactionBType(
          fundsDirectionCd = 1, //List(0, 1)(random.nextInt(2)),
          payeeDataAccountNumber = payeeAccounts(i-1),
          transactionId = transactionKeys(i-1),
          addendaRecordCount = random.nextInt(100),
          payeePartyKey = ""
        ).toJObj(),


        "partyReference" -> PartyReferenceType(
          partyType = List("Individual", "Organization")(random.nextInt(2)),
          accountOwnershipReference = AccountOwnershipType(),
          contactReference = ContactReferenceType(),
          addressData = AddressType(),
          referenceUpdateDates = ReferenceUpdateDatesType(addressUpdateDate = generateDateTime,
                                                          emailUpdateDate = generateDateTime,
                                                          phoneUpdateDate = generateDateTime,
                                                          infoUpdateDate = generateDateTime,
                                                          nameUpdateDate = generateDateTime,
                                                          mobilePhoneUpdateDate = generateDateTime,
                                                          passwordUpdateDate = generateDateTime,
                                                          phone2UpdateDate = generateDateTime,
                                                          phone3UpdateDate = generateDateTime,
                                                          pinUpdateDate = generateDateTime),

        ).toJObj(),

        "title" -> JString("detectionRequestWire"),
        "transferTransaction" -> TransferTransactionType(
          executionDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
          isAddEditPayee = List(true, false)(random.nextInt(2)),
          isStandingOrder = List(true, false)(random.nextInt(2)),
          paymentSpeedCd = List("0","1").apply(random.nextInt(2)),
        ).toJObj(),

        "trxMonitoredAccountData" -> TrxAccountDataType(
          accountNumber = accountKeys(i-1).split("\\.")(2),
          overdraftBalance = GenRegexObject.amountRegex.random().toDouble,
          currencyCd = currencies(i - 1),
          currentBalance = GenRegexObject.amountRegex.random().toDouble,
        ).toJObj(),

        "trxPayeeAccountData" -> TrxAccountDataType(
          accountNumber = payeeAccounts(i-1),
          fiName = GenRegexObject.nameRegex.random(),
          routingNumber = generateRoutingNumber,
          routingType = if countries(i - 1) == "US" then "ABA" else "BIC"
          ).toJObj(),
        "trxPayeePartyData" -> TrxPartyDataType(
          name = GenRegexObject.nameRegex.random(),
          lastName = GenRegexObject.lastNameRegex.random(),
          addressData = AddressType(
            addressLine1 = GenRegexObject.addressRegex.random(),
            countryCd = countries(i - 1),
            state = GenRegexObject.stateRegex.random(),
          ),
        ).toJObj(),
        "wirePayee" -> WirePayeeType(
          originatorToBeneficiaryInfo = random.alphanumeric.take(random.between(1,100)).mkString,
          wirePayeeAddress = GenRegexObject.addressRegex.random(),
        ).toJObj(),

        "channel" -> JString(List("ONLINE", "OFFLINE", "MOBILE", "ATM")(random.nextInt(4)))

      )
      
      

    }
    val fieldsToKeep = if args.nonEmpty && args.length == 2 then parse(scala.io.Source.fromFile(args(1).trim)("UTF-8").mkString) else parse(getClass.getResourceAsStream("/config.json"))
    // remove attributes with empty values
    val jsonObjects_mod = jsonObjects.map(x => filterFields(x, fieldsToKeep))
    val jsonObjects2 = jsonObjects_mod.map(x => x.removeField {
      case JField(_, JString(s)) if s.isEmpty => true
      case JField(_, JArray(arr)) if arr.isEmpty => true
      case JField(_, JObject(obj)) if obj.isEmpty => true
      case _ => false
    })
    

    
    
    
    // sort the JSON objects by transactionNormalizedDateTime by parsing the date string 
    // and converting it to a LocalDateTime object
    val sortedJsonObjects = jsonObjects2.sortBy(x => LocalDateTime.parse(x \ "baseTransactionA" \ "transactionNormalizedDateTime" match {
      case JString(s) => s
      case _ => throw new Exception("Could not parse transactionNormalizedDateTime")
    }, DateTimeFormatter.ISO_DATE_TIME))
    // replace compact with pretty to get pretty printed JSON
    // minify the JSON objects and print them in a log file 
    val jsonString = sortedJsonObjects.map(x => compact(render(x))).mkString("\n")
    
    val writer = new PrintWriter(fileName)
    writer.write(jsonString)
    writer.close()

    println(s"Generated $numObjects JSON objects and wrote them to $fileName.")
  }
}