package lectures.part2oop

/**
 * Created by Ricardo
 */

object CaseClasses extends App {

  /*

  equals, hashCode, toString
   */

  class Animal(val name: String) // the 'name' parameters is a field of this class because of the val reserved word
  class Dogs(name: String) // The 'name' parameter is no a field, but a class parameter.
  /*
  If we instantiate those classes:
   */
  val spock = new Animal("Spock") // We can't access the parameter like this: spock.name -> it's wrong
  val joselito = new Dogs("Joselito") // We can access the parameter like this: joselito.name because it's a field of this class



  // Case Classes

  case class Person(name: String, age: Int)
  /*
  In a case class, all parameter are field of this class, so we can access this field whenever we want
  like: jim.name
   */
  // 1. class parameters are fields
  val jim = new Person("Jim", 25)
  println(jim.name)

  /* 2. sensible toString
  println(instance) = println(instance.toString) -> syntactic sugar
  */
  println(jim.toString)

  // 3. Equals and hashCode implemented OOTB(Out of the Box)
  val jim2 = new Person("Jim", 25)
  println(jim == jim2) // if it's a 'case class' it will return true, if not will return false, because the equals method if not implemented


  // 4. Case Classes have handy copy method
  val jim3 = jim.copy() // Creates a new instance of this case class
  val jim4 = jim.copy(name= "Ricardo") // copy receives named parameters

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // Person() call the apply method, that gives us the feature of instantiate a class as if it's a method
  // We don't use the 'new' clause to instantiate a CC, we use it like the apply method

  /* 6. CCs are serializable
  It makes CCs especially useful when dealing with distributed systems:
  You can send instances of case classes through the network and in between JVM
   */

  /* 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
   */

  case object UnitedKingdom { // Have the same properties of the CCs, excepting they don't have companion objects
    def name: String = "The UK of GB and NI"
  }

}
