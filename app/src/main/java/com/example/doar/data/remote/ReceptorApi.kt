package com.example.doar.data.remote

import com.example.doar.data.model.ReceptorDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReceptorApi {

    @POST("receptores")
    suspend fun criarReceptor(
        @Body receptor: ReceptorDTO ): ReceptorDTO

    @GET("receptores/{id}")
    suspend fun buscarReceptorPorId(
        @Path("id") id: String
    ): ReceptorDTO

    @GET("receptores")
    suspend fun listarReceptores(): List<ReceptorDTO>
}