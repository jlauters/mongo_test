name := "mongo-test"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.mongodb" %% "casbah" % "2.7.3",
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "org.scalaj" % "scalaj-http_2.11" % "2.3.0"
)

// for stable releases
resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"

// for snapshot releases
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/releases/snapshots"

scalacOptions += "-deprecation"
