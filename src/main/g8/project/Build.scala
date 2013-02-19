import sbt._
import Keys._

object BuildSettings {

  val buildName         = "$name;format="normalize"$"
  val buildOrganization = "$organization$"
  val buildVersion      = "$version$"
  val buildScalaVersion = "2.10.0"

  val buildSettings = Defaults.defaultSettings ++ Seq (
      name         := buildName,
      organization := buildOrganization,
      version      := buildVersion,
      scalaVersion := buildScalaVersion,

      // Compiler
      //libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _),

      // ScalaTest
      //libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
      
      scalacOptions ++= Seq(
        "-feature",                      // Enable language feature warnings
        "-deprecation",                  // Enable detailed deprecation warnings 
        "-unchecked"//,                    // Enable detailed unchecked warnings 
        //"-language:experimental.macros", // Enable scala macros
        //"-language:implicitConversions", // Remove feature warning about implicit methods
        //"-language:postfixOps"           // Remove feature warning about postfix operators
      )
  )
}

object $name;format="Camel"$Build extends Build {

  import BuildSettings._

  lazy val $name;format="camel"$ = Project(
    id = buildName,
    base = file("."),
    settings = buildSettings 
  )

}
