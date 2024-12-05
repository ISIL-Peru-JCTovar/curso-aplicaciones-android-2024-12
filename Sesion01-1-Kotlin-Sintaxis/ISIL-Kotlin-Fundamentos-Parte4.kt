/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
const val IGV = 0.18

fun main() {
    /*
     * Parte 4: Condicionales y Bucles
     */
    //-- if-else
    val numero1: Int = 10
    if (numero1 > 0) {
        println("El número es positivo: ${numero1}")
    } else if (numero1 < 0) {
        println("El número es negativo: ${numero1}")
    } else {
        println("El número es cero: ${numero1}")
    }
    val numero2: Int = -10
  	//val mensaje2a: String = (numero2 > 0) ? "Num Positivo" : "Num Negativo"
    val mensaje2b: String = if (numero2 > 0) "Positivo" else "Negativo"
	  //println(mensaje2a)
    println(mensaje2b)
	  //-- when
    val dia1: Int = 3
    val nombreDia1 = when (dia1) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miércoles"
        4 -> "Jueves"
        5 -> "Viernes"
        else -> "Fin de semana"
    }
    println(nombreDia1) // Salida: Miércoles
    val dia2: Int = 5
    val nombreDia2 = when {
        dia2 == 1 -> "Lunes"
        dia2 == 2 -> "Martes"
        dia2 == 3 -> "Miércoles"
        dia2 == 4 -> "Jueves"
        dia2 == 5 -> "Viernes"
        else -> "Fin de semana"
    }
	  println(nombreDia2) // Salida: Viernes
    val nota1 = 16
    val calificacion1 = when {
        nota1 >= 19 -> "Excelente"
        nota1 >= 16 -> "Bueno"
        nota1 >= 13 -> "Suficiente"
        else -> "Insuficiente"
    }
    println(calificacion1) // Salida: Bueno
	  //-- Bucles
    for (i in 1..5) {
    	println("Bucle N° 1: ${i}") // Salida: 1, 2, 3, 4, 5
	  }
    for (i in 1 until 5) {
        println("Bucle N° 2: ${i}") // Salida: 1, 2, 3, 4
    }
    val frutas = listOf("Manzana", "Platano", "Cereza", "Piña")
    for (fruta in frutas) {
        println("Fruta: ${fruta}")
    }
    for ((indice, fruta) in frutas.withIndex()) {
        println("Fruta en posicion N° ${indice + 1}: $fruta")
    }
	  //-- While y Do-While
    var contador1 = 1
    while (contador1 <= 5) {
        println("Contador: $contador1")
        contador1++
    }
    var contador2 = 6
    do {
        println("Contador: $contador2")
        contador2++
    } while (contador2 <= 5)
    // Salida: 1, 2, 3, 4, 5
}