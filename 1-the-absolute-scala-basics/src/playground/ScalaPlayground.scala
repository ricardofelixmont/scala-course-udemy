package playground

object ScalaPlayground { // it's the document where all my classes and objects are declared, every code here will be executed
  println("Hello, Scala") // it's printed but i don't know why...

  // Testing singleton and companion
  object Person {
    val name = "Ricardo"
    val age = 25
  }

  class Person(name: String, age: Int) {
    def showInfo: Unit = {
      println(s"My name is $name and i'm $age years old.")
    }
  }

  def main(args: Array[String]): Unit = { // this is the why this application can run
    /*
    It's turned into JVM in a Scala Application and it needs a Array of Strings.
     */
    // Now it's runnable
    println(Person.name) // here i'm using the singleton without a pointer, only using the Person object

    val newPerson = Person // now i'm using a pointer to the singleton object
    println(newPerson.name) // now i'm calling the name field

    val someone = new Person("Mary", 25)
    someone.showInfo
   // Above i've used the COMPANION pattern.


  }
}
