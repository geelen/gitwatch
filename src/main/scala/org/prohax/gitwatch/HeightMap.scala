package org.prohax.gitwatch

import collection.mutable.ArrayBuffer

class HeightMap {
  import HeightMap._
  val state = new ArrayBuffer[(Int, Range)]

  def add(height: Int, from: Long, to: Long) {
    state += ((height, from.asInstanceOf[Int] until to.asInstanceOf[Int] + 1))
    //    println("      --  height = " + height)
    //    println("      --  from = " + from)
    //    println("      --  to = " + to)
  }

  def heightAt(time: Long) = Iterable.max(0 :: state.filter(_._2 contains time).map(_._1).toList)

  def heightWithin(range: Range) = {
    Iterable.max(0 :: state.filter(x => overlap(x._2, range)).map(_._1).toList)
  }

  override def toString = {
    if (state.isEmpty) "" else {
      val min = Iterable.min(state.map(_._2.start))
      val max = Iterable.max(state.map(_._2.end))
      val maxHeight = Iterable.max(state.map(_._1))
      val header = "min: " + min + ", max: " + max + ", height: " + maxHeight
      (header :: Stream.range(maxHeight, -1, -1).map((i) => {
        val line = Array.make(101, ' ')
        state.filter(_._1 == i).foreach((x) => {
          val l = (100 * (x._2.start - min).toDouble / (max - min)).round.toInt
          val r = (100 * (x._2.end - min).toDouble / (max - min)).round.toInt
          l.until(r + 1).foreach (x => {
            line.update(x, '-')
          })
        })
        line
      }).toList) mkString "\n"
    }
  }
}

object HeightMap {
  def overlap(a: Range, b: Range) = {
    b.contains(a.start) || b.contains(a.end) || a.contains(b.start) || a.contains(b.end)
  }
}