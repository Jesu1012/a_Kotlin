import kotlin.math.PI

fun calcularArea(radio: Double): Double {
    return PI * radio * radio
}

fun calcularArea(lado: Float): Float {
    return lado * lado
}

fun calcularArea(base: Double, altura: Double): Double {
    return base * altura
}

fun main___() {
    var opcion: Int
    var juegoActivo = true

    while (juegoActivo) {
        opcion = menu1()
        when (opcion) {
            1 -> {
                // Círculo
                print("Ingrese el radio del círculo: ")
                val radio = readLine()?.toDoubleOrNull() ?: 0.0
                val area = calcularArea(radio)
                println("El área del círculo es: $area")
            }
            2 -> {
                // Cuadrado
                print("Ingrese el lado del cuadrado: ")
                val lado = readLine()?.toFloatOrNull() ?: 0.0f
                val area = calcularArea(lado)
                println("El área del cuadrado es: $area")
            }
            3 -> {
                // Rectángulo
                print("Ingrese la base del rectangulo: ")
                val base = readLine()?.toDoubleOrNull() ?: 0.0
                print("Ingrese la altura del rectangulo: ")
                val altura = readLine()?.toDoubleOrNull() ?: 0.0
                val area = calcularArea(base, altura)
                println("El área del rectángulo es: $area")
            }
            4 -> juegoActivo = false
        }
    }
}
