val scala3Version = "3.2.2"
enablePlugins(JavaAppPackaging)
lazy val root = project
  .in(file("."))
  .settings(
    name := "abhijit_scala",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M7" % Test,
    libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.6",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "4.1.0-M2",
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.1.0-M2",
    libraryDependencies += "org.json4s" %% "json4s-ast" % "4.1.0-M2",
    libraryDependencies += "org.json4s" %% "json4s-core" % "4.1.0-M2",
    libraryDependencies += "com.github.mifmif" % "generex" % "1.0.2",
  )
