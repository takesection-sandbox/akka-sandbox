import sbt.Keys._
import sbt._

object Dependencies {

  val AkkStreamVersion = "2.5.1"

  val RootDeps = Seq(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % AkkStreamVersion,
      "com.typesafe.akka" %% "akka-slf4j" % AkkStreamVersion,
      "ch.qos.logback" % "logback-classic" % "1.1.3",

      "com.typesafe.akka" %% "akka-testkit" % AkkStreamVersion % Test,

      "org.specs2" %% "specs2-core" % "3.8.6" % Test,
      "org.specs2" %% "specs2-mock" % "3.8.6" % Test,
      "org.specs2" %% "specs2-junit" % "3.8.6" % Test
    )
  )
}
