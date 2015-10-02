addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.14")

libraryDependencies ++= Seq("com.github.os72" % "protoc-jar" % "3.0.0-a3")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.5.1")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0")