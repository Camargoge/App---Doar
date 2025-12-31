package com.example.doar.data.remote

import com.example.doar.data.model.DoacaoDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DoacaoApi {

    @POST("doacoes")
    suspend fun criarDoacao(
        @Body doacao: DoacaoDTO) : DoacaoDTO

    @GET("doacoes/{id}")
    suspend fun buscarDoacaoPorId(
        @Path("id") id: String): DoacaoDTO

    @GET("doacoes")
    suspend fun listarDoacoes(): List<DoacaoDTO>
}