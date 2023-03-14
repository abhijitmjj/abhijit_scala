## sbt project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.
Generates sample FIS data files: 

```
docker build --pull --rm -f "Dockerfile" -t abhijitscala:latest "."
docker container run -v ${PWD}/src/main/resources/config.json:/app/config.json --rm abhijitscala 10 /app/config.json
```

```
 {
     "$schema": "file:/C:/Users/abhgupta/OneDrive%20-%20Nice%20Systems%20Ltd/Documents/FIS/mapper.json",
     "amount": {
         "normalizedOriginalAmount": 294704.97,
         "originalCurrencyCd": "USD"
     },
     "baseTransactionA": {
         "channel": "OFFLINE",
         "resendDueToFailureInd": "FALSE",
         "sourceCd": "WireSystem_001",
         "transactionLocalDateTime": "2022-05-27T12:00:00.000Z",
         "transactionNormalizedDateTime": "2022-05-27T11:25:56.739Z"
     },
     "baseTransactionB": {"accountKey": "466.DP.2400398"},
     "baseTransactionC": {
         "transactionKey": 202205270062170,
         "transactionType": "International"
     },
     "monetaryTransactionB": {
         "fundsDirectionCd": "O",
         "payeeDataAccountNumber": 2000042928245,
         "transactionId": 202205270062170
     },
     "partyReference": {"partyType": "Individual"},
     "title": "detectionRequestWire",
     "transferTransaction": {
         "executionDate": "2022-05-27T12:00:00.000Z",
         "isAddEditPayee": "FALSE",
         "isStandingOrder": "FALSE",
         "paymentSpeedCd": 1
     },
     "trxMonitoredAccountData": {"accountNumber": 2400398},
     "trxPayeeAccountData": {
         "accountNumber": 2000042928245,
         "fiName": "WELLS FARGO BANK, NA               ",
         "routingNumber": 121000248,
         "routingType": "ABA"
     },
     "trxPayeePartyData": {
         "addressData": {
             "addressLine1": "8742 LUCENT BLVD STE 300",
             "countryCd": "US",
             "state": "HIGHLANDS RANCH CO "
         },
         "lastName": "SPECIALIZED",
         "name": "SPECIALIZED LOAN SERVICING"
     },
     "wirePayee": {
         "originatorToBeneficiaryInfo": "PIF 1025664765 RICHARD J MERCURIO, *3772 SWALLOW AY NE, MARIETTA, GA 30*066   SENT BY MARY 770 284 1111*",
         "wirePayeeAddress": "8742 LUCENT BLVD STE 300 HIGHLANDS RANCH CO 80129 "
     }
 }
```
(xml_currencyCodesISO \\ "CcyNtry").foldLeft(Map.empty[String, Set[String]]) {(result, s) => 
    val keyValue = ((s\"CcyNbr").text.toLowerCase(), (s\"Ccy").text)
    val key = keyValue(1).trim
    val value = keyValue(0).trim
    result.updated(key, result.getOrElse(key, Set.empty[String] + value))}
For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).
