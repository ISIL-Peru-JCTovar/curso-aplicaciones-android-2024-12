package isil.edu.pe.desaandroid.demo1.repositories

import android.content.Context
import isil.edu.pe.desaandroid.demo1.apicallers.RetrofitInstance
import isil.edu.pe.desaandroid.demo1.data.Tarea
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class TareaRepository(private val context: Context) {

    private val api = RetrofitInstance.api

    suspend fun crearTareaResponse(tarea: Tarea): Response<Tarea> {
        return api.crearTareaResponse(tarea)
    }

    fun crearTareaCall(tarea: Tarea): Call<Tarea> {
        return api.crearTareaCall(tarea)
    }

}