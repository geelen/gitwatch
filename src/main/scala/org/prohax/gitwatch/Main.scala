package org.prohax.gitwatch

import com.sun.script.javascript.RhinoScriptEngine

object Main {
  def main(args: Array[String]) {
    args match {
      case Array() => println("Usage: run GIT_DIR [OUTPUT_FILE]")
      case Array("js") => {
        new RhinoScriptEngine().eval("println(5)")
      }
      case Array(git) => println(GitProHax.run(git,"refs/heads/master"))
    }
  }
}
