package lectures.partbascis

object Functions extends App {  // 'extends App' is put here to the code be runnable by IntelliJ

  def firstFunction(par1: String, par2: Int): String =    // def functionName(parameter:type): Return_Type = Expression
    par1 + " " + par2   // + signal is used to concatenate in Scala

  // As we've seen in the last video, a Code Block is an Expression, so we can put the expression in a Code Block:
  def secondFunction(par1: Int, par2: Int): Int = {  // Here we put the expression in a Code Block
    par1 + par2
  }
  /* As in vals and vars, functions don't need to specify the type it returns... the Scala compiler is smart enough to
  infer the return type...
  But... when it's a 'Recursion' function, we need to put the result type...that's because compiler can't infer
  result types in recursion functions...
*/
  def function(par: String, par2: Int) = par + par2

  // CALLING THE FUNCTION:
  println(firstFunction("Hello", 3))
  /*
  Like everything else in Scala, calling a function is also an expression because we can use the call of the function
  as is in the println() statement
   */
  println(secondFunction(10, 3))


  // ParameterLess Function:
  def parameterLessFunction(): Int = 42
  /*
  We can call functions without parameters on two ways:
   */
  println(parameterLessFunction())  // call with name and brackets -> functionName()
  println(parameterLessFunction) // calling just with the name of the function -> functionName




  /* Take in mind that loops really exist in Scala, but we have to avoid them...
  Normally we're going to use 'RECURSION' to repeat things...

  Look at the example below:

  */

  def aRepeatedFunction(aString: String, n: Int): String = {
    /*when it's a 'Recursion' function, we need to put the result type...
    that's because compiler can't infer result types in recursion functions.
     */
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Nome", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION. This is a fundamental idea of functional programming...
  /* the worst thing a Scala programming can do is use a Imperative sintax in Scala... */



  // Functions tha return Unit:
  def aFunctionWithSideEffects(aString: String): Unit = println(aString) // println function is an expression returning Unit
  /*
  We normally need functions with side effects if we want something that don't have nothing
  to do with computation itself...
  For example:
        printing something to the console, displaying something on the screem, logging something or writing...
   */



  /*
  Auxiliary Functions inside other functions:

   */
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)  // here we see that we can use functions inside functions to determinate the value of an
                              // expression, remember that the last expression is the result of the entire expression
  }


  // EXERCICES
  // 1.  A greeting functions that receives two parameters: name, age and returns a String: "Hi, i'm $name and i'm $age years old"
  def gretting(name: String, age: Int): String = {
    s"Hi, my name is $name, and i'm $age years old"
  }
  println(gretting("Carlos", 15))


  // 2. Factorial function 1 * 2 * 3 * .. * n
  def factorialFunction(number: Int): Int = {
   if (number == 1) number
   else number * factorialFunction(number - 1)
  }

  println(factorialFunction(4))


  /*3. Fibonacci Function:
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n - 2)
   */
    def fibFunc(n: Int): Int = {
      if (n <= 1) n
      else fibFunc(n - 1) + fibFunc(n - 2)
    }

  println(fibFunc(8))

  //4. Test if a number is prime
  /* Prime number is the one that can be divided only for 1 an himself
   */
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1) // It's not a condition, it's what happens when we put

    // In the lines above we've just defined the function isPrime(), now we have to call it...
    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

  println(7 / 2)// The result of a division in Scala is an Int...


  // Having a go in fibonacci again:
  def fibonacci(number: Int): Int = {
    if (number <= 1) number
    else fibonacci(number -1) + fibonacci(number - 2)
  }
  print(fibonacci(8))
}
