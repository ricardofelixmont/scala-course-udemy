package playground

import scala.io.Source
// Circe Library
object OpenFile extends App {

  val filename = "/home/semantix/workspace/scala-course-udemy/1-the-absolute-scala-basics/src/playground/myTextFile.txt"

  for (line <- Source.fromFile(filename).getLines) {
    println(line)
  }

}
