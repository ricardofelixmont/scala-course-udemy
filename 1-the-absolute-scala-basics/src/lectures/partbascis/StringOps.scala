package lectures.partbascis

object StringOps extends App {

  val str: String =  "Hello, I am learning Scala"


  // There are some functions that to Strings that comes from Java, as we know, Scala runs with JVM of Java...so it has access to some classes and methods from it
  println(str.charAt(2))   // it's how Scala leads with string indexing, we have the same in python but in a different way
  println(str.substring(7, 11))  // it's how Scala makes slicing, it's the same in python, str[7: 11]  , it includes 7 but exclude 11
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))   // Returns True if this String starts with the word 'Hello'
  println(str.replace(" ", "-")) // replacing spaces with dashes(-)
  println(str.toLowerCase())
  println(str.length)    // In Scala we don't need to write the brackets () when we have no parameters, it's similar to .setter in python, to encapsulation

  // But Scala has it's own String methods too:

  val aNumberString = "45"
  val aNumber = aNumberString.toInt   // This method converts a String to an Integer

  println('a' +: aNumberString)  // it prepend(contrario do append) the letter 'a' to the string. We have to use before the String
  println(aNumberString :+ 'a')  // it append the letter 'a' to the string, we need to use after the String

  println(str.reverse)  // the 'reverse' method cannot be called with brackets '.reverse()', without args it will give us an error.

  println(str.take(2))   // give us '2' characters of this String


  // Scala-specific: String Interpolators.

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name, and i am $age years old."
  val anotherGreeting = s"Hello, my name is $name, and I will be turning ${age + 1} years old." // Using brackets we can do math operations inside S-interpolations

  // F-interpolators
  // The advantage of F-interpolator is that it checks for type correctness in the value that they expand
  val speed = 1.20
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  /*
  $ will expand the value to be used in the f-string
  %s = formating string
  %2.2f =  float number format: 2 characters total, minimum, 2 decimals precision.
   */
  println(myth)


  //raw-interpolator
  // works the same of s-interpolator but it can print values literally
  println(raw"This is a \n newline") /// here the '\n' is part of the string and not an instruction...
  val escaped = "This is a \n newline"
  println(raw"$escaped")

  /*
  So the raw interpolator strings ignores escaped characters inside raw characters in the String
  other wise injected variables do get escaped(caracteres reservados da linguagem) characters.
   */

}
