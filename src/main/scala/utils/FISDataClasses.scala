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

case class PartyRelationReferenceType(
    startDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    partyRelationType: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "startDate" -> JString(startDate),
      "partyRelationType" -> JString(partyRelationType)
    )
  }
}


case class AuthenticationType(
    method1: String = "",
    method1Detail1: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "method1" -> JString(method1),
      "method1Detail1" -> JString(method1Detail1)
    )
  }
}


case class BranchReferenceType(
    name: String = "",
    routingNumber: String = "",
    routingType: String = "",
    addressData: AddressType = AddressType()
) {
  def toJObj(): JObject = {
    JObject(
      "name" -> JString(name),
      "routingNumber" -> JString(routingNumber),
      "routingType" -> JString(routingType),
      "addressData" -> addressData.toJObj()
    )
  }
}


case class CalculatedOnlineDeviceIdentifiersType(
    onlineDeviceId: String = "",
    firstSeen: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    lastEvent: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    idConfidence: Double = 0.0
) {
  def toJObj(): JObject = {
    JObject(
      "onlineDeviceId" -> JString(onlineDeviceId),
      "firstSeen" -> JString(firstSeen),
      "lastEvent" -> JString(lastEvent),
      "idConfidence" -> JDouble(idConfidence)
    )
  }
}


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
) {
  def toJObj(): JObject = {
    JObject(
      "acquiringInstitutionId" -> JString(acquiringInstitutionId),
      "addressData" -> addressData.toJObj(),
      "branch" -> JString(branch),
      "cardAcceptorId" -> JString(cardAcceptorId),
      "isTerminalCardCaptureCapable" -> JBool(isTerminalCardCaptureCapable),
      "merchantCategoryCd" -> JString(merchantCategoryCd),
      "nameLocation" -> JString(nameLocation),
      "networkId" -> JString(networkId),
      "onUsInd" -> JBool(onUsInd),
      "ownerName" -> JString(ownerName),
      "panEntryCapability" -> JString(panEntryCapability),
      "panEntryModeCd" -> JString(panEntryModeCd),
      "pinEntryCapability" -> JString(pinEntryCapability),
      "posTerminalAttendanceIndicatorCd" -> JString(posTerminalAttendanceIndicatorCd),
      "terminalCapabilities" -> JString(terminalCapabilities),
      "terminalId" -> JString(terminalId),
      "terminalTypeCd" -> JString(terminalTypeCd),
      "transactionCategoryCd" -> JString(transactionCategoryCd)
    )
  }
}


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
) {
  def toJObj(): JObject = {
    JObject(
      "cs1" -> JString(cs1),
      "cs2" -> JString(cs2),
      "cs3" -> JString(cs3),
      "cs4" -> JString(cs4),
      "cs5" -> JString(cs5),
      "cs6" -> JString(cs6),
      "cs7" -> JString(cs7),
      "cs8" -> JString(cs8),
      "cb1" -> JBool(cb1),
      "cb2" -> JBool(cb2),
      "cb3" -> JBool(cb3),
      "cb4" -> JBool(cb4),
      "cb5" -> JBool(cb5),
      "cb6" -> JBool(cb6),
      "cn1" -> JDouble(cn1),
      "cn2" -> JDouble(cn2),
      "cn3" -> JDouble(cn3),
      "cn4" -> JDouble(cn4),
      "cn5" -> JDouble(cn5),
      "cn6" -> JDouble(cn6),
      "cn7" -> JDouble(cn7),
      "cn8" -> JDouble(cn8),
      "cn9" -> JDouble(cn9),
      "cn10" -> JDouble(cn10)
    )
  }
}


case class DepositMetadataType(
    creditItemCount: Int = 0,
    netNormalizedAmount: Double = 0.0,
    totalCreditCashNormalizedAmount: Double = 0.0,
    totalCreditItemNormalizedAmount: Double = 0.0,
    totalDebitCashNormalizedAmount: Double = 0.0
) {
  def toJObj(): JObject = {
    JObject(
      "creditItemCount" -> JInt(creditItemCount),
      "netNormalizedAmount" -> JDouble(netNormalizedAmount),
      "totalCreditCashNormalizedAmount" -> JDouble(totalCreditCashNormalizedAmount),
      "totalCreditItemNormalizedAmount" -> JDouble(totalCreditItemNormalizedAmount),
      "totalDebitCashNormalizedAmount" -> JDouble(totalDebitCashNormalizedAmount)
    )
  }
}

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
) {
  def toJObj(): JObject = {
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
) {
  def toJObj(): JObject = {
    JObject(
      "positionCd" -> JString(positionCd),
      "typeCd" -> JString(typeCd)
    )
  }
}



case class ManagedPayeeType(
    businessCategory: String = "",
    isManaged: Boolean = false,
    referenceNumber: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "businessCategory" -> JString(businessCategory),
      "isManaged" -> JBool(isManaged),
      "referenceNumber" -> JString(referenceNumber)
    )
  }
}

case class IdentificationType(
    method1: String = "",
    method1Detail1: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "method1" -> JString(method1),
      "method1Detail1" -> JString(method1Detail1)
    )
  }
}



case class OnlineDeviceIdentifiersType(
    onlineDeviceId: String = "",
    firstSeen: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    lastEvent: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    idConfidence: Double = 0.0,
    lookupCount: Int = 0,
    reportCount: Int = 0
) {
  def toJObj(): JObject = {
    JObject(
      "onlineDeviceId" -> JString(onlineDeviceId),
      "firstSeen" -> JString(firstSeen),
      "lastEvent" -> JString(lastEvent),
      "idConfidence" -> JDouble(idConfidence),
      "lookupCount" -> JInt(lookupCount),
      "reportCount" -> JInt(reportCount)
    )
  }
}


case class HTTPHeaderType(
    httpHeaderFields: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "httpHeaderFields" -> JString(httpHeaderFields)
    )
  }
}

case class OnlineSessionType(
    headerUserAgent: String = "",
    ipAddress: String = "",
    loginName: String = "",
    startDateTime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    secondFactorAuthInd: Boolean = false,
    httpHeader: HTTPHeaderType = HTTPHeaderType()
) {
  def toJObj(): JObject = {
    JObject(
      "headerUserAgent" -> JString(headerUserAgent),
      "ipAddress" -> JString(ipAddress),
      "loginName" -> JString(loginName),
      "startDateTime" -> JString(startDateTime),
      "secondFactorAuthInd" -> JBool(secondFactorAuthInd),
      "httpHeader" -> httpHeader.toJObj()
    )
  }
}


case class PhoneSessionType(
    deviceSourceNumber: String = "",
    authenticationChannel: String = "",
    authenticationMethod: String = "",
    sessionDateTime: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    duration: Double = 0.0,
    isInitiatedByCustomer: Boolean = false
) {
  def toJObj(): JObject = {
    JObject(
      "deviceSourceNumber" -> JString(deviceSourceNumber),
      "authenticationChannel" -> JString(authenticationChannel),
      "authenticationMethod" -> JString(authenticationMethod),
      "sessionDateTime" -> JString(sessionDateTime),
      "duration" -> JDouble(duration),
      "isInitiatedByCustomer" -> JBool(isInitiatedByCustomer)
    )
  }
}



case class RejectDataType(
    dataCompletenessLevel: String = "",
    rejectedDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    rejectedTransactionInd: Boolean = false,
    rejectedTypeCd: String = ""
) {
  def toJObj(): JObject = {
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
) {
  def toJObj(): JObject = {
    JObject(
      "cashLetterBankOfFirstDepositItemSequenceNumber" -> JString(cashLetterBankOfFirstDepositItemSequenceNumber),
      "cashLetterBundleID" -> JString(cashLetterBundleID),
      "cashLetterCreationDatetime" -> JString(cashLetterCreationDatetime),
      "cashLetterECEInstitutionItemSequenceNumber" -> JString(cashLetterECEInstitutionItemSequenceNumber),
      "cashLetterECEInstitutionRoutingNumber" -> JString(cashLetterECEInstitutionRoutingNumber),
      "cashLetterID" -> JString(cashLetterID),
      "cashLetterMicrCorrectionIndicatorCode" -> JString(cashLetterMicrCorrectionIndicatorCode),
      "cashLetterMicrValidIndicatorCode" -> JString(cashLetterMicrValidIndicatorCode)
    )
  }
}


case class TrxMICRDataType(
    accountNumber: String = "",
    accountNumberCheckDigit: String = "",
    instrumentNumber: String = "",
    routingNumber: String = "",
    routingNumberCheckDigit: String = "",
    micrAuxiliaryOnUs: String = "",
    micrExternalProcessingCode: Boolean = false,
    instrumentAmount: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "accountNumber" -> JString(accountNumber),
      "accountNumberCheckDigit" -> JString(accountNumberCheckDigit),
      "instrumentNumber" -> JString(instrumentNumber),
      "routingNumber" -> JString(routingNumber),
      "routingNumberCheckDigit" -> JString(routingNumberCheckDigit),
      "micrAuxiliaryOnUs" -> JString(micrAuxiliaryOnUs),
      "micrExternalProcessingCode" -> JBool(micrExternalProcessingCode),
      "instrumentAmount" -> JString(instrumentAmount)
    )
  }
}




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
) {
  def toJObj(): JObject = {
    JObject(
      "mobileDeviceData" -> JString(mobileDeviceData),
      "cellId" -> JString(cellId),
      "imei" -> JString(imei),
      "imsi" -> JString(imsi),
      "deviceName" -> JString(deviceName),
      "isRootedJailbroken" -> JBool(isRootedJailbroken),
      "gpsCoordinates" -> JString(gpsCoordinates),
      "timeZone" -> JString(timeZone),
      "deviceBrand" -> JString(deviceBrand),
      "osVersion" -> JString(osVersion),
      "phoneNumber" -> JString(phoneNumber),
      "deviceModel" -> JString(deviceModel),
      "os" -> JString(os),
      "screenResolution" -> JString(screenResolution),
      "appVersion" -> JString(appVersion),
      "malwareList" -> JString(malwareList),
      "malwareReasonCode" -> JString(malwareReasonCode),
      "connectionTypeCode" -> JString(connectionTypeCode),
      "rootedJailbrokenReasonCode" -> JString(rootedJailbrokenReasonCode),
      "cellTowerCoordinates" -> JString(cellTowerCoordinates),
      "simISOCountryCode" -> JString(simISOCountryCode),
      "ituMobileCountryCode" -> JInt(ituMobileCountryCode),
      "ituMobileNetworkCode" -> JInt(ituMobileNetworkCode),
      "networkName" -> JString(networkName),
      "androidId" -> JString(androidId),
      "appleIdentifierForVendor" -> JString(appleIdentifierForVendor),
      "appleAdvertisingId" -> JString(appleAdvertisingId),
      "installedAppList" -> JString(installedAppList)
    )
  }
}


case class TrxReturnDataType(
    endorsementDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    isReturnRedepositEligible: Boolean = false,
    originalTrxId: String = "",
    returnCount: Int = 0,
    returnReasonCdStandardCd: String = "",
    returnReasonCode: String = "",
    returnReasonRemarks: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "endorsementDate" -> JString(endorsementDate),
      "isReturnRedepositEligible" -> JBool(isReturnRedepositEligible),
      "originalTrxId" -> JString(originalTrxId),
      "returnCount" -> JInt(returnCount),
      "returnReasonCdStandardCd" -> JString(returnReasonCdStandardCd),
      "returnReasonCode" -> JString(returnReasonCode),
      "returnReasonRemarks" -> JString(returnReasonRemarks)
    )
  }
}



case class UserReferenceType(
    birthDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    name: String = "",
    onlineServiceJoinDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    addressData: AddressType = AddressType(),
    contactReference: ContactReferenceType = ContactReferenceType(),
    referenceUpdateDates: ReferenceUpdateDatesType = ReferenceUpdateDatesType()
) {
  def toJObj(): JObject = {
    JObject(
      "birthDate" -> JString(birthDate),
      "name" -> JString(name),
      "onlineServiceJoinDate" -> JString(onlineServiceJoinDate),
      "addressData" -> addressData.toJObj(),
      "contactReference" -> contactReference.toJObj(),
      "referenceUpdateDates" -> referenceUpdateDates.toJObj()
    )
  }
}


case class VersionDataType(
    transactionActionCd: String = "",
    transactionStatusCd: String = "",
    transactionVersionDescription: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "transactionActionCd" -> JString(transactionActionCd),
      "transactionStatusCd" -> JString(transactionStatusCd),
      "transactionVersionDescription" -> JString(transactionVersionDescription)
    )
  }
}


case class TrxServicesChangeDataType(
    defaultUDMUpdateInd: Boolean = false,
    entityStaticData: String = "",
    newValue: String = "",
    oldValue: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "defaultUDMUpdateInd" -> JBool(defaultUDMUpdateInd),
      "entityStaticData" -> JString(entityStaticData),
      "newValue" -> JString(newValue),
      "oldValue" -> JString(oldValue)
    )
  }
}




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
) {
  def toJObj(): JObject = {
    JObject(
      "webDeviceData" -> JString(webDeviceData),
      "dataCollectionResponseCd" -> JString(dataCollectionResponseCd),
      "webSessionBrowserTimeZone" -> JString(webSessionBrowserTimeZone),
      "webSessionClientScreenResolution" -> JString(webSessionClientScreenResolution),
      "javascriptOperatingSystem" -> JString(javascriptOperatingSystem),
      "deviceType" -> JBool(deviceType),
      "javascriptFonts" -> JString(javascriptFonts),
      "javascriptUserAgentString" -> JString(javascriptUserAgentString),
      "flashEnabled" -> JBool(flashEnabled),
      "flashDetected" -> JBool(flashDetected),
      "javascriptEnabled" -> JBool(javascriptEnabled),
      "cookiesEnabled" -> JBool(cookiesEnabled),
      "browserAcceptLanguage" -> JString(browserAcceptLanguage),
      "plugins" -> JString(plugins),
      "systemLocale" -> JString(systemLocale),
      "adaptorResponseCode" -> JString(adaptorResponseCode),
      "javaScriptEngine" -> JString(javaScriptEngine),
      "localDatetime" -> JString(localDatetime),
      "normalizedDateTime" -> JString(normalizedDateTime),
      "userAgentOperatingSystem" -> JString(userAgentOperatingSystem),
      "userAgentWebBrowser" -> JString(userAgentWebBrowser),
      "userAgentFamily" -> JInt(userAgentFamily),
      "userAgentPlatform" -> JInt(userAgentPlatform),
      "userAgentBrowserEngine" -> JString(userAgentBrowserEngine),
      "userLocale" -> JString(userLocale),
      "nonce" -> JString(nonce)
    )
  }
}

case class UserDefinedComplexTypes(
    dataOfUserDefinedType: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "dataOfUserDefinedType" -> JString(dataOfUserDefinedType)
    )
  }
}


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
) {
  def toJObj(): JObject = {
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
) {
  def toJObj(): JObject = {
    JObject(
      "authenticationMethod1" -> JString(authenticationMethod1),
      "authenticationMethod1Detail1" -> JString(authenticationMethod1Detail1),
      "authenticationMethod1Detail2" -> JString(authenticationMethod1Detail2),
      "authenticationMethod1Detail3" -> JString(authenticationMethod1Detail3),
      "authenticationMethod2" -> JString(authenticationMethod2),
      "authenticationMethod2Detail1" -> JString(authenticationMethod2Detail1),
      "authenticationMethod2Detail2" -> JString(authenticationMethod2Detail2),
      "authenticationMethod2Detail3" -> JString(authenticationMethod2Detail3),
      "contactDetails" -> contactDetails.toJObj(),
      "identificationMethod1" -> JString(identificationMethod1),
      "identificationMethod1Detail1" -> JString(identificationMethod1Detail1),
      "identificationMethod1Detail2" -> JString(identificationMethod1Detail2),
      "identificationMethod1Detail3" -> JString(identificationMethod1Detail3),
      "identificationMethod2" -> JString(identificationMethod2),
      "identificationMethod2Detail1" -> JString(identificationMethod2Detail1),
      "identificationMethod2Detail2" -> JString(identificationMethod2Detail2),
      "identificationMethod2Detail3" -> JString(identificationMethod2Detail3),
      "serviceDate" -> JString(serviceDate)
    )
  }
}


case class ServicesTransactionType(
    isRelationTypePrimary: Boolean = false,
    entityTypeCd: Int = 0,
    reasonCd: String = "",
    relationTypeCd: String = "",
    transactionTypeCd: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "isRelationTypePrimary" -> JBool(isRelationTypePrimary),
      "entityTypeCd" -> JInt(entityTypeCd),
      "reasonCd" -> JString(reasonCd),
      "relationTypeCd" -> JString(relationTypeCd),
      "transactionTypeCd" -> JString(transactionTypeCd)
    )
  }
}


case class OpenBankingDataType(
    apiVersion: String = "",
    invokingSystemID: String = ""
) {
  def toJObj(): JObject = {
    JObject(
      "apiVersion" -> JString(apiVersion),
      "invokingSystemID" -> JString(invokingSystemID)
    )
  }
}


case class P2PPayeeDataType(
    alias: String = "",
    aliasType: Int = 0
) {
  def toJObj(): JObject = {
    JObject(
      "alias" -> JString(alias),
      "aliasType" -> JInt(aliasType)
    )
  }
}


case class P2PPayorDataType(
    alias: String = "",
    aliasType: Int = 0
) {
  def toJObj(): JObject = {
    JObject(
      "alias" -> JString(alias),
      "aliasType" -> JInt(aliasType)
    )
  }
}

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
) {
  def toJObj(): JObject = {
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
) {
  def toJObj(): JObject = {
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
) {
  def toJObj(): JObject = {
    JObject(
      "avsResponseCd" -> JString(avsResponseCd),
      "cardholderPresenceIndicatorCd" -> JString(cardholderPresenceIndicatorCd),
      "cardPresenceInd" -> JBool(cardPresenceInd),
      "cashbackAmountAsEntered" -> JDouble(cashbackAmountAsEntered),
      "cashbackAmountInNormalizedCurrency" -> JDouble(cashbackAmountInNormalizedCurrency),
      "cashbackInd" -> JBool(cashbackInd),
      "contactlessInd" -> JBool(contactlessInd),
      "electronicCommerceFlag" -> JString(electronicCommerceFlag),
      "secure3DResponseCd" -> JString(secure3DResponseCd)
    )
  } 
}


case class RemittanceInformationDataType(
    remittanceInfo: String = ""
  ) {
    def toJObj(): JObject = {
        JObject(
            "remittanceInfo" -> JString(remittanceInfo)
        )
    }
}

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
) {
  def toJObj(): JObject = {
    JObject(
      "authenticationMethodUsed" -> JString(authenticationMethodUsed),
      "authorizationDecisionCd" -> JString(authorizationDecisionCd),
      "authorizationResponseCd" -> JString(authorizationResponseCd),
      "feeAmtInNomalizedCurrency" -> JDouble(feeAmtInNomalizedCurrency),
      "verificationCd" -> JString(verificationCd),
      "verificationCdPresence" -> JString(verificationCdPresence),
      "verificationTypeCd" -> JString(verificationTypeCd),
      "feeAmountInOriginalCurrency" -> JDouble(feeAmountInOriginalCurrency),
      "feeAmountInRegionNormalizedCurrency" -> JDouble(feeAmountInRegionNormalizedCurrency),
      "memberId" -> JString(memberId),
      "messagePurpose" -> JString(messagePurpose),
      "messageType" -> JString(messageType),
      "recurringPaymentIndicator" -> JInt(recurringPaymentIndicator),
      "track_1_2_Indicator" -> JString(track_1_2_Indicator),
      "track1Name" -> JString(track1Name),
      "validatedEMVTransactionCd" -> JString(validatedEMVTransactionCd)
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
