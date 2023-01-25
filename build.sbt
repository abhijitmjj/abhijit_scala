val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "abhijit_scala",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M7" % Test,
    libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.6",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0",


  )
