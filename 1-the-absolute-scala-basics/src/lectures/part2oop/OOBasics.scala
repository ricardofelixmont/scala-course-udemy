package lectures.part2oop

import javax.security.sasl.AuthorizeCallback

object OOBasics extends App {

  val personTest = new PersonTest   // Instantiating a class in scala
  println(personTest)   // here we can see the repr of the object


  val person = new Person("Jhon", 25)
  println(person.age)
  println(person.x)
  person.greeting("Ricardo")
  person.greeting()



  // Testing Exercices:
  val writter = new Writter("JRR", "Tolkien", 1914)
  println(writter.fullName())

  val lot = new Novel("Lord Of The Rings", 1997, writter)
  println(lot.authorAge())
  println(lot.writtenBy())  // I need to pass as arg the object writter

  val lot2 = lot.copy(1999)
  println(lot2.authorAge())


  // Exercice: Counter
  val counter = new Counter2
  counter.inc.print
  counter.inc.inc.inc.print  // increment 3 times and then print the current value of 'count'
  counter.inc(10).print     // increment 10 times and then print the current value of 'count'
}


/*
We can create classes below and instantiate in the OOBasics object that extends App, so it can be ran
 */
class PersonTest    // Creating a class

// let's create a more complex class in Scala

class Person(name: String, val age: Int) {   // This line is called constructor/ primary constructor
  /*
  The Difference between 'class parameters' and 'class Field'

  class parameters are NOT FIELDS
  to convert parameters in class FIELDS we have to add a 'val' or a 'var' before the parameter.
  After that we can access these parameters with .name or .age for example...

  https://stackoverflow.com/questions/13549574/scala-what-is-the-real-difference-between-fields-in-a-class-and-parameters-in-t
   */

  val x = 2

  println(1 + 3)

  def greeting(name: String): Unit = println(s"${this.name} says: Hi, $name") // need to use this to say that you want to access the property not a local variable

  // Overloading: methods with same name but with different signatures...
  def greeting(): Unit = println(s"Hi, I am $name") // here i don't need to use this.name cause there's no parameters in this function


  // Multiple constructors:
  def this(name: String) = this(name, 0) // this is the primary constructor
  /*
  Although this is pretty cool, the frustration with auxiliary constructor is that the implementation of a secondary
  constructor has to be another constructor, and nothing else.
   */
  // So if I define another constructor.
  def this() = this("Jhon Doe")  //  this is the only implementation that an auxiliary constructor can have...a call of a primary or secondary constructor
  /*
  This limitation makes the auxiliary constructor is quite impractical, because they're only used in practice fot default parameters
  for exemplo: def this(name: String) = this(name, 0), it can be solved more eficiently creating an default parameter in the
  primary constructor: class Person(name: String, val age: Int = 0) in Int = 0...
   */


}


/* Exercice:

Create two classes: Novel and Writer
  Writer: first name, surname, year
    - method fullname(concatenate first name with surname)

  Novel: name, year release, author(instance of type Writer)
    - method author age
    - writtenBy(author)
    - copy (new year of release) = new instance of Novel
 */

class Writter(val name: String, surname: String, val year: Int){  // when i put val in front of year, 'year' becomes a property of class Writter

  def fullName(): String = {
    /*
  Receives 'name', 'surname' and returns an expression
  that concatenates to generate the full name
   */
    name + " " + surname
  }
}

class Novel(name: String, year: Int, val author: Writter){
  def authorAge(): Int = {
    this.year - author.year // As i've turn it a property of Writter above, i can call 'year' like this
  }
  def writtenBy(): String = {
    author.name
  }

  def copy(newYear: Int): Novel = {
    new Novel(name: String, newYear: Int, author: Writter)
    // new Novel(name, newYear, author)   it will work too, it's another way to create this object here
  }


}

/*
Counter Class
  - receives an Int value
  - method returns current count
  - method to increment/decrement it will return a new counter
  - overload inc/dec to receive an amount
 */



  /*
  class Counter(val count: Int){
  def currentCount(): Int = count
  }

  In practice when we have a method that return a field(basically a getter method),
  we have to turn the parameter into a field(val) of this class

  So instead of doing the above, it's better to do:
  class Counter(val count: Int) -> because of instead call a function to return the count, we can call directly the count with
  'object.count'
  so:
  */
class Counter(val count: Int){
    def inc = new Counter(count + 1) /*
    This is very important, the fact that we're returning a new counter instead of modifying the current count in this instance
    is called 'immutability' and is the same principle with declaring vals for primitive types, but extended to objects and to
    classes
    This is extremely important in functional programming
    This basically say that instances are fixed, they cannot be modified.
    Whenever you need to modify the contents of an instance you actually need to return a new instance.
    */
    def dec = new Counter(count - 1)  // again it's returning a new instance and not modifying the current one.

    // Now let's overload the 'dec and inc' methods to receive an amount instead of using '1' to inc and dec
    def inc(n: Int) = new Counter(count + n)

    def dec(n: Int) = new Counter(count - n)

}

/*
But let's say that we want to log something:
for example add a println("Incrementing") and println("Decrementing")
 */
class Counter2(val count: Int = 0){
  def inc = {
    println("Incrementing")
    new Counter2(count + 1)
  }
  def dec = {
    println("Decrementing")
    new Counter2(count - 1)
  }
  /*
  The way we were handling in the class Counter, doesn't allows us to use the overload methods of inc and dec as we want,
  when we call the overloaded method, it doesn't print the logs...but we want to print it...
  So we need to try a new approach of it...Let's assume that 'inc' and 'dec' are our source functions

  So in order to not repeat ourselves we want to actually call it back from the overloaded counterparts
   */
  def inc(n: Int): Counter2 = {
    /*
    Remember, instead of looping we have to use recursion to iterate about something.
    If we want to repeat the log words we've declared above we need to do:
     */
    if (n <= 0) this // return this instance, because it doesn't need any incrementing
    else inc.inc(n-1)  // otherwise i need to call the inc(source) method and then recursively call this method n-1 times
  }

  def dec(n: Int): Counter2 = {
    if (n <= 1) this
    else dec.dec(n-1) // In 'dec.dec(n-1)', the dot(.) is what calls the overload function
  }

  def print = println(count) // this method will print in the console the current 'count'
}
