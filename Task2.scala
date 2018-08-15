import scala.annotation.tailrec

object Task2 {

  @tailrec
  def factorial(number: BigInt, fact: BigInt = 1): BigInt =
    {
      if (number == 0)
        return fact
      else
        factorial(number - 1, fact * number)
    }
  def main(args: Array[String]) {
    val number: BigInt = 12
    //val fctrl : BigInt =
    println(factorial(number))
  }
}