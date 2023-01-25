package utils
// class for reading XML files
import scala.xml._
import scala.util.{Try, Success, Failure}


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
        println(xml)
    }

  
}

object XMLFileReader {
    def main(args: Array[String]): Unit = {
        (new XMLFileReader()).readXMLFile()
        (new XMLFileReader()).readXMLFileFromResources()
    }
}
//sample xml

