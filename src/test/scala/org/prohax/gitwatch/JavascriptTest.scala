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
    "add values" in {
      js.add(1.0,2.0) must beEqualTo(3.0)
      js.add(5,10) must beEqualTo(15.0)
      js.add(5.0,-10.0) must beEqualTo(-5.0)
    }
    "multiply values" in {
      js.multiply(1.0,2.0) must beEqualTo(2.0)
      js.multiply(5,10) must beEqualTo(50.0)
      js.multiply(5.0,-10.0) must beEqualTo(-50.0)
    }
  }

  "advanced tester" should {
    "get length" in {
      js.length(List()) must beEqualTo(0)
      js.length(List(1,2,3)) must beEqualTo(3)
    }
  }
}