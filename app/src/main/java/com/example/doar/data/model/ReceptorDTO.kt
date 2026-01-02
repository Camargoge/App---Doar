package com.example.doar.data.model

import com.google.gson.annotations.SerializedName

data class ReceptorDTO(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("tel")
    val tel: String,

    @SerializedName("endereco")
    val endereco: String,

    @SerializedName("cidade")
    val cidade: String,

    @SerializedName("ocupacao")
    val ocupacao: SituacaoOcupacional,

    @SerializedName("moradia")
    val moradia: Moradia,

    @SerializedName("qtdePessoa")
    val qtdePessoas: QuantidadePessoas,
)


