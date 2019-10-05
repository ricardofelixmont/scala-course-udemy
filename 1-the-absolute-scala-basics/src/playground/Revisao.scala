package playground

object Revisao extends App {


  // Training to Repeat Things without for or while:
  // We have to use Recursion

  // Let's see if i remember how to code a recursion in Scala to repeat some peace of code
  //  In recursion i have to specify the type it returns because the compiler can't do that
  def recursion(str: String, n: Int): String = {
    if (n == 1) str  // menor caso
    else str + "\n" + recursion(str, n-1)   // calling itself
    // print the code 10 times
  }

  println(recursion("Ricardo", 10))


  println(!(2 < 3)) // It return false

  // Expression
  val x: Int = 10
  val someValue = {
    if (x > 10) 1 else 0

    2
  }
  println(someValue)

}
