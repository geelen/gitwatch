package org.prohax.gitwatch

import scala.io.Source
import com.sun.script.javascript.RhinoScriptEngine
import java.lang.{Double => JDouble}

class JavascriptFile(file: String) {
  val engine = {
    val e = new RhinoScriptEngine()
    e.eval(Source.fromFile(file).getLines.mkString)
    e
  }

  def length(a: List[Any]) = engine.invokeFunction("length", new java.util.ArrayList)

  def test(a: String) = engine.invokeFunction("test", a)

  val List(add, multiply) = List("add", "multiply").map((name) => {
    (a: Double, b: Double) => engine.invokeFunction(name, new JDouble(a), new JDouble(b))
  })
}
