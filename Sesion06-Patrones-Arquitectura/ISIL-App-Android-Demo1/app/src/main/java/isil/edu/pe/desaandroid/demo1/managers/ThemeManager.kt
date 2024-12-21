package isil.edu.pe.desaandroid.demo1.managers

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {

    private const val TEMA_PREFERENCIAS_BD = "preferencias_tema_1"
    private const val CLAVE_TEMA = "clave_tema_1"

    fun aplicarTema(context: Context): Boolean {
        //Referencia de SharedPreferences
        val dbPreferencias: SharedPreferences = context.getSharedPreferences(TEMA_PREFERENCIAS_BD, Context.MODE_PRIVATE)
        //Si el tema es oscuro, intercambiar por el claro y viceversa
        val esTemaOscuro = dbPreferencias.getBoolean(CLAVE_TEMA, false)
        if (esTemaOscuro) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        return esTemaOscuro
    }

    fun intercambiarTema(context: Context) {
        //Referencia de SharedPreferences
        val dbPreferencias: SharedPreferences = context.getSharedPreferences(TEMA_PREFERENCIAS_BD, Context.MODE_PRIVATE)
        val esTemaOscuro = dbPreferencias.getBoolean(CLAVE_TEMA, false)
        //Confirmamos los cambios
        dbPreferencias.edit().putBoolean(CLAVE_TEMA, !esTemaOscuro).apply()
        //Invocar la funcion de aplicacion del tema
        aplicarTema(context)
    }

}