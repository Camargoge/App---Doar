package com.example.doar.data.repository

import com.example.doar.data.model.DoadorDTO
import com.example.doar.data.remote.DoadorApi
import com.example.doar.data.repository.DoadorRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class DoadorRepositoryTest {
    private val apiMock = mockk<DoadorApi>()
    private val repository = DoadorRepository(apiMock)

    @Test
    fun testeListarDoadores() = runBlocking {
        val listaTeste = listOf(
            DoadorDTO(
                id = "1",
                nome = "Gezielle",
                email = "ge@email.com",
                tel = 123456,
                cidade = "poços de caldas"
            ),
            DoadorDTO(
                id = "2",
                nome = "Joao",
                email = "joao@email.com",
                tel = 123456,
                cidade = "poços de caldas")
        )
        coEvery { apiMock.listarDoadores() } returns listaTeste
        val resultado = repository.listarDoadores()
        assertEquals(2, resultado?.size)
        assertEquals("Gezielle", resultado?.get(0)?.nome)
    }

    @Test

    fun falhaListarDoaodres() = runBlocking {
        coEvery { apiMock.listarDoadores() } throws Exception("Erro de conexão")
        val resultado = repository.listarDoadores()
        assertEquals(null, resultado)
    }

    @Test

    fun buscaPorIdTeste() = runBlocking{
        val doadorTeste = DoadorDTO(
            id = "10",
            nome = "Gezielle",
            email = "ge@email.com",
            tel = 123456,
            cidade = "poços de caldas"
        )
        coEvery { apiMock.buscarDoadorPorId("10")} returns doadorTeste
        val resultado = repository.buscarPorId("10")
        assertEquals("10", resultado?.id)
        assertEquals("Gezielle", resultado?.nome)
    }

    @Test

    fun falhaBuscarPorId() = runBlocking {
        coEvery { apiMock.buscarDoadorPorId("145") } throws Exception("ID não encontrado ou erro de rede")
        val resultado = repository.buscarPorId("145")
        assertEquals(null, resultado) }

    @Test

    fun criarDoaodor()  = runBlocking {
        val novoDoador = DoadorDTO (
            id = "0",
            nome = "Novo Doador",
            email = "novo@email.com",
            tel = 9887766,
            cidade = "Poços de Caldas"
        )
        val doadorCriado = DoadorDTO(
            id = "15",
            nome = novoDoador.nome,
            email = novoDoador.email,
            tel = novoDoador.tel,
            cidade = novoDoador.cidade
        )
        coEvery {apiMock.criarDoador(any()) } returns doadorCriado
        val resultado = repository.criarDoador(novoDoador)
        assertEquals("15", resultado?.id)
        assertEquals("Novo Doador", resultado?.nome)
    }
}