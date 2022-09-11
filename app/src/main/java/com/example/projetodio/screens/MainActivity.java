package com.example.projetodio.screens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetodio.R;
import com.example.projetodio.data.API;
import com.example.projetodio.databinding.ActivityMainBinding;
import com.example.projetodio.demain.Match;
import com.example.projetodio.screens.adapter.MatchesAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private API matchesApi;
    private MatchesAdapter matchesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mucagomes.github.io/partidas-simulator-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        matchesApi = retrofit.create(API.class);
    }


    private void setupMatchesList() {
        binding.rvlMatches.setHasFixedSize(true);
        binding.rvlMatches.setLayoutManager(new LinearLayoutManager(this));
        binding.rvlMatches.setAdapter(matchesAdapter);
        findMatchesFromApi();


    }

    private void setupMatchesRefresh() {
        // updating matches with a swipe action
        binding.srlMatches.setOnRefreshListener(this::findMatchesFromApi);
    }

    private void setupFloatingActionButton() {
        // create click events and match simulation
        binding.floatingActionButton.setOnClickListener(view -> {

            view.animate().rotationBy(360).setDuration(500).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    //TOO Implementar algoritimo de simulação de partidas.
                    Random random = new Random();
                    for (int i = 0; i < matchesAdapter.getItemCount(); i++) {
                        Match match = matchesAdapter.getMatches().get(i);
                        // Pegamos a força do time(stars) e faremos um algoritimo para mostrar a porcentagem de chances do time ganhar
                        match.getHomeTeam().setScore(random.nextInt(match.getHomeTeam().getStar() + 1));
                        match.getAwayTeam().setScore(random.nextInt(match.getAwayTeam().getStar() + 1));
                        // Notificamos o adapter que mudamos algo dentro da nossa aplicação e mostra para o usuario
                        matchesAdapter.notifyItemChanged(i);
                    }
                }
            });

        });
    }

    private void findMatchesFromApi() {
        binding.srlMatches.setRefreshing(true);
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {

            @Override
            public void onResponse(@NonNull Call<List<Match>> call,@NonNull Response<List<Match>> response) {
                if (response.isSuccessful()) {
                    List<Match> matches = response.body();
                    matchesAdapter = new MatchesAdapter(matches);
                    binding.rvlMatches.setAdapter(matchesAdapter);
                } else {
                    showErrorMessage();
                }
                binding.srlMatches.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {

                showErrorMessage();
            }
        });
    }

    private void showErrorMessage() {
        Snackbar.make(binding.floatingActionButton, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }

}
