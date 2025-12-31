package com.example.doar

import com.example.doar.data.model.DoacaoDTO
import com.example.doar.data.remote.DoacaoApi
import com.example.doar.data.repository.DoacaoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class DoacaoRepositoryTest {

    private val apiMock = mockk<DoacaoApi>()

    private val repository = DoacaoRepository(api = apiMock)

    @Test
    fun `listarDoacoes`() = runBlocking {
        val listaEsperada = listOf(DoacaoDTO(id = "1", doadorId = "1", quantidade = 3, descricao = "leite", tipo = "null", statusDoacao = "null"))
        coEvery { apiMock.listarDoacoes() } returns listaEsperada

        // WHEN: Chama a função do repositório
        val resultado = repository.listarDoacoes()

        // THEN: Verifica se o resultado é o que o dublê enviou
        assertEquals(listaEsperada, resultado)
    }
}