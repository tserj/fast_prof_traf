name := """fast_prof_traf"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  json,
  evolutions,
  javaWs,
  "commons-dbutils" % "commons-dbutils" % "1.6",
  "mysql" % "mysql-connector-java" % "5.1.35",
  "junit" % "junit" % "4.12" % Test
)

pipelineStages := Seq(rjs, digest, gzip)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"