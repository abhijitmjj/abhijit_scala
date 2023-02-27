package utils
// class for reading XML files
import scala.xml._
import scala.util.{Try, Success, Failure}
import java.util.HashMap


class XMLFileReader {
    def readXMLFile(): Unit = {
        Try(XML.loadFile("src/main/resources/Events.xml")) match {
            case Success(xml) => println(xml)
            case Failure(e) => println(e)
        }
    }

    // open xml file from resources
    def readXMLFileFromResources(): Unit = {
        
        val xml = XML.load(getClass.getResourceAsStream("/Events.xml"))
        //println(xml)
        val xml_countryCodesISO = XML.load(getClass.getResourceAsStream("/CountryCodesISO.xml"))
        //println(xml_countryCodesISO)
        // read country codes from xml, stored in code attribute and drop the optional (the) from the country name at end of string
        val countryCodes = (xml_countryCodesISO \\ "country").map(x => (x.text.toLowerCase(), x.attribute("code").get.text.toUpperCase())).toMap
        //val countryCodes = (xml_countryCodesISO \\ "country").map(_.text)
        //println(countryCodes)
        val xml_currencyCodesISO = XML.load(getClass.getResourceAsStream("/CurrencyCodesISO.xml"))
        // get child element attribute of CcyNtry
        // remove (the) from country name if it exists
        //val currencyCd = (xml_currencyCodesISO \\ "CcyNtry").map(x => ((x\"CtryNm").text.toLowerCase().replaceFirst("(the)", ""), (x\"Ccy").text))
        val currencyCd = (xml_currencyCodesISO \\ "CcyNtry").map(x => ((x\"CtryNm").text.toLowerCase(), (x\"Ccy").text))
        val currencyMap = currencyCd.toMap

        
        //println(currencyMap)
        // join currencyMap and countryCodes to get country code and currency code if country is present in both maps
        val countryCurrency = countryCodes.map(x => (x._2, currencyMap.getOrElse(x._1, "NA"))).toMap
        //println(countryCurrency)  
    }

  
}

object XMLFileReader {
    def main(args: Array[String]): Unit = {
        println(readCountryCurrencyCodes())
        (new XMLFileReader()).readXMLFile()
        (new XMLFileReader()).readXMLFileFromResources()
    }
    def readCountryCurrencyCodes(): Map[String, String] = {

        val xml_countryCodesISO = XML.load(getClass.getResourceAsStream("/CountryCodesISO.xml"))
        val countryCodesMap = (xml_countryCodesISO \\ "country").map(x => (x.text.toLowerCase().trim, x.attribute("code").get.text.toUpperCase())).toMap
        val xml_currencyCodesISO = XML.load(getClass.getResourceAsStream("/CurrencyCodesISO.xml"))
        val currencyCdMap = (xml_currencyCodesISO \\ "CcyNtry").map(x => ((x\"CtryNm").text.toLowerCase().replaceFirst("(the)", "").trim, (x\"Ccy").text)).toMap
        val countryCurrencyMap = countryCodesMap.map(x => (x._2, currencyCdMap.getOrElse(x._1, "NA"))).toMap
        countryCurrencyMap
    }

}
//sample xml

