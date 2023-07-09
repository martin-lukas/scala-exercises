package org.lukas.scala.exercises.utils

import java.nio.file.Files
import java.nio.file.Paths
import scala.jdk.CollectionConverters.*

object FileUtils {
  private val Root = "src/main/resources"

  def readFileLines(path: String)(using proj: Project): List[String] =
    Files.readAllLines(Paths.get(s"$Root/${proj.name}/$path")).asScala.toList
}
