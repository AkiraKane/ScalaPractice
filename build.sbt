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

lazy val Dijkstra = (project in file("Dijkstra")).
  settings(commonSettings: _*).
  settings(
    name := "Dijkstra"
  )

lazy val p1 = (project in file("01/p1")).
  settings(commonSettings: _*).
  settings(
    name := "p1"
  )

lazy val p2 = (project in file("01/p2")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p2"
  )

lazy val p3 = (project in file("01/p3")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p3"
  )

lazy val p4 = (project in file("01/p4")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p4"
  )

lazy val p5 = (project in file("01/p5")).
  settings(commonSettings: _*).
  settings(
    name := "p5"
  )

lazy val p6 = (project in file("01/p6")).
  settings(commonSettings: _*).
  settings(
    name := "p6"
  )

lazy val p7 = (project in file("01/p7")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p7"
  )

lazy val p8 = (project in file("01/p8")).
  settings(commonSettings: _*).
  settings(
    name := "p8"
  )

lazy val p9 = (project in file("01/p9")).
  settings(commonSettings: _*).
  settings(
    name := "p9"
  )

lazy val p10 = (project in file("10/p10")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p10"
  )

lazy val p11 = (project in file("10/p11")).
  settings(commonSettings: _*).
  settings(
    name := "p11"
  )

lazy val p12 = (project in file("10/p12")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p12",
    libraryDependencies ++= scalaz
  )

lazy val p13 = (project in file("10/p13")).
  settings(commonSettings: _*).
  settings(
    name := "p13"
  )

lazy val p14 = (project in file("10/p14")).
  settings(commonSettings: _*).
  settings(
    name := "p14"
  )

lazy val p15 = (project in file("10/p15")).
  settings(commonSettings: _*).
  settings(
    name := "p15"
  )

lazy val p16 = (project in file("10/p16")).
  settings(commonSettings: _*).
  settings(
    name := "p16"
  )

lazy val p17 = (project in file("10/p17")).
  settings(commonSettings: _*).
  settings(
    name := "p17"
  )

lazy val p18 = (project in file("10/p18")).
  settings(commonSettings: _*).
  settings(
    name := "p18"
  )

lazy val p19 = (project in file("10/p19")).
  settings(commonSettings: _*).
  settings(
    name := "p19"
  )

lazy val p20 = (project in file("20/p20")).
  settings(commonSettings: _*).
  settings(
    name := "p20"
  )

lazy val p21 = (project in file("20/p21")).
  settings(commonSettings: _*).
  settings(
    name := "p21"
  )

lazy val p22 = (project in file("20/p22")).
  settings(commonSettings: _*).
  settings(
    name := "p22"
  )

lazy val p23 = (project in file("20/p23")).
  settings(commonSettings: _*).
  settings(
    name := "p23"
  )

lazy val p24 = (project in file("20/p24")).
  settings(commonSettings: _*).
  settings(
    name := "p24"
  )

lazy val p25 = (project in file("20/p25")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p25"
  )

lazy val p26 = (project in file("20/p26")).
  settings(commonSettings: _*).
  settings(
    name := "p26"
  )

lazy val p27 = (project in file("20/p27")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p27"
  )

lazy val p28 = (project in file("20/p28")).
  settings(commonSettings: _*).
  settings(
    name := "p28"
  )

lazy val p29 = (project in file("20/p29")).
  settings(commonSettings: _*).
  settings(
    name := "p29"
  )

lazy val p30 = (project in file("30/p30")).
  settings(commonSettings: _*).
  settings(
    name := "p30"
  )

lazy val p31 = (project in file("30/p31")).
  settings(commonSettings: _*).
  settings(
    name := "p31"
  )

lazy val p32 = (project in file("30/p32")).
  settings(commonSettings: _*).
  settings(
    name := "p32"
  )

lazy val p33 = (project in file("30/p33")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p33"
  )

lazy val p34 = (project in file("30/p34")).
  settings(commonSettings: _*).
  settings(
    name := "p34"
  )

lazy val p35 = (project in file("30/p35")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p35"
  )

lazy val p36 = (project in file("30/p36")).
  settings(commonSettings: _*).
  settings(
    name := "p36"
  )

lazy val p37 = (project in file("30/p37")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p37"
  )

lazy val p38 = (project in file("30/p38")).
  settings(commonSettings: _*).
  settings(
    name := "p38"
  )

lazy val p39 = (project in file("30/p39")).
  settings(commonSettings: _*).
  settings(
    name := "p39"
  )

lazy val p40 = (project in file("40/p40")).
  settings(commonSettings: _*).
  settings(
    name := "p40"
  )

lazy val p41 = (project in file("40/p41")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p41"
  )

lazy val p42 = (project in file("40/p42")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p42"
  )

lazy val p43 = (project in file("40/p43")).
  settings(commonSettings: _*).
  settings(
    name := "p43"
  )

lazy val p44 = (project in file("40/p44")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p44"
  )

lazy val p45 = (project in file("40/p45")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p45"
  )

lazy val p46 = (project in file("40/p46")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p46"
  )

lazy val p47 = (project in file("40/p47")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p47"
  )

lazy val p48 = (project in file("40/p48")).
  settings(commonSettings: _*).
  settings(
    name := "p48"
  )

lazy val p49 = (project in file("40/p49")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p49"
  )

lazy val p50 = (project in file("50/p50")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p50"
  )

lazy val p51 = (project in file("50/p51")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p51"
  )

lazy val p52 = (project in file("50/p52")).
  settings(commonSettings: _*).
  settings(
    name := "p52"
  )

lazy val p53 = (project in file("50/p53")).
  settings(commonSettings: _*).
  settings(
    name := "p53"
  )

lazy val p54 = (project in file("50/p54")).
  settings(commonSettings: _*).
  settings(
    name := "p54"
  )

lazy val p55 = (project in file("50/p55")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p55"
  )

lazy val p56 = (project in file("50/p56")).
  settings(commonSettings: _*).
  settings(
    name := "p56"
  )

lazy val p57 = (project in file("50/p57")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p57"
  )

lazy val p58 = (project in file("50/p58")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p58"
  )

lazy val p59 = (project in file("50/p59")).
  settings(commonSettings: _*).
  settings(
    name := "p59"
  )

lazy val p60 = (project in file("60/p60")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p60"
  )

lazy val p61 = (project in file("60/p61")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p61"
  )

lazy val p62 = (project in file("60/p62")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p62"
  )

lazy val p63 = (project in file("60/p63")).
  settings(commonSettings: _*).
  settings(
    name := "p63"
  )

lazy val p64 = (project in file("60/p64")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p64"
  )

lazy val p65 = (project in file("60/p65")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p65"
  )

lazy val p66 = (project in file("60/p66")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p66"
  )

lazy val p68 = (project in file("60/p68")).
  settings(commonSettings: _*).
  settings(
    name := "p68"
  )

lazy val p69 = (project in file("60/p69")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p69"
  )

lazy val p70 = (project in file("70/p70")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p70"
  )

lazy val p71 = (project in file("70/p71")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p71"
  )

lazy val p72 = (project in file("70/p72")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p72"
  )

lazy val p73 = (project in file("70/p73")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p73"
  )

lazy val p74 = (project in file("70/p74")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p74"
  )

lazy val p75 = (project in file("70/p75")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p75"
  )

lazy val p76 = (project in file("70/p76")).
  settings(commonSettings: _*).
  settings(
    name := "p76"
  )

lazy val p77 = (project in file("70/p77")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p77"
  )

lazy val p78 = (project in file("70/p78")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p78"
  )

lazy val p79 = (project in file("70/p79")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p79"
  )

lazy val p80 = (project in file("80/p80")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p80"
  )

lazy val p81 = (project in file("80/p81")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p81"
  )

lazy val p82 = (project in file("80/p82")).
  settings(commonSettings: _*).
  settings(
    name := "p82"
  )

lazy val p83 = (project in file("80/p83")).
  dependsOn(Dijkstra).
  settings(commonSettings: _*).
  settings(
    name := "p83"
  )

lazy val p84 = (project in file("80/p84")).
  settings(commonSettings: _*).
  settings(
    name := "p84"
  )

lazy val p85 = (project in file("80/p85")).
  settings(commonSettings: _*).
  settings(
    name := "p85"
  )

lazy val p86 = (project in file("80/p86")).
  settings(commonSettings: _*).
  settings(
    name := "p86"
  )

lazy val p87 = (project in file("80/p87")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p87"
  )

lazy val p88 = (project in file("80/p88")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p88"
  )

lazy val p89 = (project in file("80/p89")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p89"
  )

lazy val p90 = (project in file("90/p90")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p90"
  )

lazy val p91 = (project in file("90/p91")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p91"
  )

lazy val p92 = (project in file("90/p92")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p92"
  )

lazy val p93 = (project in file("90/p93")).
  settings(commonSettings: _*).
  settings(
    name := "p93"
  )

lazy val p94 = (project in file("90/p94")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p94"
  )

lazy val p95 = (project in file("90/p95")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p95"
  )

lazy val p96 = (project in file("90/p96")).
  settings(commonSettings: _*).
  settings(
    name := "p96"
  )

lazy val p97 = (project in file("90/p97")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p97"
  )

lazy val p98 = (project in file("90/p98")).
  settings(commonSettings: _*).
  settings(
    name := "p98"
  )

lazy val p99 = (project in file("90/p99")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p99"
  )

lazy val p100 = (project in file("100/p100")).
  settings(commonSettings: _*).
  settings(
    name := "p100"
  )

lazy val p101 = (project in file("100/p101")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p101"
  )

lazy val p102 = (project in file("100/p102")).
  dependsOn(Euler).
  settings(commonSettings: _*).
  settings(
    name := "p102"
  )

lazy val p103 = (project in file("100/p103")).
  settings(commonSettings: _*).
  settings(
    name := "p103"
  )

lazy val p106 = (project in file("100/p106")).
  settings(commonSettings: _*).
  settings(
    name := "p106"
  )
