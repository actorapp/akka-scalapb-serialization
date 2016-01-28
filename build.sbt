import com.trueaccord.scalapb.{ScalaPbPlugin => PB}
import sbtrelease._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys._

scalaVersion := "2.11.7"

name := "akka-scalapb-serialization"
organization := "im.actor"
organizationName := "Actor LLC"
organizationHomepage := Some(new URL("https://actor.im/"))

PB.protobufSettings

PB.runProtoc in PB.protobufConfig := (args => com.github.os72.protocjar.Protoc.runProtoc("-v300" +: args.toArray))

val akkaV = "2.4.2-RC1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.trueaccord.scalapb" %% "scalapb-runtime" % "0.5.21",
  "com.github.ben-manes.caffeine" % "caffeine" % "1.2.0"
)

dependencyOverrides ~= { overrides => 
  overrides + "com.google.protobuf" % "protobuf-java" % "3.0.0-beta-2" 
}

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
  pushChanges
)
