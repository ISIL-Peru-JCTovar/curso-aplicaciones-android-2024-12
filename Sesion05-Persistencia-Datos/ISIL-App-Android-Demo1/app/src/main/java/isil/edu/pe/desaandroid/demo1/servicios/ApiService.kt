package isil.edu.pe.desaandroid.demo1.servicios

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

import isil.edu.pe.desaandroid.demo1.data.Tarea
import retrofit2.Call

interface ApiService {

    @POST("posts")
    suspend fun crearTarea(@Body tarea: Tarea): Response<Tarea>

    @POST("posts")
    fun crearTareaCall(@Body tarea: Tarea): Call<Tarea>

}