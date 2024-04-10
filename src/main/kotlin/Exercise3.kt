fun validarFecha(fecha: String): Boolean {
    val regex = Regex("""^\d{4}-\d{2}-\d{2}$""")
    return regex.matches(fecha)
}

fun menu2(): Int {
    var response: Int? = null // Initialize with a nullable type

    println("\tEjercicio 4\t")
    println("1) Agregar Eventos.")
    println("2) Ver Evento por fecha.")
    println("3) Ver todos los eventos.")
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


fun main____(){

    val eventos = mutableListOf(
        Triple("2024-04-10", "Reunión", "Discusion del proyecto que salio mal."),
        Triple("2024-04-12", "Cita", "Cita con Rosa."),
        Triple("2024-04-12", "Evento", "Ampliar mi red de contactos."),
        Triple("2024-04-10", "Taller de formación", "Aprender sobre c++."),
    )
    eventos.add(Triple("2024-04-19", "Cumpleaños", "Celebrar mi cumplea;os"))
    eventos.add(Triple("2024-04-20", "Saliral cine", "Ver oppenheimer"))

    fun buscarEventos(fecha: String): List<Pair<String, String>> {
        val eventosEncontrados = mutableListOf<Pair<String, String>>()
        for (evento in eventos) {
            if (evento.first == fecha) {
                eventosEncontrados.add(Pair(evento.second, evento.third))
            }
        }
        return eventosEncontrados
    }

    var opcion: Int
    var juegoActivo = true
    var fecha = "0.0"
    var titulo = ""
    var descripcion = ""
    while (juegoActivo) {
        opcion = menu2()
        when (opcion) {
            1 -> {
                var fechaValida = false
                while (!fechaValida) {
                    print("Introduzca la fecha del evento (aaaa-mm-dd): ")
                    fecha = readLine()?.toString() ?: "0.0"
                    fechaValida = validarFecha(fecha)
                    if (!fechaValida) {
                        println("(-)Error: La fecha introducida no es valida.")
                    }
                }

                var tituloValido = false
                while (!tituloValido) {
                    print("Introduzca el título del evento: ")
                    titulo = readLine()?.toString() ?: ""
                    tituloValido = titulo.isNotEmpty()
                    if (!tituloValido) {
                        println("(-)Error: El título del evento no puede estar vacío.")
                    }
                }

                var descripcionValida = false
                while (!descripcionValida) {
                    print("Introduzca la descripción del evento: ")
                    descripcion = readLine()?.toString() ?: ""
                    descripcionValida = descripcion.isNotEmpty()
                    if (!descripcionValida) {
                        println("(-)Error: La descripción del evento no puede estar vacía.")
                    }
                }

                eventos.add(Triple(fecha, titulo, descripcion))
                println("Evento añadido correctamente.")
            }
            2 -> {
                //val fechaBusqueda = "2024-04-10"
                print("Pon una fecha valida (aaaa-mm-dd): ");
                val fechaBusqueda = readLine()?.toString() ?: "0.0"
                val eventosEncontrados = buscarEventos(fechaBusqueda)

                println("Eventos encontrados para la fecha $fechaBusqueda:")
                for (evento in eventosEncontrados) {
                    println("- ${evento.first}: ${evento.second}")
                }
            }
            3 -> {
                for (evento in eventos) {

                    println("${evento.first} - ${evento.second} : ${evento.third}")

                }
            }
            4 -> juegoActivo = false
        }
    }







}
