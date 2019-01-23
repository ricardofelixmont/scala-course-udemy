package lectures.partbascis

object Expressions extends App {

  val x = 1 + 2 // 1 + 2 it's an Expression in Scala, it has a type and evaluates to 3...
  println(x)

  println(2 + 3 * 4)
  /* + - * /   bitwise operators: & | ^ <<(left shift) >>(right shift)  >>>(this operator is particular to Scala)
   it's called right shift with zero extension

   println( 37 / 2) // The result of a division in Scala is an Int...
   */

  println(1 == x)   // Expression that shows a Boolean result (true or false)
  // relational operators: == != > >= < <=

  // Logical Operators:
  println(!(1 == x))  // ! means not in Scala, it's the logical negation operator...
  // ! = not , && = and , || = or


  // We can also use operators to change variable values...
  var aVariable = 2
  aVariable += 3 // also works with -= *= /=  (remember that this just work with variables, not with vals...
  // changing a variable means 'Side Effect, so in the line above the operators means to be
  println(aVariable)

  // Instructions vs Expressions
  /*
  Instructions are executed(think JAVA) and expressions are evaluated(Scala and functional languages...)
  (DO) something vs (Give me The VAlUE) of something
   */

  /* An instruction is something that we tell the computer to (DO)...
     ex: change a variable, print something in the console...

     An expression is something that has a ( VALUE) and or a (TYPE): so an expression is everything on your code that
     has a value

   */


  // IF expression, have in mind that 'if' in Scala is an Expression
  val aCondition = false
  val aConditionedValue = if (aCondition) 5 else 3  // IF EXPRESSION, not an if instruction
  println(aConditionedValue)

  print(if (aCondition) 5 else 3) // it evaluates to 3
  print(1 + 2) // it also evaluates to 3, so we can see that it's an EXPRESSION like the above ones.

  /*
  It's not recommended to use loops in Scala(they exist), because they only execute side effects(variable change)...
   */
  // NEVER WRITE THIS AGAIN!!!
  // avoid while loops in Scala...pois while and looping in general is very specific to imperative programming like Java
  var i = 0
  while (i < 10){      // it's a while loop in Scala
    println(i)
    i += 1
  }

  // EVERYTHING IN SCALA IS AN EXPRESSION! excepting val and var declarations, everything else are expressions.

  val aWeirdValue = (aVariable = 3)   // Unit === void     (===) means equivalent     () is the only value that an Unit
                                                                                      // type can hold

  println(aWeirdValue)

  /* reassigning a variable is a 'Side Effect', so 'side effects' in Scala are actually expressions returning Unit
    ...while loop is a side effect so it also return a Unit type...
   */
  val aWhile = while (i < 10){

    i += 1
  }
  println(aWhile)   // it must return a Unit type

  // Examples of side effects in Scala: println(), whiles, reassigning
  /* So remember that 'side effects are expressions that return Unit'
        Side effects are reminiscent of imperative programming that is they're like instructions
        but in Scala they're still Expressions returning Unit...
  */



  // CODE BLOCKS
  /* below we have an example of CODE Blocks, there we can define vals and a lot of other things like create expressions
    Observations about CODE BLOCKS:
    1. Code Blocks are expressions like everything else in Scala...
   */
  val aCodeBlock = {
    val y = 2
    val z = y + 1


    if (z > 2) "Hello" else "goodbye"    // the value of 'aCodeBlock' is the result of this last expressions, because
    //  it occurs last...
  }

  /* An observation about Code Blocks is that variables declared into them are local variables...
  They can't be accessed from outside of the block...
  if we try to do that:
  val anotherValue = z + 1 -> it will raise an error...
  */


  /*
  * QUESTIONS:
  * 1. whats the difference between the String "Hello World" and println("Hello World")
  *   answer: the String "Hello World" is a value of the type String, and println("Hello World") is an expression
  *   that, a side effect and it's an Unit...
  * 2. Whats the value of: */
  val someValue = {
    2 < 3   // this expression evaluates to true...it's a relational expression... it's a Boolean
  }
  println(someValue)
  /*
   * 3. whats the value of:
   */
  val someOtherValue = {
    if(someValue) 239 else 986// here we have a code block with two lines, a code block is an expression like everything
                           // else in Scala, so it will evaluate to 42 because its the last thing evaluated in the block
    42 // the line abouve became irrelevant, and 42 is the value of this code block expression...
  }
  println(someOtherValue)

}
