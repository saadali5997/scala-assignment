import scala.annotation.tailrec

object Task2 {
    
    @tailrec
    def factorial(number: Int, fact : Int = 1) : Int = 
    {
      if(number == 0)
        return fact
      else
        factorial(number - 1, fact*number)
    }
    def main(args: Array[String]) {
      println(factorial(5))
    }
}