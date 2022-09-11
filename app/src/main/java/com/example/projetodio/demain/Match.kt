package com.example.projetodio.demain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


// Nesta classe iremos puxar as infos da nossa API e coloca-las em variaveis para mostrar na tela as
// partidas
// Usamos o @SerializedName para demonstrar que o que vira em " " é oque esta no objeto da API


@Parcelize
data class Match(
    // Qual o nome do campeonato que esta na API
    @SerializedName("descricao")
    val description: String,

    // Nome do estadio onde vai ser disputado o campeonato
    @SerializedName("local")
    val place: Local,

    // Nome do time Mandante
    @SerializedName("mandante")
    val homeTeam: Team,

    // Nome do time Visitante
    @SerializedName("visitante")
    val awayTeam: Team
) : Parcelable