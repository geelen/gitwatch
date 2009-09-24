package org.prohax.gitwatch

import scala.io.Source
import com.sun.script.javascript.RhinoScriptEngine
import runtime.RichDouble

class JavascriptFile(file: String) {
  val engine = {
    val e = new RhinoScriptEngine()
    e.eval(Source.fromFile(file).getLines.mkString)
    e
  }

  def test(a: String) = engine.invokeFunction("test", a)
  //using invokefunction returns a string concat of a&b...
  def add(a: RichDouble, b: RichDouble) = engine.eval("add(" + a + "," + b + ")")
}
