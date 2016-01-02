val scalaz = Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.0",
  "org.scalaz" %% "scalaz-effect" % "7.2.0",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.0" % "test"
)

lazy val commonSettings = Seq(
  organization := "com.daystrom-data-concepts",
  version := "33",
  scalaVersion := "2.11.7"
)

lazy val Euler = (project in file("Euler")).
  settings(commonSettings: _*).
  settings(
    name := "Euler"
  )

lazy val p1 = (project in file("p1")).
  settings(commonSettings: _*).
  settings(
    name := "p1"
  )

lazy val p2 = (project in file("p2")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p2"
  )

lazy val p3 = (project in file("p3")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p3"
  )

lazy val p4 = (project in file("p4")).
  dependsOn(Euler).
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
  dependsOn(Euler).
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
  dependsOn(Euler).
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
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p12",
    libraryDependencies ++= scalaz
  )

lazy val p13 = (project in file("p13")).
  settings(commonSettings: _*).
  settings(
    name := "p13"
  )

lazy val p14 = (project in file("p14")).
  settings(commonSettings: _*).
  settings(
    name := "p14"
  )

lazy val p15 = (project in file("p15")).
  settings(commonSettings: _*).
  settings(
    name := "p15"
  )

lazy val p16 = (project in file("p16")).
  settings(commonSettings: _*).
  settings(
    name := "p16"
  )

lazy val p17 = (project in file("p17")).
  settings(commonSettings: _*).
  settings(
    name := "p17"
  )

lazy val p18 = (project in file("p18")).
  settings(commonSettings: _*).
  settings(
    name := "p18"
  )

lazy val p19 = (project in file("p19")).
  settings(commonSettings: _*).
  settings(
    name := "p19"
  )

lazy val p20 = (project in file("p20")).
  settings(commonSettings: _*).
  settings(
    name := "p20"
  )

lazy val p21 = (project in file("p21")).
  settings(commonSettings: _*).
  settings(
    name := "p21"
  )

lazy val p22 = (project in file("p22")).
  settings(commonSettings: _*).
  settings(
    name := "p22"
  )

lazy val p23 = (project in file("p23")).
  settings(commonSettings: _*).
  settings(
    name := "p23"
  )

lazy val p24 = (project in file("p24")).
  settings(commonSettings: _*).
  settings(
    name := "p24"
  )

lazy val p25 = (project in file("p25")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p25"
  )

lazy val p26 = (project in file("p26")).
  settings(commonSettings: _*).
  settings(
    name := "p26"
  )

lazy val p27 = (project in file("p27")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p27"
  )

lazy val p28 = (project in file("p28")).
  settings(commonSettings: _*).
  settings(
    name := "p28"
  )

lazy val p29 = (project in file("p29")).
  settings(commonSettings: _*).
  settings(
    name := "p29"
  )

lazy val p30 = (project in file("p30")).
  settings(commonSettings: _*).
  settings(
    name := "p30"
  )

lazy val p31 = (project in file("p31")).
  settings(commonSettings: _*).
  settings(
    name := "p31"
  )

lazy val p32 = (project in file("p32")).
  settings(commonSettings: _*).
  settings(
    name := "p32"
  )

lazy val p33 = (project in file("p33")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p33"
  )

lazy val p34 = (project in file("p34")).
  settings(commonSettings: _*).
  settings(
    name := "p34"
  )

lazy val p35 = (project in file("p35")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p35"
  )

lazy val p36 = (project in file("p36")).
  settings(commonSettings: _*).
  settings(
    name := "p36"
  )

lazy val p37 = (project in file("p37")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p37"
  )

lazy val p38 = (project in file("p38")).
  settings(commonSettings: _*).
  settings(
    name := "p38"
  )

lazy val p39 = (project in file("p39")).
  settings(commonSettings: _*).
  settings(
    name := "p39"
  )

lazy val p40 = (project in file("p40")).
  settings(commonSettings: _*).
  settings(
    name := "p40"
  )

lazy val p41 = (project in file("p41")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p41"
  )

lazy val p42 = (project in file("p42")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p42"
  )

lazy val p43 = (project in file("p43")).
  settings(commonSettings: _*).
  settings(
    name := "p43"
  )

lazy val p44 = (project in file("p44")).
  settings(commonSettings: _*).
  settings(
    name := "p44"
  )

lazy val p45 = (project in file("p45")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p45"
  )

lazy val p46 = (project in file("p46")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p46"
  )

lazy val p47 = (project in file("p47")).
  settings(commonSettings: _*).
  settings(
    name := "p47"
  )

lazy val p48 = (project in file("p48")).
  settings(commonSettings: _*).
  settings(
    name := "p48"
  )

lazy val p49 = (project in file("p49")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p49"
  )

lazy val p50 = (project in file("p50")).
  settings(commonSettings: _*).
  settings(
    name := "p50"
  )

lazy val p51 = (project in file("p51")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p51"
  )

lazy val p52 = (project in file("p52")).
  settings(commonSettings: _*).
  settings(
    name := "p52"
  )

lazy val p53 = (project in file("p53")).
  settings(commonSettings: _*).
  settings(
    name := "p53"
  )

lazy val p54 = (project in file("p54")).
  settings(commonSettings: _*).
  settings(
    name := "p54"
  )

lazy val p55 = (project in file("p55")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p55"
  )

lazy val p56 = (project in file("p56")).
  settings(commonSettings: _*).
  settings(
    name := "p56"
  )

lazy val p57 = (project in file("p57")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p57"
  )

lazy val p58 = (project in file("p58")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p58"
  )

lazy val p59 = (project in file("p59")).
  settings(commonSettings: _*).
  settings(
    name := "p59"
  )

lazy val p60 = (project in file("p60")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p60"
  )

lazy val p61 = (project in file("p61")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p61"
  )

lazy val p62 = (project in file("p62")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p62"
  )

lazy val p63 = (project in file("p63")).
  settings(commonSettings: _*).
  settings(
    name := "p63"
  )
