package utils
import scala.util.control.NonLocalReturns.*
class EventReader {
  private val SEP = ','
  private val EQUALS = '='

  private def isBalanced(s: String): Boolean = returning {
    val stack = scala.collection.mutable.Stack[Char]()
    for (char <- s) {
      if (char == '{' || char == '[' || char == '(') {
        stack.push(char)
      } else if (char == '}' || char == ']' || char == ')') {
        if (stack.isEmpty ||
            (stack.top == '{' && char != '}') ||
            (stack.top == '[' && char != ']') ||
            (stack.top == '(' && char != ')')) {
                throwReturn(false)
        }
        stack.pop()
      }
    }
    stack.isEmpty
  }

  def parse(oldText: String): Map[String, Set[String]] = {
    var moddedString = ""
    for (char <- oldText) {
      if (SEP == char && !isBalanced(moddedString)) {
        moddedString += "DUMMY"
      } else {
        moddedString += char
      }
    }
    // val result = collection.mutable.Map[String, Set[String]]().withDefaultValue(Set.empty[String])
    // for (s <- moddedString.split(",")) {
    //     val keyValue = s.split("=", 2)
    //     result(keyValue(0).trim) += (if (keyValue.length > 1) keyValue(1).replace("DUMMY", ",") else "")
    // }
    // result.toMap
    moddedString.split(",").foldLeft(Map.empty[String, Set[String]]) { (result, s) =>
        val keyValue = s.split("=", 2)
        val key = keyValue(0).trim
        val value = if (keyValue.length > 1) keyValue(1).replace("DUMMY", ",") else ""
        result.updated(key, result.getOrElse(key, Set.empty[String]) + value)
    }
  }
}
object EventReader {
  def parse(oldText: String): Map[String, Set[String]] = {
    new EventReader().parse(oldText)
  }
}
@main implicit def hello: Unit =
    val testCases = Map(
        "httpacceptencoding=gzip, br,client_tz=-18000000" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set(""), "client_tz" -> Set("-18000000")),
        "httpacceptencoding=gzip, br,client_tz=-18000000,br={hello,world}" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set("", "{hello,world}"), "client_tz" -> Set("-18000000")),
        "httpacceptencoding=gzip, br,client_tz=-18000000,br={hello,world},br2={hello,world}" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set("", "{hello,world}"), "client_tz" -> Set("-18000000"), "br2" -> Set("{hello,world}")),
    )
    testCases.foreach { case (input, expectedOutput) =>
        val output = EventReader.parse(input)
        println(output)
        println("Expected: "+expectedOutput)
        println(expectedOutput==output)
    }


