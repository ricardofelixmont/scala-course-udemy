package playground

object PooTesting extends App {

  class Author(val authorName: String, val birthYear: Int){
    /*
    It's a postfix method
     */
    def information: String = s"Author name: $authorName\nAuthor Birth Year: $birthYear"
  }


  class Book(title: String, releaseYear: Int, author: Author) {

    def bookInfo: String = s"Name: $title\nAuthor: ${author.authorName}\nAuthorAge: ${releaseYear - author.birthYear}"
  }


  val tolkien = new Author("JRR Tolkien", 1914)
  println(tolkien information)

  val lot = new Book("Lord Of The Rings", 2018, tolkien)
  println(lot bookInfo)







}
