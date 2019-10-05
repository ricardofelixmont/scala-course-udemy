package lectures.part2oop

import playground.{Cinderella, PrinceCharming} // Had to import the class through the package
import playground._ // import all classes in playground
import playground.{PrinceCharming => p}    // Here i can give an alias to the Prince class
object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writter("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Cinderella
  // OR....
  val princess2 = new playground.Cinderella

  // Packages are in hierarchy
  // matching folder structure

  /*
  Scala specific:
    package object

    They rarely used in practice, but is a isolated universe where you can put utilities: methods and constants
   */

  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  val prince = new PrinceCharming



  import java.util.Date
  // import java.sql.Date

  val date = new Date() // If there are two classes imported with the same name, scala will choose the first one.

  /* default imports
  java.lang - String, Object, Function
  scala - Int, Nothing, Function
  scala.Predef - println, ???
  */
}
