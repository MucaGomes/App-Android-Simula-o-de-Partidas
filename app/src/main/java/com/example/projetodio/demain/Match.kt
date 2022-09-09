package com.example.projetodio.demain

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("descricao")
    val description: String,

    @SerializedName("local")
    val place: Local,

    @SerializedName("mandante")
    val homeTeam: Team,

    @SerializedName("visitante")
    val awayTeam: Team
)