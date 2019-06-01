package lectures.part2oop

object Polymorphism {

  def main(args: Array[String]): Unit ={

  }


  class Animal {
    def eat: Unit = println("Animal eating...")
  }

  class Dog extends Animal {

    override def eat: Unit = println("Dog eating...")
  }

  // type substitution (broad: polymorphism
  //  Here we instantiate a dog but of type Animal
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat // the 'eat' method used here will show " println("Dog eating...") "

  // overRIDING vs overLOADING
  /*
  1 - overRidding: rewrite the method in the subclass
  2 - overLoading: create methods with the same name, but with different signatures
   */


  // SUPER
  /*
  If i want to use the method or attribute of the superclass i have to use 'super.method'
   */
  class Professor {
    def message: Unit = println("Superclass Method")
  }

  class AnotherProfessor extends Professor{
    override def message = println("SubClass Method")
    super.message // here i'm using the superclass method, not the subclass method
  }

  val prof: Professor = new AnotherProfessor
  prof.message


  // PREVENTING OVERRIDING: if i don't want that a method could be overwritten
  /*
  1 - Use final on member
    Ex: final def myMethod = println("Method") -> this method cannot be overwritten

  2 - Use final on the entire class
    Ex: final class MyClass -> any method of this class can't be overwritten, and i don't need to use final in the method

  3 - Seal the class => Can extend classes in THIS FILE, but prevent extension in OTHER FILES.
      use that if you want to have more control about the inheritance in your project, all the extended classes will be in a
      specific file, and than you can only instantiate then in another file
    Ex: sealed class MyClass
   */

}
