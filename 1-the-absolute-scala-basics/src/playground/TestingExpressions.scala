package playground

object TestingExpressions extends App {   // It's only possible to run this program if it extends 'App'
  val x: Int = 10
  var y: String = "New Game"

  val value = if (x < 10) "X < 10" else "X > 10"

  println(value)
}
