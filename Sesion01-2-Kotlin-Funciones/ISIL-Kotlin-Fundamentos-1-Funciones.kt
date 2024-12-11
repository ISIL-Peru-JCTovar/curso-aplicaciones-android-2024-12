/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
	println(saludar("Martin Ventura"))
    var resultadoSaludo2: String = saludar("ISIL")
    println(resultadoSaludo2)
    saludoSinDevolver("Henry Chuco")
    var resultadoSuma1: Int = sumar(5, 6, 7)
    println(resultadoSuma1)
    var resultadoSuma2: Int = sumar(5, 6)
    println(resultadoSuma2)
    var resultadoCuadrado1 = cuadrado1(6);
    println(resultadoCuadrado1)
    var resultadoCuadrado2 = cuadrado2(6);
    println(resultadoCuadrado2)
    var resultadoFactorial = calcularFactorial(5)
    println(resultadoFactorial)
    var resultadoDatosCompletos1 = obtenerDatosCompletos("Juan Gabriel")
    println(resultadoDatosCompletos1)
    var operacion = obtenerOperacion("suma")
	println("Suma: ${operacion(12, 3)}")
	operacion = obtenerOperacion("resta")
    println("Resta: ${operacion(12, 3)}")
    operacion = obtenerOperacion("multiplicacion")
    println("Multiplicacion: ${operacion(12, 3)}")
    operacion = obtenerOperacion("division")
    println("Division: ${operacion(12, 3)}")
}

//-- Funcion clasica que devuelve algo, en este caso, una cadena (String)
fun saludar(nombre: String): String {
	return "Hola, $nombre"
}

//-- Funcion clasica que no devuelve nada
fun saludoSinDevolver(nombre: String) {
	println("Hola, $nombre")
}

//-- Funcion con mas de un parametro (con el tercer parametro con valor por defecto)
fun sumar(a: Int, b: Int, c: Int = 10): Int {
	return a + b + c
}

//-- Funciones con una sola expresion (una sola linea) - cuadrado1
//-- es igual en expresion a la funcion cuadrado2
fun cuadrado1(numero: Int): Int = ( numero * numero )
fun cuadrado2(numero: Int): Int {
    return (numero * numero)
}

//-- Funciones anidadas
//-- Ej. Factorial: 3 = 1x2x3 = 6, 4 = 1x2x3x4 = 24
fun calcularFactorial(n: Int): Int {
	fun factorialRecursivo(num: Int): Int {
		return if (num <= 1) 1 else num * factorialRecursivo(num - 1)
	}
	return factorialRecursivo(n)
}

//-- Funciones anidadas (otro ejemplo)
fun obtenerDatosCompletos(n: String): String {
	fun obtenerNombres(nom: String): String {
		fun obtenerPrimerNombre(nom1: String): String {
            return nom1.substring(0, nom1.indexOf(" ")).trim()
        }
		fun obtenerSegundoNombre(nom2: String): String {
            return nom2.substring(nom2.indexOf(" ")).trim()
        }
        return obtenerPrimerNombre(nom) + " " + obtenerSegundoNombre(nom)
	}
    fun obtenerApellidos(ape: String): String {
        return ape
    }
	return obtenerNombres(n) + " " + obtenerApellidos("Lopez")
}

//-- Funcion que retorna una funcion
fun obtenerOperacion(tipo: String): (Int, Int) -> Int {
	return when (tipo) {
		"suma" -> { a, b -> a + b }
        "resta" -> { a, b -> a - b }
		"multiplicacion" -> { a, b -> a * b }
        "division" -> { a, b -> a / b }
		else -> { _, _ -> 0 }
	}
}




