package com.example.doar.data.repository

import com.example.doar.data.model.DoacaoDTO
import com.example.doar.data.remote.DoacaoApi
import com.example.doar.data.remote.RetrofitClient

class DoacaoRepository(
    private val api: DoacaoApi = RetrofitClient.doacaoApi
) {

    suspend fun criarDoacao(doacao: DoacaoDTO): DoacaoDTO? {
        return try {
            api.criarDoacao(doacao)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun buscarDoacaoPorId(id: String): DoacaoDTO? {
        return try {
            api.buscarDoacaoPorId(id)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun listarDoacoes(): List<DoacaoDTO>? {
        return try {
            api.listarDoacoes()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}