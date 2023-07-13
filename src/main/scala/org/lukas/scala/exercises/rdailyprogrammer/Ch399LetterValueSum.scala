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
    print("Word with sum 319: ")
    println(wordList.find(letterSum(_) == 319).get)
    print("No. of words with odd sum: ")
    println(wordList.count(letterSum(_) % 2 == 1))
    print("Most common sum, and no. of words that have it: ")
    val (mostCommonSum, mostCommonSumWords) = wordList.groupBy(letterSum).maxBy(_._2.size)
    println(s"sum - $mostCommonSum, words - ${mostCommonSumWords.size}")
    println("Words with same sum, but their lengths differ by 11 letters: ")
    for {
      (sum, words) <- wordList.groupBy(letterSum)
      groupedByLen = words.groupBy(_.length)
      minLen = groupedByLen.minBy(_._1)._1
      maxLen = groupedByLen.maxBy(_._1)._1
      lowerLen <- minLen to maxLen - 11
      upperLen = lowerLen + 11
      if groupedByLen.contains(lowerLen) && groupedByLen.contains(upperLen)
    } println(
      s"\tLetter sum - $sum ; word pair - ${groupedByLen(lowerLen)}, ${groupedByLen(upperLen)}"
    )
  }
}
