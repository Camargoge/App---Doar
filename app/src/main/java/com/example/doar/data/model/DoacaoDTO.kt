package com.example.doar.data.model

import com.google.gson.annotations.SerializedName

data class DoacaoDTO(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("doadorId")
    val doadorId: String? = null,

    @SerializedName("quantidade")
    val quantidade: Int,

    @SerializedName("descricao")
    val descricao: String? = null,

    @SerializedName("tipo")
    val tipo: String,

    @SerializedName("status")
    val statusDoacao: String,
 )

