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
    print("Words with sum 151 but their lengths differ by 11 letters: ")
// zyzzyva and biodegradabilities
// answer:
//    wordList.groupBy(_.length)
    // 15 -> List(sdjlkf, sdjklf,sdlfk)
//    (minLen to (maxLen - 11))

  }
}
