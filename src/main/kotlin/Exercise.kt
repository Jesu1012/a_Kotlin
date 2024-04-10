import java.util.*

class Student {
    var name: String = ""
    var lastname: String = ""
    var codeStudent: String = ""
    var age: Int = 0

    fun setData(nameData: String, lastnameData: String, codeStudentData: String, ageData: Int) {
        name = nameData
        lastname = lastnameData
        codeStudent = codeStudentData
        age = ageData
    }

    fun getData(): String {
        return """
            ------------------------
            Nombre: $name
            Apellido: $lastname
            Numero de identificacion: $codeStudent
            Edad: $age
            ------------------------
        """.trimIndent()
    }

    fun getCode(): String {
        return codeStudent
    }

    fun retrieveName(): String {
        return name
    }

    fun retrieveLastname(): String {
        return lastname
    }

    fun retrieveAge(): String {
        return if (age == 0) "" else age.toString()
    }
}

val listStudent = mutableListOf<Student>()

enum class Estado {
    Agregar,
    Actualizar
}

var estado = Estado.Agregar
val studentPorDefecto = Student()

fun addStudent(Modo: String, studentM: Student = studentPorDefecto): Student {
    val student = Student()
    var name: String
    var lastname: String
    var codeStudent: String
    var age: Int
    val scanner = Scanner(System.`in`)
    println(Modo)
    if (estado == Estado.Actualizar) {
        name = studentM.name
        lastname = studentM.lastname
        codeStudent = studentM.codeStudent
        print("Edad: (${studentM.retrieveAge()})")
        age = scanner.nextInt()
    } else {
        print("Nombre: (${studentM.retrieveName()})")
        name = scanner.nextLine()
        print("Apellido: (${studentM.retrieveLastname()})")
        lastname = scanner.nextLine()
        print("Codigo de identificacion: (${studentM.getCode()})")
        codeStudent = scanner.nextLine()
        print("Edad: (${studentM.retrieveAge()})")
        age = scanner.nextInt()
    }
    student.setData(name, lastname, codeStudent, age)
    return student
}

fun findStudent(code: String): Student {
    var student = Student()
    var encontrado = false
    for (it in listStudent) {
        if (it.getCode() == code) {
            student = it
            encontrado = true
            break
        }
    }
    if (!encontrado) {
        println("No se encontro")
    }
    return student
}

fun menu(): Int {
    var response: Int
    val scanner = Scanner(System.`in`)
    println("\tEjercicio 1\t")
    println("1) Agregar.")
    println("2) Listar.")
    println("3) Buscar.")
    println("4) Actualizar.")
    println("5) Eliminar.")
    println("6) Salir.")

    while (true) {
        print("Enter your choice: ")
        response = scanner.nextInt()
        if (response !in 1..6) {
            println("\t\t\t(-)Error: Please enter an available option.")
        } else {
            break
        }
    }

    return response
}

fun main_() {
    var opcion: Int
    var juegoActivo = true
    var code = ""
    var studentEncontrado: Student
    var studentModificado: Student
    val scanner = Scanner(System.`in`)
    while (juegoActivo) {
        opcion = menu()
        when (opcion) {
            1 -> {
                println()
                estado = Estado.Agregar
                listStudent.add(addStudent("Agregar:"))
            }
            2 -> {
                println()
                for (it in listStudent) {
                    println(it.getData())
                }
            }
            3 -> {
                println()
                print("\tBuscar :\nCodigo de identificacion :")
                code = scanner.nextLine()
                studentEncontrado = findStudent(code)
                if (studentEncontrado.getCode().isEmpty()) {
                    println("No se encontro")
                } else {
                    println(studentEncontrado.getData())
                }
            }
            4 -> {
                println()
                println("\tActualizar :")
                print("Codigo de identificacion :")
                code = scanner.nextLine()
                estado = Estado.Actualizar
                studentEncontrado = findStudent(code)
                if (studentEncontrado.getCode().isEmpty()) {
                    println("No se encontro")
                } else {
                    studentModificado = addStudent("Actualizar", studentEncontrado)
                    for (it in listStudent) {
                        if (it.getCode() == code) {
                            it.setData(studentModificado.name, studentModificado.lastname, studentModificado.codeStudent, studentModificado.age)
                            break
                        }
                    }
                }
            }
            5 -> {
                println()
                print("Eliminar:\nCodigo de identificacion:")
                code = scanner.nextLine()
                listStudent.removeIf { it.getCode() == code }
            }
            6 -> juegoActivo = false
        }
    }
}
