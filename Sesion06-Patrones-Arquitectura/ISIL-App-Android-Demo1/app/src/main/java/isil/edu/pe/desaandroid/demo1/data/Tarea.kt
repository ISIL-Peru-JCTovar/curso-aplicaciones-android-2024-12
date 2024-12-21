package isil.edu.pe.desaandroid.demo1.data

import java.io.Serializable

data class Tarea (
    val userId: Int,
    val title: String,
    val body: String
): Serializable
