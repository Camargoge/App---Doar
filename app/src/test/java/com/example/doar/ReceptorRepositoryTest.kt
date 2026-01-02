package com.example.doar

import com.example.doar.data.model.Moradia
import com.example.doar.data.model.QuantidadePessoas
import com.example.doar.data.model.ReceptorDTO
import com.example.doar.data.model.SituacaoOcupacional
import com.example.doar.data.remote.ReceptorApi
import com.example.doar.data.repository.ReceptorRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ReceptorRepositoryTest {
    private  val apiMock = mockk<ReceptorApi>()

    private val repository = ReceptorRepository(apiMock)

    @Test
    fun listaReceptorTeste() = runBlocking {
        val lista = listOf(
            ReceptorDTO(
                id = "1",
                nome = "Maria Aparecida",
                email = "mariaap@xxx.com",
                tel = "32478956",
                endereco = "Rua: A, 333",
                cidade = "Andradas",
                ocupacao = SituacaoOcupacional.DESEMPREGADO,
                moradia = Moradia.PROPRIA,
                qtdePessoas = QuantidadePessoas.TRÊS),

            ReceptorDTO(
                id = "2",
                nome = "José João",
                email = "jj@xxx.com",
                "78945612",
                endereco = "Avenida Antonio Bom, 111",
                cidade = "Caldas",
                ocupacao = SituacaoOcupacional.CLT,
                moradia = Moradia.CEDIDA,
                qtdePessoas = QuantidadePessoas.QUATRO_OU_MAIS)
        )
        coEvery { apiMock.listarReceptores() } returns lista
        val resultado = repository.listarTodos()
        assertEquals(2, resultado?.size)
        assertEquals("Maria Aparecida",resultado?.get(0)?.nome)
    }

    @Test

    fun testeReceptorPorId() = runBlocking {
        val receptorTeste = ReceptorDTO(
            id = "2",
            nome = "José João",
            email = "jj@xxx.com",
            "78945612",
            endereco = "Avenida Antonio Bom, 111",
            cidade = "Caldas",
            ocupacao = SituacaoOcupacional.CLT,
            moradia = Moradia.CEDIDA,
            qtdePessoas = QuantidadePessoas.QUATRO_OU_MAIS)

        coEvery { apiMock.buscarReceptorPorId("2") } returns receptorTeste
        val resultado = repository.buscarReceptorPorId("2")
        assertEquals("2", resultado?.id)
        assertEquals("José João",resultado?.nome)
    }

    @Test

    fun falhaBuscarPorId() = runBlocking {
        coEvery { apiMock.buscarReceptorPorId("101") } throws Exception("ID não encontrado ou erro na rede")
        val resultado = repository.buscarReceptorPorId("101")
        assertEquals(null, resultado)
    }

    @Test

    fun criarReceptor() = runBlocking {
        val novoReceptor = ReceptorDTO(
            id = "0",
            nome = "João José Paulino",
            email = "jjpaulno@xxx.com",
            "88945612",
            endereco = "Avenida Antonio Bonifacio, 1110",
            cidade = "poços de Caldas",
            ocupacao = SituacaoOcupacional.CLT,
            moradia = Moradia.CEDIDA,
            qtdePessoas = QuantidadePessoas.QUATRO_OU_MAIS)

        val receptorCriado = ReceptorDTO(
            id = "32",
            nome = novoReceptor.nome,
            email = novoReceptor.email,
            tel = novoReceptor.tel,
            endereco = novoReceptor.endereco,
            cidade = novoReceptor.cidade,
            ocupacao = novoReceptor.ocupacao,
            moradia = novoReceptor.moradia,
            qtdePessoas = novoReceptor.qtdePessoas)
        coEvery {apiMock.criarReceptor(any()) } returns receptorCriado
        val resultado = repository.criar(novoReceptor)
        assertEquals("32", resultado?.id)
        assertEquals("João José Paulino", resultado?.nome)
    }

}
