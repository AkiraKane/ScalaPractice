val scalaz = "org.scalaz" %% "scalaz-core" % "7.2.0"

lazy val commonSettings = Seq(
  organization := "com.daystrom-data-concepts",
  version := "33",
  scalaVersion := "2.11.4"
)

lazy val p1 = (project in file("p1")).
  settings(commonSettings: _*).
  settings(
    name := "p1",
    libraryDependencies += scalaz
  )
