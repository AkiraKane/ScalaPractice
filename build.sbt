val scalaz = "org.scalaz" %% "scalaz-core" % "7.2.0"

lazy val commonSettings = Seq(
  organization := "com.daystrom-data-concepts",
  version := "33",
  scalaVersion := "2.11.4"
)

lazy val p1 = (project in file("p1")).
  settings(commonSettings: _*).
  settings(
    name := "p1"
  )

lazy val p2 = (project in file("p2")).
  settings(commonSettings: _*).
  settings(
    name := "p2"
  )

lazy val p3 = (project in file("p3")).
  settings(commonSettings: _*).
  settings(
    name := "p3"
  )

lazy val p4 = (project in file("p4")).
  settings(commonSettings: _*).
  settings(
    name := "p4"
  )

lazy val p5 = (project in file("p5")).
  settings(commonSettings: _*).
  settings(
    name := "p5"
  )

lazy val p6 = (project in file("p6")).
  settings(commonSettings: _*).
  settings(
    name := "p6"
  )
