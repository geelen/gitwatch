package org.prohax.gitwatch

import scala.io.Source
import com.sun.script.javascript.RhinoScriptEngine

class JavascriptFile(file: String) {
  val engine = {
    val e = new RhinoScriptEngine()
    e.eval(Source.fromFile(file).getLines.mkString)
    e
  }

  def test(a: String) = engine.invokeFunction("test", a)
  def add(a: Double, b: Double) = engine.invokeFunction("add", a.toString, b.toString)
}
