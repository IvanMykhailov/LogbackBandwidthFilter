name := "LogbackBandwidthFilter"

organization := "ivan.mykhailov"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"


libraryDependencies ++= Seq(
  "net.logstash.logback" % "logstash-logback-encoder" % "4.2",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)


scalacOptions ++= Seq(
    "-deprecation"
  , "-feature"
  , "-unchecked"
  , "-Xlint"
  , "-Yno-adapted-args"
  , "-Ywarn-dead-code"
  , "-language:postfixOps"
  , "-language:implicitConversions"
)

net.virtualvoid.sbt.graph.Plugin.graphSettings