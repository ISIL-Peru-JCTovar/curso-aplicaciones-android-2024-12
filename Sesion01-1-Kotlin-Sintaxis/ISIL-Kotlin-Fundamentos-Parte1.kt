/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
const val IGV = 0.18

fun main() {
    /*
     * Parte 1: Definicion de los tipos de variables: var, val, lateinit
     */
    val nombreAlumno: String = "Juan"
    println("Hola, ${nombreAlumno}")
    //nombreAlumno = "2024"   //No se puede reasignar cuando es val (inmutable), pero si cuando es var
    println("Hola, ${nombreAlumno}")
    lateinit var apellidoAlumno: String
    //println("Hola, ${nombreAlumno} ${apellidoAlumno}")
    //...Hago mis calculos..
    //...Hago mis calculos..
    //...Hago mis calculos..
    apellidoAlumno = "Perez"
    println("Hola, ${nombreAlumno} ${apellidoAlumno}")
}