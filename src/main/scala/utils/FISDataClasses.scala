package utils
import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


import org.json4s.native.Serialization.write
import org.json4s.jackson.Json

trait Jsonable {
  def toJson(): JValue = Extraction.decompose(this)(DefaultFormats)
  def toJObj(): JObject = JObject(Extraction.decompose(this)(DefaultFormats).asInstanceOf[JObject].obj)

  def toJString(): String = write(this)(DefaultFormats)
}

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
) extends Jsonable {
  override def toJObj(): JObject = {
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
  override def toJson(): JValue = this.toJObj().asInstanceOf[JValue]
  override def toJString(): String = compact(render(this.toJObj()))
}

case class BaseTransactionBType(
    accountKey: String = "",
    overrideTypeCd: String = ""
) extends Jsonable


case class BaseTransactionCType(
    transactionKey: String = "",
    transactionType: String = "",
    transactionOriginationSystemCd: String = ""
) extends Jsonable


case class MonetaryTransactionAType(
    batchId: String = "",
    isOriginated: Boolean = false,
    logicalFileSequenceId: String = "",
    logicalInputFileCreationDateTime: String = "",
    logicalInputFileCreationNormalizedDateTime: String = ""
) extends Jsonable


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
) extends Jsonable

case class AddressType(
    addressLine1: String = "",
    addressLine2: String = "",
    addressLine3: String = "",
    city: String = "",
    countryCd: String = "",
    POBox: String = "",
    state: String = "",
    zipPostcode: String = ""
) extends Jsonable{
  override def toJObj(): JObject = {
    JObject(
      "addressLine1" -> JString(addressLine1.trim),
      "addressLine2" -> JString(addressLine2.trim),
      "addressLine3" -> JString(addressLine3.trim),
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
) extends Jsonable {
  override def toJObj(): JObject = {
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
    currentBalance: Double = 0.0,
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
) extends Jsonable

case class TrxPartyDataType(
    name: String = "",
    lastName: String = "",
    paymentSchemePartyId: String = "",
    addressData: AddressType = AddressType()
) extends Jsonable


case class WirePayeeType(
    bankToBankInfo: String = "",
    creditBankInfo: String = "",
    intermediaryBankRoutingNumber: String = "",
    intermediaryBankRoutingTypeCd: String = "",
    originatorToBeneficiaryInfo: String = "",
    wirePayeeAddress: String = ""
) extends Jsonable

case class AccountOwnershipType(
    bankingInd: Boolean = false,
    creditCardInd: Boolean = false,
    insuranceInd: Boolean = false,
    investmentsInd: Boolean = false,
    loanInd: Boolean = false,
    longSavingsInd: Boolean = false,
    mortgageInd: Boolean = false,
    savingsInd: Boolean = false
) extends Jsonable

case class ContactReferenceType(
    email: String = "",
    mobilePhone: String = "",
    phone: String = "",
    phone2: String = "",
    phone3: String = ""
) extends Jsonable

case class PartyRelationReferenceType(
    startDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    partyRelationType: String = ""
) extends Jsonable


case class AuthenticationType(
    method1: String = "",
    method1Detail1: String = ""
) extends Jsonable


case class BranchReferenceType(
    name: String = "",
    routingNumber: String = "",
    routingType: String = "",
    addressData: AddressType = AddressType()
) extends Jsonable


case class CalculatedOnlineDeviceIdentifiersType(
    onlineDeviceId: String = "",
    firstSeen: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    lastEvent: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    idConfidence: Double = 0.0
) extends Jsonable


case class CardDeviceType(
    acquiringInstitutionId: String = "",
    addressData: AddressType = AddressType(),
    branch: String = "",
    cardAcceptorId: String = "",
    isTerminalCardCaptureCapable: Boolean = false,
    merchantCategoryCd: String = "",
    nameLocation: String = "",
    networkId: String = "",
    onUsInd: Boolean = false,
    ownerName: String = "",
    panEntryCapability: String = "",
    panEntryModeCd: String = "",
    pinEntryCapability: String = "",
    posTerminalAttendanceIndicatorCd: String = "",
    terminalCapabilities: String = "",
    terminalId: String = "",
    terminalTypeCd: String = "",
    transactionCategoryCd: String = ""
) extends Jsonable


case class CustomDataType(
    cs1: String = "",
    cs2: String = "",
    cs3: String = "",
    cs4: String = "",
    cs5: String = "",
    cs6: String = "",
    cs7: String = "",
    cs8: String = "",
    cb1: Boolean = false,
    cb2: Boolean = false,
    cb3: Boolean = false,
    cb4: Boolean = false,
    cb5: Boolean = false,
    cb6: Boolean = false,
    cn1: Double = 0.0,
    cn2: Double = 0.0,
    cn3: Double = 0.0,
    cn4: Double = 0.0,
    cn5: Double = 0.0,
    cn6: Double = 0.0,
    cn7: Double = 0.0,
    cn8: Double = 0.0,
    cn9: Double = 0.0,
    cn10: Double = 0.0
) extends Jsonable


case class DepositMetadataType(
    creditItemCount: Int = 0,
    netNormalizedAmount: Double = 0.0,
    totalCreditCashNormalizedAmount: Double = 0.0,
    totalCreditItemNormalizedAmount: Double = 0.0,
    totalDebitCashNormalizedAmount: Double = 0.0
) extends Jsonable

case class AccountReferenceType(
    openDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    overdraftLimit: Double = 0.0,
    reopenDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    status: String = "",
    holdingBranchKey: String = "",
    accountName: String = "",
    openingBranchKey: String = "",
    primaryPartyKey: String = "",
    accountType: String = "",
    numberOfRelatedParties: Int = 0,
    openingChannelCd: String = "",
    isPositivePay: Boolean = false,
    isEmployeeOwned: Boolean = false,
    addressData: AddressType = AddressType(),
    contactReference: ContactReferenceType = ContactReferenceType(),
    partyRelationReference: PartyRelationReferenceType = PartyRelationReferenceType(),
    referenceUpdateDates: ReferenceUpdateDatesType = ReferenceUpdateDatesType()
) extends Jsonable {
  override def toJObj(): JObject = {
    JObject(
      "openDate" -> JString(openDate),
      "overdraftLimit" -> JDouble(overdraftLimit),
      "reopenDate" -> JString(reopenDate),
      "status" -> JString(status),
      "holdingBranchKey" -> JString(holdingBranchKey),
      "accountName" -> JString(accountName),
      "openingBranchKey" -> JString(openingBranchKey),
      "primaryPartyKey" -> JString(primaryPartyKey),
      "accountType" -> JString(accountType),
      "numberOfRelatedParties" -> JInt(numberOfRelatedParties),
      "openingChannelCd" -> JString(openingChannelCd),
      "isPositivePay" -> JBool(isPositivePay),
      "isEmployeeOwned" -> JBool(isEmployeeOwned),
      "addressData" -> addressData.toJObj(),
      "contactReference" -> contactReference.toJObj(),
      "partyRelationReference" -> partyRelationReference.toJObj(),
      "referenceUpdateDates" -> referenceUpdateDates.toJObj()
    )
  }
}



class EmployeeReferenceType(
    positionCd: String = "",
    typeCd: String = ""
) extends Jsonable



case class ManagedPayeeType(
    businessCategory: String = "",
    isManaged: Boolean = false,
    referenceNumber: String = ""
) extends Jsonable

case class IdentificationType(
    method1: String = "",
    method1Detail1: String = ""
) extends Jsonable



case class OnlineDeviceIdentifiersType(
    onlineDeviceId: String = "",
    firstSeen: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    lastEvent: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    idConfidence: Double = 0.0,
    lookupCount: Int = 0,
    reportCount: Int = 0
) extends Jsonable


case class HTTPHeaderType(
    httpHeaderFields: String = ""
) extends Jsonable

case class OnlineSessionType(
    headerUserAgent: String = "",
    ipAddress: String = "",
    loginName: String = "",
    startDateTime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    secondFactorAuthInd: Boolean = false,
    httpHeader: HTTPHeaderType = HTTPHeaderType()
) extends Jsonable


case class PhoneSessionType(
    deviceSourceNumber: String = "",
    authenticationChannel: String = "",
    authenticationMethod: String = "",
    sessionDateTime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    duration: Double = 0.0,
    isInitiatedByCustomer: Boolean = false
) extends Jsonable



case class RejectDataType(
    dataCompletenessLevel: String = "",
    rejectedDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    rejectedTransactionInd: Boolean = false,
    rejectedTypeCd: String = ""
) extends Jsonable{
  override def toJObj(): JObject = {
    JObject(
      "dataCompletenessLevel" -> JString(dataCompletenessLevel),
      "rejectedDate" -> JString(rejectedDate),
      "rejectedTransactionInd" -> JBool(rejectedTransactionInd),
      "rejectedTypeCd" -> JString(rejectedTypeCd)
    )
  }
}


case class TrxCashLetterMetadataType(
    cashLetterBankOfFirstDepositItemSequenceNumber: String = "",
    cashLetterBundleID: String = "",
    cashLetterCreationDatetime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    cashLetterECEInstitutionItemSequenceNumber: String = "",
    cashLetterECEInstitutionRoutingNumber: String = "",
    cashLetterID: String = "",
    cashLetterMicrCorrectionIndicatorCode: String = "",
    cashLetterMicrValidIndicatorCode: String = ""
) extends Jsonable


case class TrxMICRDataType(
    accountNumber: String = "",
    accountNumberCheckDigit: String = "",
    instrumentNumber: String = "",
    routingNumber: String = "",
    routingNumberCheckDigit: String = "",
    micrAuxiliaryOnUs: String = "",
    micrExternalProcessingCode: Boolean = false,
    instrumentAmount: String = ""
) extends Jsonable



case class MobileDeviceType(
    mobileDeviceData: String = "",
    cellId: String = "",
    imei: String = "",
    imsi: String = "",
    deviceName: String = "",
    isRootedJailbroken: Boolean = false,
    gpsCoordinates: String = "",
    timeZone: String = "",
    deviceBrand: String = "",
    osVersion: String = "",
    phoneNumber: String = "",
    deviceModel: String = "",
    os: String = "",
    screenResolution: String = "",
    appVersion: String = "",
    malwareList: String = "",
    malwareReasonCode: String = "",
    connectionTypeCode: String = "",
    rootedJailbrokenReasonCode: String = "",
    cellTowerCoordinates: String = "",
    simISOCountryCode: String = "",
    ituMobileCountryCode: Int = 0,
    ituMobileNetworkCode: Int = 0,
    networkName: String = "",
    androidId: String = "",
    appleIdentifierForVendor: String = "",
    appleAdvertisingId: String = "",
    installedAppList: String = ""
) extends Jsonable


case class TrxReturnDataType(
    endorsementDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    isReturnRedepositEligible: Boolean = false,
    originalTrxId: String = "",
    returnCount: Int = 0,
    returnReasonCdStandardCd: String = "",
    returnReasonCode: String = "",
    returnReasonRemarks: String = ""
) extends Jsonable



case class UserReferenceType(
    birthDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    name: String = "",
    onlineServiceJoinDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    addressData: AddressType = AddressType(),
    contactReference: ContactReferenceType = ContactReferenceType(),
    referenceUpdateDates: ReferenceUpdateDatesType = ReferenceUpdateDatesType()
) extends Jsonable


case class VersionDataType(
    transactionActionCd: String = "",
    transactionStatusCd: String = "",
    transactionVersionDescription: String = ""
) extends Jsonable

case class TrxServicesChangeDataType(
    defaultUDMUpdateInd: Boolean = false,
    entityStaticData: String = "",
    newValue: String = "",
    oldValue: String = ""
) extends Jsonable




case class WebDeviceType(
    webDeviceData: String = "",
    dataCollectionResponseCd: String = "",
    webSessionBrowserTimeZone: String = "",
    webSessionClientScreenResolution: String = "",
    javascriptOperatingSystem: String = "",
    deviceType: Boolean = false,
    javascriptFonts: String = "",
    javascriptUserAgentString: String = "",
    flashEnabled: Boolean = false,
    flashDetected: Boolean = false,
    javascriptEnabled: Boolean = false,
    cookiesEnabled: Boolean = false,
    browserAcceptLanguage: String = "",
    plugins: String = "",
    systemLocale: String = "",
    adaptorResponseCode: String = "",
    javaScriptEngine: String = "",
    localDatetime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    normalizedDateTime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    userAgentOperatingSystem: String = "",
    userAgentWebBrowser: String = "",
    userAgentFamily: Int = 0,
    userAgentPlatform: Int = 0,
    userAgentBrowserEngine: String = "",
    userLocale: String = "",
    nonce: String = ""
) extends Jsonable

case class UserDefinedComplexTypes(
    dataOfUserDefinedType: String = ""
) extends Jsonable


case class ContactDetailsType(
    addressData1: AddressType = AddressType(),
    addressData2: AddressType = AddressType(),
    addressData3: AddressType = AddressType(),
    email1: String = "",
    email2: String = "",
    email3: String = "",
    phone1: String = "",
    phone2: String = "",
    phone3: String = ""
) extends Jsonable{
  override def toJObj(): JObject = {
    JObject(
      "addressData1" -> addressData1.toJObj(),
      "addressData2" -> addressData2.toJObj(),
      "addressData3" -> addressData3.toJObj(),
      "email1" -> JString(email1),
      "email2" -> JString(email2),
      "email3" -> JString(email3),
      "phone1" -> JString(phone1),
      "phone2" -> JString(phone2),
      "phone3" -> JString(phone3)
    )
  }
}


case class EnrollmentTransactionType(
    authenticationMethod1: String = "",
    authenticationMethod1Detail1: String = "",
    authenticationMethod1Detail2: String = "",
    authenticationMethod1Detail3: String = "",
    authenticationMethod2: String = "",
    authenticationMethod2Detail1: String = "",
    authenticationMethod2Detail2: String = "",
    authenticationMethod2Detail3: String = "",
    contactDetails: ContactDetailsType = ContactDetailsType(),
    identificationMethod1: String = "",
    identificationMethod1Detail1: String = "",
    identificationMethod1Detail2: String = "",
    identificationMethod1Detail3: String = "",
    identificationMethod2: String = "",
    identificationMethod2Detail1: String = "",
    identificationMethod2Detail2: String = "",
    identificationMethod2Detail3: String = "",
    serviceDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
) extends Jsonable


case class ServicesTransactionType(
    isRelationTypePrimary: Boolean = false,
    entityTypeCd: Int = 0,
    reasonCd: String = "",
    relationTypeCd: String = "",
    transactionTypeCd: String = ""
) extends Jsonable


case class OpenBankingDataType(
    apiVersion: String = "",
    invokingSystemID: String = ""
) extends Jsonable


case class P2PPayeeDataType(
    alias: String = "",
    aliasType: Int = 0
) extends Jsonable


case class P2PPayorDataType(
    alias: String = "",
    aliasType: Int = 0
) extends Jsonable

case class ExternalSystemScoreDataType(
    externalSystem1Score: Double = 0.0,
    externalSystem1ReasonCode: String = "",
    isLowExternalSystem1ScoreMostRisky: Boolean = false,
    externalSystem2Score: Double = 0.0,
    externalSystem2ReasonCode: String = "",
    isLowExternalSystem2ScoreMostRisky: Boolean = false,
    externalSystem3Score: Double = 0.0,
    externalSystem3ReasonCode: String = "",
    isLowExternalSystem3ScoreMostRisky: Boolean = false
) extends Jsonable {
  override def toJObj(): JObject = {
    JObject(
      "externalSystem1Score" -> JDouble(externalSystem1Score),
      "externalSystem1ReasonCode" -> JString(externalSystem1ReasonCode),
      "isLowExternalSystem1ScoreMostRisky" -> JBool(isLowExternalSystem1ScoreMostRisky),
      "externalSystem2Score" -> JDouble(externalSystem2Score),
      "externalSystem2ReasonCode" -> JString(externalSystem2ReasonCode),
      "isLowExternalSystem2ScoreMostRisky" -> JBool(isLowExternalSystem2ScoreMostRisky),
      "externalSystem3Score" -> JDouble(externalSystem3Score),
      "externalSystem3ReasonCode" -> JString(externalSystem3ReasonCode),
      "isLowExternalSystem3ScoreMostRisky" -> JBool(isLowExternalSystem3ScoreMostRisky)
    )
  }
}

case class CardReferenceDataType(
    activationDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    atmLimit: Double = 0.0,
    authenticationCapability: String = "",
    bin: String = "",
    changeDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    expirationDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    iccInd: Boolean = false,
    issuedDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    panForDisplay: String = "",
    posLimit: Double = 0.0,
    type_of: String = "",
    isContactChipCard: Boolean = false,
    isContactlessChipCard: Boolean = false,
    isEMVCard: Boolean = false,
    panCountryCd: String = "",
    status: String = ""
) extends Jsonable {
  override def toJObj(): JObject = {
    JObject(
      "activationDate" -> JString(activationDate),
      "atmLimit" -> JDouble(atmLimit),
      "authenticationCapability" -> JString(authenticationCapability),
      "bin" -> JString(bin),
      "changeDate" -> JString(changeDate),
      "expirationDate" -> JString(expirationDate),
      "iccInd" -> JBool(iccInd),
      "issuedDate" -> JString(issuedDate),
      "panForDisplay" -> JString(panForDisplay),
      "posLimit" -> JDouble(posLimit),
      "type" -> JString(type_of),
      "isContactChipCard" -> JBool(isContactChipCard),
      "isContactlessChipCard" -> JBool(isContactlessChipCard),
      "isEMVCard" -> JBool(isEMVCard),
      "panCountryCd" -> JString(panCountryCd),
      "status" -> JString(status)
    )
  }
  override def toJson(): JValue = this.toJObj().asInstanceOf[JValue]
  override def toJString(): String = compact(render(this.toJson()))
}

case class PosTransactionDataType(
  avsResponseCd: String = "",
  cardholderPresenceIndicatorCd: String = "",
  cardPresenceInd: Boolean = false,
  cashbackAmountAsEntered: Double = 0.0,
  cashbackAmountInNormalizedCurrency: Double = 0.0,
  cashbackInd: Boolean = false,
  contactlessInd: Boolean = false,
  electronicCommerceFlag: String = "",
  secure3DResponseCd: String = ""
) extends Jsonable


case class RemittanceInformationDataType(
    remittanceInfo: String = ""
  ) extends Jsonable 

case class CardTransactionDataType(
    authenticationMethodUsed: String = "",
    authorizationDecisionCd: String = "",
    authorizationResponseCd: String = "",
    feeAmtInNomalizedCurrency: Double = 0.0,
    verificationCd: String = "",
    verificationCdPresence: String = "",
    verificationTypeCd: String = "",
    feeAmountInOriginalCurrency: Double = 0.0,
    feeAmountInRegionNormalizedCurrency: Double = 0.0,
    memberId: String = "",
    messagePurpose: String = "",
    messageType: String = "",
    recurringPaymentIndicator: Int = 0,
    track_1_2_Indicator: String = "",
    track1Name: String = "",
    validatedEMVTransactionCd: String = ""
) extends Jsonable

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
) extends Jsonable 




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
) extends Jsonable {
  override def toJObj(): JObject = {
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
) extends Jsonable

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
    println(CardReferenceDataType().toJString())
    println(BaseTransactionAType().toJString())
    //println(BaseTransactionAType().toJString())
  }
                                
}
