package lectures.partbascis

// Call by name vs Call by value
object CBNvsCBN extends App {

  def calledByValue(x: Long): Unit = {   // Call by value means that the parameter is evaluated before it's been shown...as we can see below:
    println("by value: " + x)    // println("by value: " + 72824394833467)
    println("by value: " + x)    // println("by value: " + 72824394833467) // as we can see, both expressions have the same value
    /*
    It occurs because callByValue, first evaluates the function and afterward it goes as argument...
     */
  }

  def calledByName(x: => Long): Unit = {   // the arrow here means that it's a 'called by name' argument...
    println("by name: " + x)   // println("by name: " + System.nanoTime()) 72824394833467
    println("by name: " + x)   // println("by name: " + System.nanoTime()) 72824555583121
    /* as we can see, it has other value, it occurs because callByName get the name of the function and passes as argument...
    and afterward evaluates the function, giving us different values, cause they're evaluated in different time...
    The function is evaluated every time we call that, every time we use the function...
     */
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def infinite(): Int =  + infinite()  // if it run, it will crash with a StackOverFlow error...
  def printFirst(x: Int, y:  => Int) = println(x)

  // printFirst(infinite(), 34) // here it crashes because i'm first evaluating the infinite() function and afterward using that..
  printFirst(34, infinite())   // it doesn't crashes because what is passed as argument is the function and not the value...
  // and as the 'y' parameter is not called anywhere it's not being evaluated, so it wont crash never in this example...

}
