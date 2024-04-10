//fun main() {
//    birthdayGreeting()
//}
//
//fun birthdayGreeting() {
//    println("Happy Birthday, Rover!")
//    println("You are now 5 years old!")
//}

//fun main() {
//    birthdayGreeting()
//}
//
//fun birthdayGreeting(): Unit {
//    println("Happy Birthday, Rover!")
//    println("You are now 5 years old!")
//}
//fun main() {
////    val greeting = birthdayGreeting()
////    println(greeting)
//    println(birthdayGreeting())
//
//}
//
//
//
//fun birthdayGreeting(): String {
//    val nameGreeting = "Happy Birthday, Rover!"
//    val ageGreeting = "You are now 5 years old!"
//    return "$nameGreeting\n$ageGreeting"
//}
//fun main() {
//    println(birthdayGreeting("Rover"))
//    println(birthdayGreeting("Rex"))
//
//}
//
//fun birthdayGreeting(name: String): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now 5 years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

//fun birthdayGreeting(name: String, age: Int): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now $age years old!"
//    return "$nameGreeting\n$ageGreeting"
//}
//fun main() {
//    println(birthdayGreeting("Rover", 5))
//    println(birthdayGreeting("Rex", 2))
//}

//fun birthdayGreeting(name: String, age: Int): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now $age years old!"
//    return "$nameGreeting\n$ageGreeting"
//}
//fun main() {
//    println(birthdayGreeting(name = "Rover", age = 5))
//
//    println(birthdayGreeting(age = 2, name = "Rex"))
//
//}
// fun main() {
//    println(birthdayGreeting(age = 5))
//    println(birthdayGreeting("Rex", 2))
//
//
//}

 fun main() {
     println(birthdayGreeting(age = 5))
     println(birthdayGreeting(age = 2))



 }

fun birthdayGreeting(name: String = "Rover", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}

