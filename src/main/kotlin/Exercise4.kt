
val contactos = mutableMapOf<String, Pair<String, String>>()

fun agregarContacto(nombre: String, telefono: String, email: String) {
    if (nombre.isEmpty()) {
        println("(-)Error: El nombre del contacto no puede estar vacío.")
        return
    }
    if (telefono.isEmpty()) {
        println("(-)Error: El telefono del contacto no puede estar vacío.")
        return
    }
    if (email.isEmpty()) {
        println("(-)Error: El correo electronico del contacto no puede estar vacío.")
        return
    }

    contactos[nombre] = Pair(telefono, email)
    println("Contacto $nombre añadido correctamente.")
}


fun actualizarContacto(nombre: String, telefono: String, email: String) {
    if (contactos.containsKey(nombre)) {
        contactos[nombre] = Pair(telefono, email)
        println("Contacto $nombre actualizado correctamente.")
    } else {
        println("(-)Error: El contacto $nombre no existe.")
    }
}

fun eliminarContacto(nombre: String) {
    if (contactos.remove(nombre) != null) {
        println("Contacto $nombre eliminado correctamente.")
    } else {
        println("(-)Error: El contacto $nombre no existe.")
    }
}

fun mostrarContactos() {
    if (contactos.isEmpty()) {
        println("No hay contactos en la agenda.")
    } else {
        for ((nombre, datos) in contactos) {
            println("Nombre: $nombre")
            println("Telefono: ${datos.first}")
            println("Correo electronico: ${datos.second}")
            println("----------------------")
        }
    }
}
fun menu3(): Int {
    var response: Int? = null // Initialize with a nullable type

    println("\tEjercicio 5\t")
    println("1) Añadir.")
    println("2) Actualizar.")
    println("3) Eliminar.")
    println("4) Mostrar.")
    println("5) Salir.")

    while (true) {
        print("Enter your choice: ")
        response = readLine()?.toIntOrNull()

        if (response == null) {
            println("\t\t\t(-)Error: Please enter a valid number.")
        } else if (response !in 1..5) {
            println("\t\t\t(-)Error: Please enter an available option.")
        } else {
            break
        }
    }

    return response!! // Force unwrap, as we know it's not null here
}
fun main() {
    var opcion: Int
    var juegoActivo = true

    while (juegoActivo) {
        opcion = menu3()
        when (opcion) {
            1 -> {
                print("Introduzca el nombre del contacto: ")
                val nombre = readLine()?.toString() ?: ""
                print("Introduzca el telefono del contacto: ")
                val telefono = readLine()?.toString() ?: ""
                print("Introduzca el correo electronico del contacto: ")
                val email = readLine()?.toString() ?: ""

                agregarContacto(nombre, telefono, email)
            }
            2 -> {
                print("Introduzca el nombre del contacto a actualizar: ")
                val nombre = readLine()?.toString() ?: ""
                print("Introduzca el nuevo telefono del contacto: ")
                val telefono = readLine()?.toString() ?: ""
                print("Introduzca el nuevo correo electronico del contacto: ")
                val email = readLine()?.toString() ?: ""

                actualizarContacto(nombre, telefono, email)
            }
            3 -> {
                print("Introduzca el nombre del contacto a eliminar: ")
                val nombre = readLine()?.toString() ?: ""

                eliminarContacto(nombre)
            }
            4 -> mostrarContactos()
            5 -> juegoActivo = false
        }
    }
}