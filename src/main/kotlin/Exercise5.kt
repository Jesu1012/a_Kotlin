data class Producto(val nombre: String, val categoria: String, val precio: Double)

fun filtrarProductos(productos: List<Producto>, categoria: String, precioMinimo: Double): List<Producto> {
    return productos.filter { it.categoria == categoria && it.precio >= precioMinimo }
}

fun obtenerNombresProductos(productos: List<Producto>): List<String> {
    return productos.map { it.nombre }
}

fun calcularPrecioPromedio(productos: List<Producto>, categoria: String): Double {
    return productos.filter { it.categoria == categoria }.map { it.precio }.average()
}
fun main(){
    val productos = listOf(
        Producto("Televisor", "Electrónica", 700.0),
        Producto("Cocina Electrica", "Electrodomésticos", 1100.0),
        Producto("Smartphone", "Electrónica", 500.0),
        Producto("Refrigeradora", "Electrodomésticos", 1400.0),
        Producto("Tablet", "Electrónica", 800.0),
        Producto("SmarthBand", "Electrónica", 90.0),
        Producto("Hervidor Electrico", "Electrodomésticos", 250.0),
    )


    val productosFiltrados = filtrarProductos(productos, "Electrónica", 100.0)


    val nombresProductos = obtenerNombresProductos(productosFiltrados)


    for (nombre in nombresProductos) {
        println(nombre)
    }


    val precioPromedio = calcularPrecioPromedio(productos, "Electrónica")

    println("Precio promedio (Electrónica): $precioPromedio")

}