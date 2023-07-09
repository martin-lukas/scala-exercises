package org.lukas.scala.exercises.utils

enum Project(aName: String) {
  case RDailyProgrammer extends Project("rdailyprogrammer")

  def name: String = aName
}
