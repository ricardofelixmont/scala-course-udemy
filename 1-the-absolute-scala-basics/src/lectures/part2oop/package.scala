package lectures

package object part2oop {

  // Can only have one package object per package
  // Isolated Universe of constants and methods

  def sayHello: Unit = println("Hello, Scala")
  val SPEED_OF_LIGHT = 299792458
}
