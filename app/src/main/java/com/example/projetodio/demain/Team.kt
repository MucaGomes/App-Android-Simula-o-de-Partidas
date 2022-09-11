package com.example.projetodio.demain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(

    // Nome do time
    @SerializedName("nome")
    val name: String,

    // Força do time
    @SerializedName("forca")
    val star: Int,

    // Imagem do time
    @SerializedName("imagem")
    val image: String,
    var score: Int?
) : Parcelable
