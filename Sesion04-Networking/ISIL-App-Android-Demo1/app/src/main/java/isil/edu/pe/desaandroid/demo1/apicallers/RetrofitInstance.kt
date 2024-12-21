package isil.edu.pe.desaandroid.demo1.apicallers

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import isil.edu.pe.desaandroid.demo1.servicios.ApiService
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    //URI-Base o URL-Base (Direccion principal del API REST)
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    //Configurar el interceptor de logs (opcional)
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val apiCliente = OkHttpClient.Builder().addInterceptor(logging).build()

    val api: ApiService by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(apiCliente)
                .build()
                .create(ApiService::class.java)
    }

}