/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    //-- Funcion Lambda de una sola linea (con dos parametros)
	val saludo: (String, String) -> String = { nombre, apellido -> "Hola, $nombre $apellido" }
	println(saludo("Juan", "Perez"))
    //-- Funciones Lambda de varias lineas (la ultima linea es lo que se retorna)
    val operacion: (Int, Int, Int) -> Int = { a, b, c ->
        println("Suma: ${a + b + c}")
        println("Producto: ${a * b * c}")
        (a + b + c) + (a * b * c) // Retorna la suma y el producto
	}
    println(operacion(2, 3, 5))
    //-- Funciones de Alto Orden (que reciben parametros)
    println(operar(5, 10, ::sumar)) // Salida: 15
    println(operar(5, 10, ::multiplicar)) // Salida: 50
    println(operar(5, 10) { x, y -> x * y }) // Salida: 50
    //-- Funciones Lambda con colecciones
    var numeros = listOf(2, 5, 7, 11, 22, 6, 14, 13, 24)
    var listaNumPares0 = numeros.filter { num -> num % 2 == 0 }
    var listaNumPares1 = numeros.filter { it % 2 == 0 }
    var listaNumPares2 = mutableListOf<Int>()
    for (i in numeros) {
        if (i % 2 == 0) {
            listaNumPares2.add(i)
        }
    }
    println("Numeros iniciales: $numeros")
    println("Numeros pares 1 (con Lambda): $listaNumPares1")
    println("Numeros pares 2 (con bucle for): $listaNumPares2")
}

//-- Funcion de una sola linea
fun cuadrado1(numero: Int): Int = ( numero * numero )

//-- Ejemplo de funciones de alto orden (pueden tanto recibir como parametro una funcion como tambien pueden retornarla)
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
	return operacion(a, b)
}
fun sumar(a: Int, b: Int): Int = a + b
fun multiplicar(a: Int, b: Int): Int = a * b


