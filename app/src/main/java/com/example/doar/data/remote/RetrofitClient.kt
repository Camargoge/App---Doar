package com.example.doar.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val doadorApi: DoadorApi by lazy {
        retrofit.create(DoadorApi::class.java)
    }

    val receptorApi: ReceptorApi by lazy {
        retrofit.create(ReceptorApi::class.java)
    }

    val doacaoApi: DoacaoApi by lazy {
        retrofit.create(DoacaoApi::class.java)
    }
}