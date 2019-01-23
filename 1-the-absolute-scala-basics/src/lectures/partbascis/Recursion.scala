package lectures.partbascis

import scala.annotation.tailrec

object Recursion extends App {


  /*
  In order to make this recursion, the JVM crates a stack(pilha) to keep the partial values, to afterward
  get back calculating the items of recursion.
  So, each call of the recursion function user what we call a 'stack frame'...
   */
  // @tailrec   // the compile is complaining showing that it's not a Tail Recursion
  def factorial(n: Int): Int =
    if (n <= 1) n
    else {
      println("Computing factorial of " + n + " - I first need of " + (n-1))
      val result = n * factorial(n - 1)   // IT'S NOT A TAIL RECURSION because it's not the last expression in this function
      println("Computed factorial of " + n)

      result
    }

    println(factorial(10))
    /* The problem of this approach is that the JVM keeps all this stuff in the memory,
    and memory is a limited resource...let's try to make a factorial recursion of 5000, it's a big number
     */
    // println(factorial(5000)) // -> it gives us a StackOverflow error...(overflow do Stack, overflow da pilha de recursão)


  /* So, if we can't do recursion of big numbers, and as we've learnet, it's not usefull to use loops(return side effects)
  in Scala, how can we get through this problem? And if we want to iterate 5000 times?

  Well, we have to think in a smart way to solve this problem, let's have a go to implement the factorial function in a
  smat way:
  */

  /* It doesn't meter if i put an auxiliary fucntion here, if we rewrite this code without this outer function it will
  still run normally.

  So the question is:  Why does the factorial work...
  The tricky here is that the last expression is : else factHelper(x - 1, x * accumulator)
  It allows Scala to preserve the same stack frame e not use additional stack frames for recursive calls...
  In the code bellow every time we call factHelper() we're replacing the value of 'x' and memorizing the result in the
  accumulator... So, Scala doesn't need to create a new stack frame, only one is now necessary and preserves memory...
   */
  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)    // It's called TAIL RECURSIVE = to use recursive call as the LAST expression

    factHelper(n, 1)
  }


  /*
  What happens is:

  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)   // number 10 doesn't exist anymore and is replaced by 9, and also preserved in the accumulator...
  = factHelper(8, 10 * 9 * 1)
  = factHelper(7, 10 * 9 * 8 * 1)
  = factHelper(6, 10 * 9 * 8 * 7 * 1)
  = factHelper(5, 10 * 9 * 8 * 7 * 6 * 1) // remember that's just a representation, the real accumulator is = 30240
  = factHelper(4, 10 * 9 * 8 * 7 * 6 * 5 * 1)
  = factHelper(3, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 1)
  = factHelper(2, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 1)
  = factHelper(1, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1) -> when the n <= 1, which is the basic case,
  it will return the accumulator, and it's the result of the factorial function...

   */


  /* Now if you're not sure whether your recursion is a Tail Recursion, you can use the annotation @tailrec before the
  recursion function... if it's not a tail recursion, the compiler will raise an error, signing that it's not
  a Tail Recursion...this annotation verify whether it's or not an Tail Recursion...
   */


  // So, When you need loops, use TAIL_RECURSION.
  // Any function can be turned in a Tailed function
  // Exercices:
  /*
  1. Concatenate  a String n times
  2. isPrime function tail recursive
  3. Fibonacci function, tail recursive
   */

  // 1.
  def concatenate(aString: String, n: Int): String = {
    if (n <= 1) aString
    else aString + concatenate(aString, n-1)
  }
  @tailrec
  def tailConcatenateRecursion(aString: String, n: Int, accumulator: String): String =
  {
    if (n <= 0) accumulator
    else tailConcatenateRecursion(aString, n-1, accumulator + aString) // use recursive call as the last expression(Tail Recursion)
  }

  println(tailConcatenateRecursion("Hello", 10, ""))


  // 2. isPrime in Tail Recursion
  def isPrime(n: Int): Boolean = {
    // not tail recursion
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1) // it creates other stack frames to save the partial boolean values

    isPrimeUntil(n / 2)
  }
  println(isPrime(7))


  def isPrime2(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =     // isStillPrime saves the result of the last call
      if (!isStillPrime) false    // if it's false the recursion stops...
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)  // tail recursion, use the recursion call as the last expression

    isPrimeTailrec(n/2, true)    // isStillPrime starts as true, cause if it's contrary the recursion never happens
    // n/2 is the limit we've gave to the function... put in mind that / in scala returns an Int
  }

  println(isPrime(7))



  //3. Fibonacci
  def fibo(n: Int): Int = {
    if (n <= 1) 1
    else fibo(n - 1) + fibo(n - 2)
  }

  println(fibo(8))

  // Fibonacci Tailed Recursion
  def fibonacciT(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = // we need at least 2 accumulators cause we have to calls to fibo in the function above
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)


    if (n <= 2) 1
    else fiboTailRec(2, 1, 1) // it will ever start like this
  }

  println(fibonacciT(5))  // 1 1 2 3 5 8 13 21
}
