package lectures.part2oop

object Generics extends App {

// class MyList[A] {
//   // The 'A' in the brackets denotes that it's a generic type, and we can use that in the scope of the class as follows:
// }

 class MyList [+A] {
  def add[B >: A] (element: B): MyList [B] = ???   // >: say that 'B' is a supertype of 'A'
  /*
  A = Cat
  B = Dog = Animal, so B = Animal
   */
 }

 class MyMap[Key, Value] // as we can see, we can use as many Generics as we want...

  val listOfIntegers = new MyList[Int]  // The generic type will be replaced by 'Int'
  val listOfStrings = new MyList[String]

 // generic methods
 object MyList {
   def empty [A]: MyList[A] = ???
 }

 // val emptyListOfIntegers = MyList.empty[Int]

 // Variance problem...

 class Animal
 class Cat extends Animal
 class Dog extends Animal

  // Question 1 : If Cat extends Animal, does a list of Cats also extends a list of Animals?

  // yes List[Cat] extends List[Animal] = COVARIANCE

 class CovariantList[+A] // '+A' means that it's a Covariant List.
 val animal: Animal = new Cat
 val animalList: CovariantList[Animal] = new CovariantList[Cat]


 // Question 2: can i add any animal at this Covariant List like: animalList.add(new Dog), this is a HARD QUESTION => we
 // return a  list of Animals
 // No = INVARIANCE

 class InvariantList[A]
 val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // can't do ...new InvariantList[Cat]

 // 3. Hell, not CONTRAVARIANCE
 class Trainer[-A]
 val trainer: Trainer[Cat] = new Trainer[Animal] // I can have an animal trainer that can train lot of animals type.




 // BOUNDED TYPES: Allows you to use certain types of data...
 class Cage[A <: Animal](animal: A) // Cage only accept 'A', that are subtypes(subclass) of 'Animal'
 val cage = new Cage(new Dog)


 class Car
 // val newCage = new Cage(new Car) // I can't do that, because 'Car' is not a subtype/subclass of Animal...



 // Exercice


}



// TAKEAWAYS

/*
Use the Same code on many (potentially unrelated) types:

trait List[T] {
 def add(elem: T)
}

GENERIC METHODS

object  List {
 def single[A](element: A): List[A] = ???
 }

 MULTIPLE TYPE PARAMETERS

 trait Map[key, value] {
 }



 /// TAKEAWAYS 2
 Variance: if B extends A, should List[B] extend List[A]?
 3 Answers:
    trait List[+A] -> yes(covariant)
    trait List[A] -> no(invariant) - default
    trait List[-A] -> hell no! (contravariant)

    Bounded Types

    class Car
    class SuperCar extends Car
    class Garage[T <: Car](Car: T)

 */