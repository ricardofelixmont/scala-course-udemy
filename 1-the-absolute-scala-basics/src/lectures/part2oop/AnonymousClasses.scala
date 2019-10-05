package lectures.part2oop

/**
  * Created by Ricardo
  */

object AnonymousClasses extends App {

  abstract class Animal {

    def eat: Unit
  }

  // It looks like we're instantiating an abstract class, but it's not really true.
  val funnyAnimal: Animal = new Animal {

    override def eat: Unit = println("hhahahahahah")

  }

  // Lets prove we're instantiating a real class:
  println(funnyAnimal.getClass)
  // This is the result => class lectures.part2oop.AnonymousClasses$$anon$1

  /*
  What happens is that, when we instantiate an abstract class, the compiler creates an anonymous class that extends
  the abstract class automatically
  Look at the example below:
   */

  class AnonymousClasses$$anon$1 extends Animal {
    def eat: Unit = println("Haahahahaha")
  }


  // -----

  class Person (name: String) {
    def sayHi: Unit = println(s"Hello, my name is $name, what can i do for you?")
  }


  // realize that to instantiate an anonymous class we have to give the instance the parameters superclass needs
  val jim = new Person("Jim")  {
    override def sayHi: Unit = println(s"Hello, my name is Jim, can i help you?")
  }

  println(jim.getClass)



  // Classes With no name, anonymous functions
  val ricardo = new {
    val name = "Ricardo"
    val age = "25"
    // This is an anonymous class
  }

}

/**
  * Takeaways:
  * We can instantiate types and override fields of methods on the spot
  *
  * trait Animal {
  *   def eat: Unit
  * }
  *
  * val predator = new Animal {
  *   override def eat: Unit = prinltn("RAWR!")
  * }
  *
  * Rules:
  *   * pass in required constructor arguments if needed
  *   * implement all abstract fields/methods
  *
  *
  *  It Works for traits and classes (abstract or not)
  *
  *  Advantages of instantiating anonymous classes:
  *    Classes with no name, the same idea of anonymous functions or lambda functions
  *   when we need to instantiate a trait or an abstract class we have to use anonymous classes.
  *
  *   The compiler create to you an anonymous class that extends the trait or the abstract class, saving our time.
  *
  *
  *
  * BONUS!!!!!
  * Lambda expressions can be used in Scala, that is, anonymous functions. Further on, in other posts we’ll get to the importance of the use of anonymous functions in, for instance, methods that accept functions as parameter.
  * Anonymous functions, just like anonymous classes, are functions that don’t need to be declared.
  * This is an example of anonymous function:
  *
  * 1
  * (x: Int) => x + 1
  * In this case, the anonymous function expects an integer and returns that same integer plus one unit.
  *
  * We must not forget that, in Scala, functions are objects in reality. By taking this last consideration into account, we can relate anonymous functions (or lambda expressions) to anonymous classes.
  *
  * So, when we use the anonymous function (x: Int) => x + 1, what is really happening is the creation of an instance of an anonymous class from the trait Function1:
  *
  * new Function1[Int, Int] {
  * def apply(x: Int): Int = x + 1
  * }
  */
