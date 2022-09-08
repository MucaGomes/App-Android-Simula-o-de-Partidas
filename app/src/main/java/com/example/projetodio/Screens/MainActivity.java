package com.example.projetodio.Screens;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetodio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMatchesList();
        setupMatchesRefresh();
        setupFloaingActionButton();
    }

    private void setupFloaingActionButton() {
        // create click events and match simulation
    }

    private void setupMatchesRefresh() {
        // updating matches with a swipe action
    }

    private void setupMatchesList() {
        // listing the matches consuming the API

    }


}
