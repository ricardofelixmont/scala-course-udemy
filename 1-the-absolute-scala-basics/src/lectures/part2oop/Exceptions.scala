package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  /* println(x.lenght)
  This ^^ will crash with NullPointerException
  */

  // 1. Throwing exceptions
  // throw new NullPointerException
  // val aWeirdValue = throw new NullPointerException
  /* I can put it into a val, because everything in scala is
  an expression and have a value, int this case the value is Nothing */

  /*
  throwable classes extends the Throwable class.
  Exception and Error are the major Throwable subtypes
   */

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42


  val potentialFail = try {
    // Code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // Code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  // throw exception -> i can call my own exception to crash my program

  /**
    * Ex:
    * 1. Crash your program with an OutOfMemoryError
    * 2. Crash your program with an SOError
    * 3. PocketCalculator
    *   - add(x, y)
    *   - subtract(x, y)
    *   - multiply(x, y)
    *   - divide(x, y)
    *
    * Throw custom exceptions
    *     - OverflowException if add(x,y) exceeds Int.MAX_VALUE
    *     - UnderflowException if subtract(x, y) exceeds INT.MIN_VALUE
    *     - MathCalculationException for division by 0
    */

  //1. OOM
  // val array = Array.ofDim(Int.MaxValue)

  //2. Stack Overflow
  //  def infinit: Int = 1 + infinit
  //  val noLimit = infinit

  // 3. PocketCalculator

  class OverflowException extends Exception

  class UnderflowException extends Exception

  class MathCalculationException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }
  val result = PocketCalculator
  println(result.add(1,2))
  println(result.subtract(1,2))
  println(result.multiply(1,2))
  println(result.divide(1,2))


}
