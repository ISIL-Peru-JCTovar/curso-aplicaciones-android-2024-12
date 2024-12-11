/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
	var sistema: Sistema = Sistema()
    sistema.ejecutar()
}

class Sistema {
    
    fun ejecutar() {
        //-- Persona 1, utilizando el constructor principal (solo hay uno solo principal)
        var p1: Persona = Persona("Jose", 29)
        //p.nombre = "Jose"
        //p.edad = 29
        p1.saludar()
        p1.despedir()
        //-- Persona 2, utilizando el constructor secundario (puede haber "n" secundarios)
        var p2: Persona = Persona("Maria")
        //p.nombre = "Jose"
        //p.edad = 29
        p2.saludar()
        p2.despedir()
        //-- Estudiante 1: co Herencia de Persona
        var e1: Estudiante = Estudiante("Henry", 25, "9to")
        e1.saludar()
        e1.despedir()
        //-- Persona Data (Data Class)
        var pdata1a: PersonaData = PersonaData("Jhon", 24, "10203040")	//-- Con Data Class
        var pdata1b: PersonaData = PersonaData("Jhon", 24, "10203040")	//-- Con Data Class
        var pdata2a: PersonaSinData = PersonaSinData("Jhon", 24, "10203040")	//-- Sin Data Class
        var pdata2b: PersonaSinData = PersonaSinData("Jhon", 24, "10203040")	//-- Sin Data Class
        println(pdata1a)	//Con Data Class
        println(pdata2a)	//Sin Data Class
        println(pdata1a == pdata1b)		//Con Data Class
        println(pdata2a == pdata2b)		//Sin Data Class
    }
    
}

//class Persona(val nombre: String, var edad: Int) {
//class Persona private constructor(val nombre: String, var edad: Int) {
open class Persona {
    
    var nombre: String = ""
    var edad: Int = 0
    
	init {
		println("Inicializando la creacion del objeto persona, antes que el constructor.")
	}
    
    constructor(nombre: String, edad: Int = 18) {
		this.nombre = nombre
		this.edad = edad
        println("Constructor con dos parametros ejecutado")
    }
    
    /*
    constructor(nombre: String) {
		this.nombre = nombre
		this.edad = 0
        println("Constructor con un parametro ejecutado")
	}
    */
    
    open fun saludar() {
	    println("Hola, mi nombre es $nombre y tengo $edad años.")
    }
    
    fun despedir() {
	    println("Me despido, $nombre.")
    }
    
}

class Estudiante(nombre: String, edad: Int, val grado: String) : Persona(nombre, edad) {
	override fun saludar() {
		println("Hola, soy $nombre, tengo $edad años y estudio en el grado $grado.")
	}
}

//Clase Data Class
//Generan automáticamente métodos como equals(), hashCode(), toString() y un constructor copy()
data class PersonaData(var nombre: String, var edad: Int, var dni: String) {
    
    fun saludar() {
        println("Hola")
    }
    
}

class PersonaSinData(var nombre: String, var edad: Int, var dni: String) {
    
    fun saludar() {
        println("Hola")
    }
    
}