package com.example.projetodio.data;

import com.example.projetodio.demain.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("matches.json")
    Call<List<Match>> getMatches();


}
