package playground

object InheritancePlayGround extends App {

  class Employee (name: String, cpf: String, salary: String) {

    private val _name = name
    private val _cpf = cpf
    private val _salary = salary

    // Getter
    def getName = _name
    def getCpf = _cpf
    def getSalary = _salary

  }

  // Polymorphism
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
  Dog and Cat extends animal, they're a 'Animal'
   */
  class CovariantList[+A] // List of generic type

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]


}
