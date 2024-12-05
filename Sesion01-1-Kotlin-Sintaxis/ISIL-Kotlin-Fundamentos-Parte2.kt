/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
const val IGV = 0.18

fun main() {
    /*
     * Parte 2: Null-Safety
     */
    var curso1: String? = null
    if (curso1 != null) println("El curso es ${curso1}")
    var subCurso1: String? = curso1?.substring(0, 2)
    println("El subcurso es ${subCurso1}")
    //var curso2: String = null		//Esta linea no puede ejecutarse debido a que curso2 no es Null-Safety
    //if (curso2 != null) println("El curso es ${curso2}")
}