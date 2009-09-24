package org.prohax.gitwatch

import org.specs._

object JavascriptTest extends Specification {
  val js = new JavascriptFile("src/main/webapp/javascripts/logic.js")

  "basic tester" should {
    "return the same value" in {
      js.test("a") must beEqualTo("a")
      js.test("1234") must beEqualTo("1234")
      js.test("") must beEqualTo("")
    }
//    "add values" in {
//      js.add(1,2) must beEqualTo(3.0)
//    }
  }
}