package com.example.doar.data.remote

import com.example.doar.data.model.DoadorDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DoadorApi {

    @POST("doadores")
    suspend fun criarDoador(
        @Body doador: DoadorDTO
    ): DoadorDTO

    @GET("doadores/{id}")
    suspend fun buscarDoadorPorId(
        @Path("id") id: String
    ): DoadorDTO

    @GET("doadores")
    suspend fun listarDoadores(): List<DoadorDTO>
}
