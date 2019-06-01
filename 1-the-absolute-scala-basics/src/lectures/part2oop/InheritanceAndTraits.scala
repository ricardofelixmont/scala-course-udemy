package lectures.part2oop

object InheritanceAndTraits {

 def main(args: Array[String]): Unit = {

  // TESTING INHERITANCE
  val bob = new Cat("Bob")
  bob.showName
  bob.showCatName

  /*bob.animalName -> I can't do that, because it's private val that can be accessed only from an Animal instance
    it can't be done from an Cat instance, even if it's a subclass of animal */

  /* bob.animalName2 -> I can't do that too, the protected prefix allows us to use the val inside the subclass but we
     can't call this val from outside the class like: bob.animal2
     We can only do:
  def showName: String =
         Animal.animalName2
   */

   bob.useProtectedVal()





 }


 // INHERITANCE
 class Animal {

  /*
  In Scala we have 3 modifiers: private, protected and default(don't put nothing as prefix)
   */
  private val animalName = "Bob the Cat"

  protected val animalName2 = "Bob the great cat"

  val name = "Bob"
  // A class with an attribute and a method
  def showName: Unit = println("This is the animal Class")

 }


 class Cat(name: String) extends Animal {

  val this.name = name

  def showCatName = println(name)

  def useProtectedVal(): Unit = println(animalName2)
 }


 // CONSTRUCTORS

 /*
 This is the way we extend a class with constructor
 */
 class Person(name: String, age: Int)
 class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

 /*
 If we have a superclass with alternative constructor: def this(name: String) for example
  */
 class Client(name: String, age: Int){
  /*
  1 - It receives the parameters of the alternative constructor
   */
   def this(name: String) = this(name, 0) // here age is a default parameter
   def this() = this("", 0) // It's a default constructor, through this we can instantiate this class without give args
 }

 class SpecificClient(name: String, age: Int, cardNumber: String) extends Client(name)


 // OVERRIDING
 class Professor {
  val professorName:String = "Igor"
  def myMethod(): Unit = println("MyMethod")
 }

 class SpecificProfessor extends Professor {
  /*
  we can override either methods and val's
   */
  override def myMethod(): Unit = println("Overrided MyMethod")
  override val professorName = "Jose"
 }

 val jose = new SpecificProfessor()
 jose.myMethod()
 println(jose.professorName)

 // We can override directly in the constructor, with the parameter received
 class AnotherProfessor(override val professorName: String) extends Professor{

 }

 // We also can override as follow
 class AnotherOtherProfessor(name: String) extends Professor {

  override val professorName = name

 }

 val hamilton = new AnotherOtherProfessor("Hamilton")
 println(hamilton.professorName)



}
