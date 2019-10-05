package exercices

import exercices.ExtendingMyCollection.{Cons, Empty}

object ExtendingMyCollection extends  App {

  // Aula 20 - Refazer

  // Test Area ------------------------------
  val list = new Cons(1, Empty) // this list is receiving the object(singleton) Empty as argument
  println(list.head)

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty))) // This is a linked list
  println(list2.tail.head) // new Cons(2, new Cons(3, Empty) is the reminder(tail), so '2' is the head of this list
  println(list2.add(4).head)
  println(list2.isEmpty)

  println(list2.toString)
//  --------------------------------



  abstract class MyList {

    /*
    Create a collection with the following methods:
   1 - head = first element of the list
   2 - tail = remainder of the list
   3 - isEmpty = is this list empty(it's a boolean)
   4 - add(int) => return a new list with this element added
   5 - toString => a string representation of the list
     */

    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Int): MyList
    def printElements: String // each subclass will give toString a different 'printElements' implementation

    override def toString: String = "[" + printElements + "]"


  }


  object Empty extends MyList {
    // ???(Nothing) is the same of 'pass' in python
    def head: Int = throw new NoSuchElementException // throws are expression that doesn't return 'Nothing' in Scala
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): MyList = new Cons(element, Empty)
    override def printElements: String = "" // return a void String


  }

  class Cons(h: Int, t: MyList) extends MyList {

    def head: Int = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    def add(element: Int): MyList = new Cons(element, this)
    override def printElements: String =
      if (isEmpty) "" + h
      else h + " " + t.printElements
  }


  // Extending my Collection
  trait MyPredicate[-T] { // Contravariant - An animal(cat) can train a lot of other animals
    def test(elem: T): Boolean

  }


  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

}
