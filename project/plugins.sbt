addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.19")

libraryDependencies ++= Seq("com.github.os72" % "protoc-jar" % "3.0.0-b2")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.5.1")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0")