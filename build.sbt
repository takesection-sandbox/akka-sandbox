lazy val root = (project in file(".")).
  settings(
    organization := "jp.pigumer",
    name := "akka-sandbox",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.2",
    Dependencies.RootDeps
  )
