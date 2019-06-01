package playground

// A Scala app could have one or more Objects or classes
object Application extends App {

  object Person {

    // build person given some parameters
    def factoryMethod(father: Person, mother: Person): Person = new Person("Gustavo")
  }
  // create a class and an object with the same name in the same file, it's called a COMPANION.
  class Person(val name: String) {

  }


  val ana = new Person("Ana")
  val claudio = new Person("Claudio")
  if (ana == claudio) println("They're equals") else println("They're not equals")

  val robert = Person
  val daniela = Person
  if (robert == daniela) println("They're equals") else println("They're not equals")

  // Pattern Factory Method:
  val ricardo = Person.factoryMethod(ana, claudio)
  println(ricardo.name)

}
