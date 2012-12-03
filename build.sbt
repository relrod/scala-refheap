name := "scala-refheap"

version := "1.0.0"

scalaVersion := "2.9.2"

scalacOptions ++= Seq(
  "-deprecation",
  "-Xexperimental"
)

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.9.4",
  "net.databinder.dispatch" %% "json4s-jackson" % "0.9.4"
)

