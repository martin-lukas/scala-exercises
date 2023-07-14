package org.lukas.scala.exercises.random

import org.lukas.scala.exercises.utils.FileUtils.readFileLines
import org.scalatest.flatspec.AnyFlatSpec

import java.nio.file.Files
import scala.collection.mutable
import scala.concurrent.Future
import scala.util.Using

class MultiplicationTable extends AnyFlatSpec {
  type Table = Seq[Seq[Int]]

  def multiTableString(): String =
    val table = multiTable(10)
    val maxNumber = table.map(_.max).max
    table.map(makeRow(_, maxNumber)).mkString("\n")

  def multiTable(max: Int): Table = {
    (1 to max).map { row =>
      (1 to max).map(_ * row)
    }
  }

  def makeRow(row: Seq[Int], maxNumber: Int): String =
    val maxLength = maxNumber.toString.length
    maxLength.toString

  def padNum(num: Int, minLength: Int): String = "sdfds"

  "multiTable" should "return multiplication table" in {
    val table = multiTable(10)
//    println(table)
  }
}
