package org.prohax.gitwatch

object Main {
  def main(args: Array[String]) {
    args match {
      case Array() => println("Usage: run GIT_DIR [OUTPUT_FILE]")
      case Array(git) => println(GitProHax.run(git,"refs/heads/master"))
    }
  }
}
