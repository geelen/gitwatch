import sbt._

class GitwatchProject(info: ProjectInfo) extends DefaultWebProject(info) {
  import BasicScalaProject._

  val specs = "org.scala-tools.testing" % "specs" % "1.6.0"

  val jgitRepo = "jgit-snapshot-repository" at "http://egit.googlecode.com/svn/maven/"

  val jgit = "org.spearce" % "jgit" % "0.5.0"

  val scapps = "scapps" % "scapps" % "0.1"

  val scalaz = "scalaz" % "scalaz" % "4.0-p2"
}
