package lectures.partbascis

/*
Takeaways:

we've learned:
 1. how to declarate vals and vars:
     val x: Int = 2
     var y = Int = 4

 2. vals are immutable (can't be reassigned) and variables are mutable(can be reassigned)
    we can't do that:  val x: Int = 20
                        x = 30 // as we've learnet vals can't be reassigned...
    but we can do this:
        var newVariable: Int = 20
        newVariable += 1

 3. Prefer vals over vars -> functional programming involves working less with variables and using more vals...

 4. All vals and vars have types...and types can be infer by the compiler, it's not necessary to explicit the type of
 our vals and vars -> val x = 10


 5. we've seen some data types such as:
 *Boolean
 * Int, Long, Double
 * String

 */


object ValuesVariablesTypes extends App {
  /* Para declarar um valor em Scala fazemos:
  val nome_da_variavel: tipo_da_variavel = valor
   */
  val x: Int = 42  // Posso explicitar o tipo de Valor
  println(x)
  val y = "Uma string"   // Se eu não explicitar o tipo, o compilador faz isso automaticamente
  /* na maioria das vezes não é necessário explicitar o tipo, apenas para deixar o código mais legivel, o compilador
   é inteligente o suficiente para inferir qual tipo de valor queremos declarar.*/
  println(y)
  // 'vals' são imutáveis, não podemos atribuir novos valores a elas depois de criadas, exemplo: x = 2


  val minhaString: String = "Minha String com tipo explicito"
  println(minhaString)

  /* Uma objservação sobre o uso do ';' (ponto e vírgula)
  Não é realmente necessário coloca o ponto e vírgula em Scala, apenas quando queremos fazer multiplas expressões
  na mesma linha...
  Ex:
    val minhaString: String = "String"; val meuInt: Int = 10;
    Podemos também como abaixo:
    val minhaString: String = "String";
    val meuInt: x = 10
*/

  val umBoolean: Boolean = true; val outroBoolean: Boolean = false;
  val achar: Char = 'a'
  println(achar)


  val anInt: Int = x
  println(x)

  val aShort: Short = 9999 // é representado em 2 bytes ao inves de 4 como é o caso do int
  val aLong: Long = 52735456745646546L // representa o dobro do tipo Int, no caso 8 bytes ao inves de 4.
  /* quando colocamos um numero muito grande como Long, precisamos colocar um 'L' no final para afirmar que o numero é
   realmente um 'Long'. Se nao colocarmos o L no final ele vai entender que o número é um Int mesmo colocar o tipo
  como Long.*/
  val aFloat: Float = 2.0f  /* como no java preiso colocar o 'f' no final para que ele entenda que é um Float, caso
  contrario ele vai reconhecer como sendo um Double*/

  val aDouble: Double = 3.14




  // Variaveis em Scala
  var aVariable: Int = 4
  var myVariable = "String"   // assim como nas 'vals', o compilador consegue inferir qual o tipo de variavel criamos
  println(myVariable)
  /*
  Variaveis são mutaveis, podemos atribuir novos valores mesmo depois de criadas.
   */
  aVariable = 5  //  side effects = são uteis pois nos permite saber o que os programas estão fazendo
  /* Programas sem side effects são muito simples de entender pois não tem variaveis e nao tem logica para manter.*/


}
