package com.example.projetodio.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.projetodio.databinding.ActivityDetailBinding
import com.example.projetodio.demain.Match

class DetailActivity : AppCompatActivity() {

    object Extras {
        const val MATCH = "EXTRA_MATCH"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent?.extras?.getParcelable<Match>(Extras.MATCH).let {
            Glide.with(this).load(it?.place?.image).into(binding.ivPlace)
            supportActionBar?.title = it?.place?.name

            if (it != null) {
                binding.tvDescription.text = it.description

            }

            Glide.with(this).load(it?.homeTeam?.image).into(binding.ivHomeTeam)
            binding.tvHomeTeamName.text = it?.homeTeam?.name
            if (it != null) {
                binding.rbHomeTeamStars.rating = it.homeTeam.star.toFloat()
            }
            if (it?.homeTeam?.score != null) {
                binding.tvHomeTeamScore.text = it.homeTeam.score.toString()
            }

            Glide.with(this).load(it?.awayTeam?.image).into(binding.ivAwayTeam)
            binding.tvAwayTeamName.text = it?.awayTeam?.name
            if (it != null) {
                binding.rbAwayTeamStars.rating = it.awayTeam.star.toFloat()
            }
            if (it?.homeTeam?.score != null) {
                binding.tvHomeTeamScore.text = it.homeTeam.score.toString()
            }
        }
    }
}