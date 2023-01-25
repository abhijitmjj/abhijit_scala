import utils.EventReader
// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("parse should return the correct map") {
    val testCases = Map(
    "httpacceptencoding=gzip, br,client_tz=-18000000" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set(""), "client_tz" -> Set("-18000000")),
    "httpacceptencoding=gzip, br,client_tz=-18000000,br={hello,world}" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set("", "{hello,world}"), "client_tz" -> Set("-18000000")),
    "httpacceptencoding=gzip, br,client_tz=-18000000,br={hello,world},br2={hello,world}" -> Map("httpacceptencoding" -> Set("gzip"), "br" -> Set("", "{hello,world}"), "client_tz" -> Set("-18000000"), "br2" -> Set("{hello,world}")),
    )
    testCases.foreach { case (input, expectedOutput) =>
      val output = EventReader.parse(input)
      assertEquals(output, expectedOutput)
    }
  }
}
