val scalaz = Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.0",
  "org.scalaz" %% "scalaz-effect" % "7.2.0",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.0" % "test"
)

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

lazy val p7 = (project in file("p7")).
  settings(commonSettings: _*).
  settings(
    name := "p7"
  )

lazy val p8 = (project in file("p8")).
  settings(commonSettings: _*).
  settings(
    name := "p8"
  )

lazy val p9 = (project in file("p9")).
  settings(commonSettings: _*).
  settings(
    name := "p9"
  )

lazy val p10 = (project in file("p10")).
  settings(commonSettings: _*).
  settings(
    name := "p10"
  )

lazy val p11 = (project in file("p11")).
  settings(commonSettings: _*).
  settings(
    name := "p11"
  )

lazy val p12 = (project in file("p12")).
  settings(commonSettings: _*).
  settings(
    name := "p12",
    scalaVersion := "2.11.7",
    libraryDependencies ++= scalaz
  )

lazy val p13 = (project in file("p13")).
  settings(commonSettings: _*).
  settings(
    name := "p13",
    scalaVersion := "2.11.7"
  )

lazy val p14 = (project in file("p14")).
  settings(commonSettings: _*).
  settings(
    name := "p14",
    scalaVersion := "2.11.7"
  )

lazy val p15 = (project in file("p15")).
  settings(commonSettings: _*).
  settings(
    name := "p15",
    scalaVersion := "2.11.7"
  )
