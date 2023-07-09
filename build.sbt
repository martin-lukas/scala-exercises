val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-exercises",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    Test / scalaSource := baseDirectory.value / "src" / "main" / "scala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16"
  )
