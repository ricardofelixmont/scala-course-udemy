package lectures.part2oop

object Objects extends App {

/*
Until this point, we've avoided to use the word 'Object' when referring to instances of classes
And that is because objects in Scala are a dedicated concept

One of the fundamental aspects of object oriented programming is something that we call 'class level functionality'
That means functionality that does not depend on an instance of a class.

If you've noticed everything that we have written so far had connection to an instance of some class at any given point.
 But there are cases where we really shouldn't need to do that
 For example universal constants or universal functionality that we should be able to access without relying on instance of some class

 */

  /*
  SCALA DOES NOT HAVE 'CLASS LEVEL FUNCTIONALITY'(Scala doesn't know the concept of "static")
  It has something even better, and it's called objects.
   */

  object Person{ // type + it's only instance
    /*
    so the object is it's own type Person + it is it's only instance
     */
    /*
    Objects can be defined a similar way to classes, but it does not receive parameters.
    Objects can have 'val', 'var' and 'def'
     */
    val N_EYES = "2"
    def canFly(): Boolean = false

    // This is called a 'factory method', it's called like this because it's sole purpose is to build persons, given some parameters.
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    /*
    In practice factory method is called apply() instead of 'from' or every thing else.
     */

  }
  class Person(val name: String) {
    /*
   Now, a pattern that is often used in practice is that we write 'objects and classes with the same name.'
   So class Person in the same file or even in the same scope, for practical reasons 'this is just to separate
   instance-level functionality from "static"/"class" -level functionality'.
   So we can split the functionalities in classes and objects.

   This pattern is called COMPANIONS, so the class Person and the object person are companions, because they have the
   same name, and are part of the same scope.
    */

    /*
    It's curious because it turns Scala more Oriented Object than other languages even Java.
     */
  }


  println(Person.N_EYES)
  println(Person.canFly())

  /*
  So, to use the concept of class-level in Scala, we use objects

  Now, let's start explaining the differences:

  Scala Object = SINGLETON INSTANCE, it means that when i define the object Person, i basically define the type,
  But i also define it's only instance...
   */


  val mary = Person // it's pointing to Person Object
  val tom = Person

  // if i compare the two vals:
  println(mary == tom)  // it gives us 'true' because, 'mary' and 'tom' are vals that points to the same instance,
                        // this instance is the Person Object

  /*
  So, another advantage of Objects in Scala is that, they are, by definition, SINGLETONS instances without any code
  needed from you...
   */

  /*
  Let's clarify some points:
  When we say 'an object in Scala is a Singleton', is that we have only an instance of an object.
  if we have a class that's a COMPANION of this object, we can instantiate this class a lot of times.
  Let's see some examples:
   */

  val jim = Person
  val james = Person

  println(jim == james) // it's going to give us true, because the person object is a Singletone, and 'jim' and 'james' are just pointing to the same object

  val tim = new Person("Mary")
  val jones = new Person("Jhon")

  println(tim == jones)

  val bobbie1 = Person.apply(tim, jones)
  // or we can do:
  val bobbie2 = Person(tim, jones) // because we're overwriting the apply method


  // Scala applications: this is the point where we understand why our Scala codes could run
  /*
  Scala application is only a Scala object with a very important method called 'main'
  It has to be defined the same way below:
  def main(args: Array[String]): Unit => it has to be exactly the same, because Scala applications are turned into Java Virtual Machine
  applications whose entry point have to be 'public static void main(String args)

     */


  /*
  Final Observations:
  The major advantage of Scala object is that they can implement a singleton pattern in one line of code.
  Scala Companions: can access each other's private members.
  Scala is more OO than Java.

  Scala Applications: are Scala objects with the main method definition or something that extends app.
   */
}
