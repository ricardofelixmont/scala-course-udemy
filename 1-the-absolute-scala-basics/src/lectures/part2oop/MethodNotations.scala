package lectures.part2oop

object MethodNotations extends App {

  /* We're declaring this 'Person' class inside this object because if we've created another class Person in this
                  Package it can generate a conflict
  We'll learn about conflicts afterward...*/
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie // verify if 'movie' == 'favoriteMovie'

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?!" // we have to put a space between 'unary_' an ':', to avoid the compiler to

    // Postfix notation                                        // understand ':' as part of the function name
    def isAlive: Boolean  = true   // it's a method parameterless(without parameters)

    def apply(): String = s"Hi, i'm $name and i like $favoriteMovie."

    // Receives a String(a nick name) and returns a new object Person where the name is the name + nickname
    def +(str: String): Person = new Person(s"${this.name} $str", this.favoriteMovie)

    /* Unary method that receives an object and returns a new person with age + 1
    */
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    // Learns method
    def learns(str: String): String = s"$name learns $str."

    def learnsScala: String = learns("Scala")

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // returns true
  println(mary likes "Inception") // It's another way to call a method, it's similar to our natural language
  /* The two methods calls above are equivalent, and
  the second one is called "Infix Method / Operator Notation" -> And it's called in Scala as (syntactic sugar)
  *** Methods with a single parameter can be called with this "Infix notation"
   */


  // "OPERATORS" in Scala
  val tom = new Person("Tom", "Fight Club")
  /*
  I can call 'hangOutWith' as a 'Infix Method', cause it has only a single parameter...
   */
  println(tom hangOutWith mary)
  /* Here's an example why it's called Operator Notation, in this case the method "hangOutWith" is
  used as an Operator which yields a String with those two objects*/

  /*
  Operators are commonly related to math operator,
  Now the thing is that Scala actually has an extremely permissive method naming scheme.
  So if i rename this method or create another method called '+':
   */
  println(mary + tom) // Scala gives us a good permission to name our methods as well as we want...
  println(mary.+(tom)) // and we can call this method with object notation

  /*
  So at this point let's clarify some points:
  Math operator are also methods
   */
  println(1 + 2)
  // the above operation can be called:
  println(1.+(2)) // it occurs because math operators are also methods

  // OBS.:  ALL OPERATORS ARE METHODS IN Scala.


  // Another form of Syntactic Sugar
  // Prefix Notation: are all about Unary operator(operators that acts over only one "Operando"
  val x = -1  // (-) is an 'unary operator' and they are also methods in Scala
  val y = 1.unary_- // it's the same of the line above
  // 'unary_' prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)


  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive) // it's rarely used in practice because it's almost the same of using dot,
                        // and in some cases can provide some ambiguities when reading the code...not to the compiler but for humans...
                        // it's only available to methods without parameters.

  // Apply
  println(mary.apply())
  println(mary())   // with apply method, we can call an object the same way as a function...
  /*
  It's cool because it breaks the barrier between functional programming and OO programming
   */

  /*
  Exercices
  1. Overload the + operator which receives a String and will return a new person and the nick name
    ex: mary + " the rockstar" => person "Mary (the rockstar)"
    */
  val newMary = mary + "The Rockstar"
  println(newMary.name)
  // I can also use the apply() method we've already created:
  println((mary + "Another Nick Name")())
  // It's the same of:
  println((mary + "A nick Name").apply())
  /*


  2. Add an age to the Person class (0 as default)
     Add a unary + operator tha returns => a new person with the age + 1
     ex: + mary => mary with the age incrementer
 */
  val newTom = +tom

  println(newTom.age)

  /*
  3. Add a "learns" method in the Person class, it receives a String parameter and returns => "Mary learns Scala"
     Add a learnsScala method, calls learns method with "Scala" as a Parameter.
     Use it in postfix notation.
  */

  println(mary learnsScala)

  /*
  4. Overload the apply method
     mary.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))
}