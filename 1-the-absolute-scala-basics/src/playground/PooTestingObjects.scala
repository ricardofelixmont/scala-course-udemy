package playground

object PooTestingObjects {

  object Person {
    val name = "Ricardo"
    def showName: String = name
  }
  /* In order to make this program runnable we have to define the main method exactly the same way below,
  Or we can extend the App
   */
  def main(args: Array[String]): Unit = {
    println(Person.showName)
  }


}


