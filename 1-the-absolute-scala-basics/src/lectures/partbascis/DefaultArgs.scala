package lectures.partbascis

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {    // arguments with default values, nearly the same as in python...
    if (n <= 1) acc                // if we pass some value like trFact(5, 2), number '2' will overwrite the default arg
    else trFact(n-1, acc * n)
  }

  println(trFact(5, 1))


  /*
  Let's say we have an image editor program and we want to write a function that saves pictures...
   */

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture()

  /*
  Above we have some problems with default arguments:
  The interpreter can't recognize what arguments are being passed if we try to do this1: savePicture(800)
  It doesn't know whether it's the 'width', the 'height', even the 'format' can't be recognized.
  So we have to take care with when using default parameters.

  Observation: we have to put default parameters as last in the function:
  def savePic(par1: String, size: Int = 800): Unit = println('Saving')
   */
  def savePic(par1: String, size: Int = 800): Unit = println("Saving")

  savePic("Save")    // As we can see, here we've put the default args as the last parameter, so the compiler will be able to recognize the one.



  /*
  We can also:
  1. pass in every leading argument (passar sempre o primeiro argumento como paramentro)
      ex: savePicture("bpm"), if we do that, it will work normally.
  2. name the arguments
      ex: savePicture(width = 800), it will work too
   */
  // ex01:
  savePicture(width = 800) // as we can see it works very well...


  //  A good side effect of default args is that we can pass the arguments in different orders.
  savePicture(width = 800, format="String", height = 1200)

}


