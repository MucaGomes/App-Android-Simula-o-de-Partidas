package com.example.projetodio.demain

import com.google.gson.annotations.SerializedName

data class Team(

    @SerializedName("nome")
    val name: String,

    @SerializedName("forca")
    val star: Int,

    @SerializedName("imagem")
    val image: String
)
