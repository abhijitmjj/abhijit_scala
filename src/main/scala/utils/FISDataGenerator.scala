package utils
import org.json4s._
import org.json4s.jackson.JsonMethods._
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

case class BaseTransactionAType(
    actionInitiatorCd: String = "",
    dataSetId: String = "",
    executingUserId: String = "",
    resendDueToFailureInd: Boolean,
    branchKey: String = "",
    cardKey: String = "",
    employeeKey: String = "",
    partyKey: String,
    sessionKey: String = "",
    userId: String = "",
    transactionLocalDateTime: String,
    transactionNormalizedDateTime: String,
    transferApprovingUserId: String = "",
    transactionSendingSystemCd: String = "",
    sourceCd: String,
    tenantId: String = "",
    productBrand: String = "",
    executingTerminalId: String = "",
    channel: String,
    transactionSECCode: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "actionInitiatorCd" -> JString(actionInitiatorCd),
      "dataSetId" -> JString(dataSetId),
      "executingUserId" -> JString(executingUserId),
      "resendDueToFailureInd" -> JBool(resendDueToFailureInd),
      "branchKey" -> JString(branchKey),
      "cardKey" -> JString(cardKey),
      "employeeKey" -> JString(employeeKey),
      "partyKey" -> JString(partyKey),
      "sessionKey" -> JString(sessionKey),
      "userId" -> JString(userId),
      "transactionLocalDateTime" -> JString(transactionLocalDateTime),
      "transactionNormalizedDateTime" -> JString(transactionNormalizedDateTime),
      "transferApprovingUserId" -> JString(transferApprovingUserId),
      "transactionSendingSystemCd" -> JString(transactionSendingSystemCd),
      "sourceCd" -> JString(sourceCd),
      "tenantId" -> JString(tenantId),
      "productBrand" -> JString(productBrand),
      "executingTerminalId" -> JString(executingTerminalId),
      "channel" -> JString(channel),
      "transactionSECCode" -> JString(transactionSECCode)
    )
  }
}

case class BaseTransactionBType(
    accountKey: String,
    overrideTypeCd: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "accountKey" -> JString(accountKey),
      "overrideTypeCd" -> JString(overrideTypeCd)
    )
  }
}


case class BaseTransactionCType(
    transactionKey: String,
    transactionType: String,
    transactionOriginationSystemCd: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "transactionKey" -> JString(transactionKey),
      "transactionType" -> JString(transactionType),
      "transactionOriginationSystemCd" -> JString(transactionOriginationSystemCd)
    )
  }
}


case class MonetaryTransactionAType(
    batchId: String = "",
    isOriginated: Boolean = false,
    logicalFileSequenceId: String = "",
    logicalInputFileCreationDateTime: String = "",
    logicalInputFileCreationNormalizedDateTime: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "batchId" -> JString(batchId),
      "isOriginated" -> JBool(isOriginated),
      "logicalFileSequenceId" -> JString(logicalFileSequenceId),
      "logicalInputFileCreationDateTime" -> JString(logicalInputFileCreationDateTime),
      "logicalInputFileCreationNormalizedDateTime" -> JString(logicalInputFileCreationNormalizedDateTime)
    )
  }
}


case class MonetaryTransactionBType(
    addendaRecordCount: Int,
    fundsDirectionCd: Int,
    isTruncated: Boolean = false,
    isTrxOnUs: Boolean = false,
    memo: String = "",
    oppAccountKey: String = "",
    oppPartyKey: String = "",
    parentTransactionKey: String = "",
    payeeAccountKey: String = "",
    payeeAliasKey: String = "",
    payeeDataAccountNumber: String,
    payeePartyKey: String,
    transactionId: String,
    instrumentNumber: String = "",
    instrumentTypeCd: String = "",
    instrumentDate: String = "",
    isRedeposit: Boolean = false
) {
  def toJObj(): JObject = {
    JObject(
      "addendaRecordCount" -> JInt(addendaRecordCount),
      "fundsDirectionCd" -> JInt(fundsDirectionCd),
      "isTruncated" -> JBool(isTruncated),
      "isTrxOnUs" -> JBool(isTrxOnUs),
      "memo" -> JString(memo),
      "oppAccountKey" -> JString(oppAccountKey),
      "oppPartyKey" -> JString(oppPartyKey),
      "parentTransactionKey" -> JString(parentTransactionKey),
      "payeeAccountKey" -> JString(payeeAccountKey),
      "payeeAliasKey" -> JString(payeeAliasKey),
      "payeeDataAccountNumber" -> JString(payeeDataAccountNumber),
      "payeePartyKey" -> JString(payeePartyKey),
      "transactionId" -> JString(transactionId),
      "instrumentNumber" -> JString(instrumentNumber),
      "instrumentTypeCd" -> JString(instrumentTypeCd),
      "instrumentDate" -> JString(instrumentDate),
      "isRedeposit" -> JBool(isRedeposit)
    )
  }
}

case class AddressType(
    addressLine1: String = "",
    addressLine2: String = "",
    addressLine3: String = "",
    city: String = "",
    countryCd: String = "",
    POBox: String = "",
    state: String = "",
    zipPostcode: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "addressLine1" -> JString(addressLine1),
      "addressLine2" -> JString(addressLine2),
      "addressLine3" -> JString(addressLine3),
      "city" -> JString(city),
      "countryCd" -> JString(countryCd),
      "POBox" -> JString(POBox),
      "state" -> JString(state),
      "zipPostcode" -> JString(zipPostcode)
    )
  }
}

case class AmountType(
    originalCurrencyCd: String,
    originalAmount: Double,
    normalizedOriginalAmount: Double,
    regionNormalizedOriginalAmount: Double = 0.0,
    accountAmount: Double = 0.0, 
    oppAccountAmount: Double = 0.0
) {
  def toJObj(): JObject = {
    JObject(
      "originalCurrencyCd" -> JString(originalCurrencyCd),
      "originalAmount" -> JDouble(originalAmount),
      "normalizedOriginalAmount" -> JDouble(normalizedOriginalAmount),
      "regionNormalizedOriginalAmount" -> JDouble(regionNormalizedOriginalAmount),
      "accountAmount" -> JDouble(accountAmount),
      "oppAccountAmount" -> JDouble(oppAccountAmount)
    )
  }
}

case class TrxAccountDataType(
    accountNumber: String = "",
    currencyCd: String = "",
    currentBalance: Option[Double],
    overdraftBalance: Double = 0.0,
    uncollectedBalance: Double = 0.0,
    routingNumber: String = "",
    routingType: String = "",
    availableBalance: Double = 0.0,
    branchCountryCd: String = "",
    accountName: String = "",
    accountType: String = "",
    fiName: String = "",
    ledgerBalance: Double = 0.0
) {
  def toJObj(): JObject = {
    JObject(
      "accountNumber" -> JString(accountNumber),
      "currencyCd" -> JString(currencyCd),
      "currentBalance" -> JDouble(currentBalance.getOrElse(0.0)),
      "overdraftBalance" -> JDouble(overdraftBalance),
      "uncollectedBalance" -> JDouble(uncollectedBalance),
      "routingNumber" -> JString(routingNumber),
      "routingType" -> JString(routingType),
      "availableBalance" -> JDouble(availableBalance),
      "branchCountryCd" -> JString(branchCountryCd),
      "accountName" -> JString(accountName),
      "accountType" -> JString(accountType),
      "fiName" -> JString(fiName),
      "ledgerBalance" -> JDouble(ledgerBalance),
    )
  }
}

case class TrxPartyDataType(
    name: String = "",
    lastName: String = "",
    paymentSchemePartyId: String = "",
    addressData: AddressType
) {
  def toJObj(): JObject = {
    JObject(
      "name" -> JString(name),
      "lastName" -> JString(lastName),
      "paymentSchemePartyId" -> JString(paymentSchemePartyId),
      "addressData" -> addressData.toJObj()
    )
  }
}


case class WirePayeeType(
    bankToBankInfo: Option[String],
    creditBankInfo: Option[String],
    intermediaryBankRoutingNumber: Option[String],
    intermediaryBankRoutingTypeCd: Option[String],
    originatorToBeneficiaryInfo: Option[String],
    wirePayeeAddress: Option[String]
) {
  def toJObj(): JObject = {
    JObject(
      "bankToBankInfo" -> JString(bankToBankInfo.getOrElse("")),
      "creditBankInfo" -> JString(creditBankInfo.getOrElse("")),
      "intermediaryBankRoutingNumber" -> JString(intermediaryBankRoutingNumber.getOrElse("")),
      "intermediaryBankRoutingTypeCd" -> JString(intermediaryBankRoutingTypeCd.getOrElse("")),
      "originatorToBeneficiaryInfo" -> JString(originatorToBeneficiaryInfo.getOrElse("")),
      "wirePayeeAddress" -> JString(wirePayeeAddress.getOrElse("")),
    )
  }
}

case class AccountOwnershipType(
    bankingInd: Boolean = false,
    creditCardInd: Boolean = false,
    insuranceInd: Boolean = false,
    investmentsInd: Boolean = false,
    loanInd: Boolean = false,
    longSavingsInd: Boolean = false,
    mortgageInd: Boolean = false,
    savingsInd: Boolean = false
) {
  def toJObj(): JObject = {
    JObject(
      "bankingInd" -> JBool(bankingInd),
      "creditCardInd" -> JBool(creditCardInd),
      "insuranceInd" -> JBool(insuranceInd),
      "investmentsInd" -> JBool(investmentsInd),
      "loanInd" -> JBool(loanInd),
      "longSavingsInd" -> JBool(longSavingsInd),
      "mortgageInd" -> JBool(mortgageInd),
      "savingsInd" -> JBool(savingsInd)
    )
  }
}

case class ReferenceUpdateDatesType(
    addressUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    emailUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    infoUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    mobilePhoneUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    nameUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    passwordUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    phoneUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    phone2UpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    phone3UpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    pinUpdateDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
) {
  def toJObj(): JObject = {
    JObject(
      "addressUpdateDate" -> JString(addressUpdateDate),
      "emailUpdateDate" -> JString(emailUpdateDate),
      "infoUpdateDate" -> JString(infoUpdateDate),
      "mobilePhoneUpdateDate" -> JString(mobilePhoneUpdateDate),
      "nameUpdateDate" -> JString(nameUpdateDate),
      "passwordUpdateDate" -> JString(passwordUpdateDate),
      "phoneUpdateDate" -> JString(phoneUpdateDate),
      "phone2UpdateDate" -> JString(phone2UpdateDate),
      "phone3UpdateDate" -> JString(phone3UpdateDate),
      "pinUpdateDate" -> JString(pinUpdateDate)
    )
  }
}


case class ContactReferenceType(
    email: String = "",
    mobilePhone: String = "",
    phone: String = "",
    phone2: String = "",
    phone3: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "email" -> JString(email),
      "mobilePhone" -> JString(mobilePhone),
      "phone" -> JString(phone),
      "phone2" -> JString(phone2),
      "phone3" -> JString(phone3)
    )
  }
}


case class PartyReferenceType(
    birthIncorpDate: String = "",
    lastName: String = "",
    name: String = "",
    onlineServiceJoinDate: String = "",
    effectiveDate: String = "",
    taxId: String = "",
    partyType: String = "",
    isOurEmployee: Boolean = false,
    accountOwnershipReference: AccountOwnershipType,
    addressData: AddressType,
    contactReference: ContactReferenceType,
    referenceUpdateDates: ReferenceUpdateDatesType
) {
  def toJObj(): JObject = {
    JObject(
      "birthIncorpDate" -> JString(birthIncorpDate),
      "lastName" -> JString(lastName),
      "name" -> JString(name),
      "onlineServiceJoinDate" -> JString(onlineServiceJoinDate),
      "effectiveDate" -> JString(effectiveDate),
      "taxId" -> JString(taxId),
      "partyType" -> JString(partyType),
      "isOurEmployee" -> JBool(isOurEmployee),
      "accountOwnershipReference" -> accountOwnershipReference.toJObj(),
      "addressData" -> addressData.toJObj(),
      "contactReference" -> contactReference.toJObj(),
      "referenceUpdateDates" -> referenceUpdateDates.toJObj()
    )
  }
}        


case class TransferTransactionType(
    createdFromTemplateInd: Boolean = false,
    emailNotificationInd: Boolean = false,
    isAddEditPayee: Boolean = false,
    isAddEditPayor: Boolean = false,
    isEbill: Boolean = false,
    isLastTransactionInBatch: Boolean = false,
    isStandingOrder: Boolean = false,
    executionDate: String = "",
    paymentSpeedCd: String = "",
    originatorIdentifierForPayor: String = "",
    numberOfApproversRequired: Int = 0,
    payeeCreateUpdateDate: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "createdFromTemplateInd" -> JBool(createdFromTemplateInd),
      "emailNotificationInd" -> JBool(emailNotificationInd),
      "isAddEditPayee" -> JBool(isAddEditPayee),
      "isAddEditPayor" -> JBool(isAddEditPayor),
      "isEbill" -> JBool(isEbill),
      "isLastTransactionInBatch" -> JBool(isLastTransactionInBatch),
      "isStandingOrder" -> JBool(isStandingOrder),
      "executionDate" -> JString(executionDate),
      "paymentSpeedCd" -> JString(paymentSpeedCd),
      "originatorIdentifierForPayor" -> JString(originatorIdentifierForPayor),
      "numberOfApproversRequired" -> JInt(numberOfApproversRequired),
      "payeeCreateUpdateDate" -> JString(payeeCreateUpdateDate)
    )
  }
}

// composer class to create a JSON object using builder pattern 
class JsonBuilder {
  var amount: AmountType = _
  var baseTransactionA : BaseTransactionAType = _
  var baseTransactionB : BaseTransactionBType = _
  var baseTransactionC : BaseTransactionCType = _
  var monetaryTransactionB : MonetaryTransactionBType = _
  var partyReference : PartyReferenceType = _
  var title: String = ""
  var transferTransaction: TransferTransactionType = _
  var trxMonitoredAccountData: TrxAccountDataType = _
  var trxPayeeAccountData: TrxAccountDataType = _
  var trxPayeePartyData: TrxPartyDataType = _
  var wirePayee: WirePayeeType = _

  def setAmount(amount: AmountType): JsonBuilder = {
    this.amount = amount
    this
  }

  def setBaseTransactionA(baseTransactionA: BaseTransactionAType): JsonBuilder = {
    this.baseTransactionA = baseTransactionA
    this
  }

  def setBaseTransactionB(baseTransactionB: BaseTransactionBType): JsonBuilder = {
    this.baseTransactionB = baseTransactionB
    this
  }

  def setBaseTransactionC(baseTransactionC: BaseTransactionCType): JsonBuilder = {
    this.baseTransactionC = baseTransactionC
    this
  }

  def setMonetaryTransactionB(monetaryTransactionB: MonetaryTransactionBType): JsonBuilder = {
    this.monetaryTransactionB = monetaryTransactionB
    this
  }

  def setPartyReference(partyReference: PartyReferenceType): JsonBuilder = {
    this.partyReference = partyReference
    this
  }

  def setTitle(title: String): JsonBuilder = {
    this.title = title
    this
  }

  def setTransferTransaction(transferTransaction: TransferTransactionType): JsonBuilder = {
    this.transferTransaction = transferTransaction
    this
  }

  def setTrxMonitoredAccountData(trxMonitoredAccountData: TrxAccountDataType): JsonBuilder = {
    this.trxMonitoredAccountData = trxMonitoredAccountData
    this
  }

  def setTrxPayeeAccountData(trxPayeeAccountData: TrxAccountDataType): JsonBuilder = {
    this.trxPayeeAccountData = trxPayeeAccountData
    this
  }

  def setTrxPayeePartyData(trxPayeePartyData: TrxPartyDataType): JsonBuilder = {
    this.trxPayeePartyData = trxPayeePartyData
    this
  }

  def setWirePayee(wirePayee: WirePayeeType): JsonBuilder = {
    this.wirePayee = wirePayee
    this
  }

  def build(): JObject = {
    JObject(
      "title" -> JString(title),
      "amount" -> amount.toJObj(),
      "baseTransactionA" -> baseTransactionA.toJObj(),
      "baseTransactionB" -> baseTransactionB.toJObj(),
      "baseTransactionC" -> baseTransactionC.toJObj(),
      "monetaryTransactionB" -> monetaryTransactionB.toJObj(),
      "partyReference" -> partyReference.toJObj(),
      "transferTransaction" -> transferTransaction.toJObj(),
      "trxMonitoredAccountData" -> trxMonitoredAccountData.toJObj(),
      "trxPayeeAccountData" -> trxPayeeAccountData.toJObj(),
      "trxPayeePartyData" -> trxPayeePartyData.toJObj(),
      "wirePayee" -> wirePayee.toJObj()
    )
  }

}

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

  def main(args: Array[String]): Unit = {
    //get the number of JSON objects to generate from the command line
    val numObjects = args(0).toInt  // number of JSON objects to generate
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
          currentBalance = Option(GenRegexObject.amountRegex.random().toDouble),
        ).toJObj(),

        "trxPayeeAccountData" -> JObject(
          "accountNumber" -> JString(payeeAccounts(i-1)),
          "fiName" -> JString(GenRegexObject.nameRegex.random()),
          "routingNumber" -> JLong(generateRoutingNumber.toLong),
          "routingType" -> JString(if countries(i - 1) == "US" then "ABA" else "BIC")
        ),
        "trxPayeePartyData" -> JObject(
          "addressData" -> JObject(
            "addressLine1" -> JString(GenRegexObject.addressRegex.random()),
            "countryCd" -> JString(countries(i - 1)),
            "state" -> JString(GenRegexObject.stateRegex.random()),
          ),
          "lastName" -> JString(GenRegexObject.lastNameRegex.random()),
          "name" -> JString(GenRegexObject.nameRegex.random())
        ),
        "wirePayee" -> JObject(
          "originatorToBeneficiaryInfo" -> JString(random.alphanumeric.take(random.between(1,100)).mkString),
          "wirePayeeAddress" -> JString(GenRegexObject.addressRegex.random()),
        ),

        "channel" -> JString(List("ONLINE", "OFFLINE", "MOBILE", "ATM")(random.nextInt(4)))

      )
      
      

    }
    // remove attributes with empty values
    val jsonObjects2 = jsonObjects.map(x => x.removeField {
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