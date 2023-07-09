package org.lukas.scala.exercises.rdailyprogrammer

import org.lukas.scala.exercises.utils.FileUtils.readFileLines
import org.scalatest.flatspec.AnyFlatSpec

import java.nio.file.Files
import scala.collection.mutable
import scala.concurrent.Future
import scala.util.Using

class Ch399LetterValueSum extends AnyFlatSpec {
  def letterSum(str: String): Int =
    str.map(_.toInt - 96).sum

  def loadEnable1List(): List[String] = readFileLines("ch399/enable1.txt")

  "letterSum" should "return correct sums" in {
    assert(letterSum("") === 0)
    assert(letterSum("a") === 1)
    assert(letterSum("z") === 26)
    assert(letterSum("cab") === 6)
    assert(letterSum("excellent") === 100)
    assert(letterSum("microspectrophotometries") === 317)
    println("\nOptional challenges:")
    val wordList = loadEnable1List()
    print("Word with letter sum of 319: ")
    println(wordList.find(letterSum(_) == 319).get)
    print("No. of words with odd letter sum: ")
    println(wordList.count(letterSum(_) % 2 == 1))
    print("Most common sum, and no. of words that have it: ")
    val (mostCommonSum, mostCommonSumCount) = wordList
      .map(letterSum)
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .maxBy(_._2)
    println(s"sum - $mostCommonSum, words - $mostCommonSumCount")
  }
}
