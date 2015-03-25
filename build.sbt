name := "LogbackBandwidthFilter"

organization := "ivan.mykhailov"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  
)

//Tests
libraryDependencies ++= Seq(
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

seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

net.virtualvoid.sbt.graph.Plugin.graphSettings