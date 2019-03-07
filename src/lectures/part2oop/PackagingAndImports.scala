package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

object PackagingAndImports extends App {
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  val princess = new Princess

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
