package exercices

object MyListGeneric extends App {

  abstract class MyList [+A] {

    /*
    Create a collection with the following methods:
   1 - head = first element of the list
   2 - tail = remainder of the list
   3 - isEmpty = is this list empty(it's a boolean)
   4 - add(int) => return a new list with this element added
   5 - toString => a string representation of the list
     */

    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyList[B]
    def printElements: String // each subclass will give toString a different 'printElements' implementation

    override def toString: String = "[" + printElements + "]"

  }


  object Empty extends MyList[Nothing] {
    // ???(Nothing) is the same of 'pass' in python
    def head: Nothing = throw new NoSuchElementException // throws are expression that doesn't return 'Nothing' in Scala
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    override def printElements: String = "" // return a void String

  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    override def printElements: String =
      if (isEmpty) "" + h
      else h + " " + t.printElements
  }




    val listOfIntegers: MyList[Int] = new Cons(2, new Cons(3, Empty))
    val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)


}
