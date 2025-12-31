package com.example.doar.data.model
import com.google.gson.annotations.SerializedName

data class DoadorDTO(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("tel")
    val tel: Int,

    @SerializedName("cidade")
    val cidade: String
)