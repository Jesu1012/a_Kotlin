
fun menu1(): Int {
    var response: Int? = null // Initialize with a nullable type

    println("\tEjercicio 2\t")
    println("1) Circulo.")
    println("2) Cuadrado.")
    println("3) Rectangulo.")
    println("4) Salir.")

    while (true) {
        print("Enter your choice: ")
        response = readLine()?.toIntOrNull()

        if (response == null) {
            println("\t\t\t(-)Error: Please enter a valid number.")
        } else if (response !in 1..4) {
            println("\t\t\t(-)Error: Please enter an available option.")
        } else {
            break
        }
    }

    return response!! // Force unwrap, as we know it's not null here
}


fun main__() {
    val areaCirculo: (Double) -> Double = { radio -> Math.PI * radio * radio }
    val areaCuadrado: (Double) -> Double = { lado -> lado * lado }
    val areaRectangulo: (Double, Double) -> Double = { base, altura -> base * altura }

    var opcion: Int
    var juegoActivo = true

    while (juegoActivo) {
        opcion = menu1()
        when (opcion) {
            1 -> {
                // Círculo
                print("Ingrese el radio del círculo: ")
                val radio = readLine()?.toDoubleOrNull() ?: 0.0
                val area = areaCirculo(radio)
                println("El área del círculo es: $area")
            }
            2 -> {
                // Cuadrado
                print("Ingrese el lado del cuadrado: ")
                val lado = readLine()?.toDoubleOrNull() ?: 0.0
                val area = areaCuadrado(lado)
                println("El área del cuadrado es: $area")
            }
            3 -> {
                // Rectángulo
                print("Ingrese la base del rectángulo: ")
                val base = readLine()?.toDoubleOrNull() ?: 0.0
                print("Ingrese la altura del rectángulo: ")
                val altura = readLine()?.toDoubleOrNull() ?: 0.0
                val area = areaRectangulo(base, altura)
                println("El área del rectángulo es: $area")
            }
            4 -> juegoActivo = false
        }
    }
}
