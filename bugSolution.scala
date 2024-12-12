```scala
class MyClass(val name: String) {
  private var _age: Int = 0

  def age: Int = _age
  def age_=(newAge: Int): Unit = {
    try {
      if (newAge < 0) {
        throw new IllegalArgumentException("Age cannot be negative")
      }
      _age = newAge
    } catch {
      case e: IllegalArgumentException => {
        println(s"Error setting age: ${e.getMessage}")
        // Log the error or take other appropriate action
      }
      case e: Exception => {
        println(s"Unexpected error setting age: ${e.getMessage}")
        //Handle other unexpected exceptions
      }
    }
  }
}

object Main extends App {
  val myObj = new MyClass("John")
  myObj.age = 30
  println(myObj.age) // prints 30
  myObj.age = -5  // Prints error message instead of crashing
  myObj.age = 35
  println(myObj.age) //prints 35
}
```