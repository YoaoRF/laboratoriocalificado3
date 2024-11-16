package com.rodriguez.yoao.laboratoriocalificado03
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitInstance {

    // URL base del API
    private const val BASE_URL = "https://private-effe28-tecsup1.apiary-mock.com/"

    // Configuración de Retrofit
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Define la URL base
            .addConverterFactory(GsonConverterFactory.create()) // Configura el convertidor Gson
            .build()
            .create(ApiService::class.java) // Crea la instancia de la interfaz del API
    }
}

