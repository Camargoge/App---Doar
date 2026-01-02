package com.example.doar.data.repository

import com.example.doar.data.model.ReceptorDTO
import com.example.doar.data.remote.ReceptorApi
import com.example.doar.data.remote.RetrofitClient

class ReceptorRepository(private  val api : ReceptorApi){
    //private val api = RetrofitClient.receptorApi
    suspend fun buscarReceptorPorId(id : String) : ReceptorDTO? {
        return try {
            api.buscarReceptorPorId(id)
        } catch (e : Exception) {
            null
        }
    }

    suspend fun listarTodos(): List<ReceptorDTO>? {
        return try {
            api.listarReceptores()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun criar(receptor: ReceptorDTO): ReceptorDTO? {
        return try {
            api.criarReceptor(receptor)
        } catch (e: Exception) {
            null
        }
    }
}