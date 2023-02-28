package utils
import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class BaseTransactionAType(
    actionInitiatorCd: String = "",
    dataSetId: String = "",
    executingUserId: String = "",
    resendDueToFailureInd: Boolean = false,
    branchKey: String = "",
    cardKey: String = "",
    employeeKey: String = "",
    partyKey: String = "",
    sessionKey: String = "",
    userId: String = "",
    transactionLocalDateTime: String = "",
    transactionNormalizedDateTime: String = "",
    transferApprovingUserId: String = "",
    transactionSendingSystemCd: String = "",
    sourceCd: String = "",
    tenantId: String = "",
    productBrand: String = "",
    executingTerminalId: String = "",
    channel: String = "",
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


case class BaseTransactionCType(
    transactionKey: String = "",
    transactionType: String = "",
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
    addendaRecordCount: Int = 0,
    fundsDirectionCd: Int = 0,
    isTruncated: Boolean = false,
    isTrxOnUs: Boolean = false,
    memo: String = "",
    oppAccountKey: String = "",
    oppPartyKey: String = "",
    parentTransactionKey: String = "",
    payeeAccountKey: String = "",
    payeeAliasKey: String = "",
    payeeDataAccountNumber: String = "",
    payeePartyKey: String = "",
    transactionId: String = "",
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
    originalCurrencyCd: String = "",
    originalAmount: Double = 0.0,
    normalizedOriginalAmount: Double = 0.0,
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
    currentBalance: Option[Double] = None,
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
    addressData: AddressType = AddressType()
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
    bankToBankInfo: Option[String] = None,
    creditBankInfo: Option[String] = None,
    intermediaryBankRoutingNumber: Option[String] = None,
    intermediaryBankRoutingTypeCd: Option[String] = None,
    originatorToBeneficiaryInfo: Option[String] = None,
    wirePayeeAddress: Option[String] = None
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
    accountOwnershipReference: AccountOwnershipType = AccountOwnershipType(),
    addressData: AddressType = AddressType(),
    contactReference: ContactReferenceType = ContactReferenceType(),
    referenceUpdateDates: ReferenceUpdateDatesType = ReferenceUpdateDatesType()
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

object JsonBuilder {
  def apply(): JsonBuilder = new JsonBuilder()
                                .setAmount(AmountType(originalCurrencyCd = "USD",
                                                      originalAmount= 100.00,
                                                      normalizedOriginalAmount = 100.00,
                                                      regionNormalizedOriginalAmount = 100.00,
                                                      accountAmount = 0.0,
                                                      oppAccountAmount = 0.0))
                                .setBaseTransactionA(BaseTransactionAType())
                                .setBaseTransactionB(BaseTransactionBType())
                                .setBaseTransactionC(BaseTransactionCType())
                                .setMonetaryTransactionB(MonetaryTransactionBType())
                                .setPartyReference(PartyReferenceType())
                                .setTitle("title")
                                .setTransferTransaction(TransferTransactionType())
                                .setTrxMonitoredAccountData(TrxAccountDataType())
                                .setTrxPayeeAccountData(TrxAccountDataType())
                                .setTrxPayeePartyData(TrxPartyDataType())
                                .setWirePayee(WirePayeeType())
  

  def main(args: Array[String]): Unit = {
    val json = JsonBuilder().build()
    println(pretty(render(json)))
  }
                                
}
