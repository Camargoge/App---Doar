package com.example.doar.data.repository

import com.example.doar.data.model.DoadorDTO
import com.example.doar.data.remote.RetrofitClient

class DoadorRepository {

    private val api = RetrofitClient.doadorApi

    suspend fun listarDoadores(): List<DoadorDTO>? {
        return try {
            api.listarDoadores()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun buscarPorId(id: String): DoadorDTO? {
        return try {
            api.buscarDoadorPorId(id)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun criarDoador(doador: DoadorDTO): DoadorDTO? {
        return try {
            api.criarDoador(doador)
        } catch (e: Exception) {
            null
        }
    }
}