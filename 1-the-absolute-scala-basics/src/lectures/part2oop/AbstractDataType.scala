package lectures.part2oop

object AbstractDataType extends App {

  // abstract - cannot be instantiated
  abstract class Animal {

    // Note that we're not implementing the items bellow
    val creatureType: String
    def eat: Unit
    def name: Unit = println("Abstract class can have implemented methods")
  }

  class Dog extends Animal {
    // here we're forced to implement the method and give a value to the val of 'Animal' class

    override val creatureType: String = "My OverWritten val"
    override def eat: Unit = println("My OverWritten method")
  }

  // trait - they are almost the same of interfaces in Java
  trait Carnivore {
    // It has no implementation too, it will be overwritten in the subclass
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded {
    def coldBlood: String
    def name: Unit = println("Traits can have implemented methods, the same goes to Abstract class")
  }
  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "From Animal"
    override def eat: Unit = println("From Animal")
    override def eat(animal: Animal): Unit = println("From Carnivore")
  }

  val croco = new Crocodile
  croco.eat


  // DIFFERENCES BETWEEN ABSTRACT CLASS AND TRAITS
  /*
  1 - Traits do not have constructor parameters
  2 - We can inhere multiple traits, but only one abstract class
  3 - Traits = Behavior | Abstract class = "Thing", while traits describe what those things do...
   */

}
