package lectures.part2oop

object Exceptions extends App {
  val x: String = null
//  println(x.length)
  // ^^ this will crash with a NPE

  // 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43 // println("caught a Runtime exception")
  } finally {
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

//  throw exception

  // Out of memory exception:
//  val array = Array.ofDim(Int.MaxValue)

  // stackoverflow:
//  def infinite: Int = 1 + infinite
//  val noLImit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
}

