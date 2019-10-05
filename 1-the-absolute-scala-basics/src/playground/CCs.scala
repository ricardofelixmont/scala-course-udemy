package playground

object CCs extends App {


  case class BrancaDeNeve(name: String) {

  }

  object BrancaDeNeve {
    def printa(a: BrancaDeNeve) = println(a)
  }

  val n = BrancaDeNeve.printa(BrancaDeNeve(""))

}
