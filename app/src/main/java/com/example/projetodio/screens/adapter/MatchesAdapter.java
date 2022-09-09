package com.example.projetodio.screens.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projetodio.databinding.MatchItemBinding;
import com.example.projetodio.demain.Match;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Match match = matches.get(position);

        // Pega os dados da partida la da api e por no nosso layout
        Glide.with(context).load(match.getHomeTeam().getImage()).into(holder.binding.imageHomeTeam);
        holder.binding.textHomeTeamName.setText(match.getHomeTeam().getName());
        Glide.with(context).load(match.getAwayTeam().getImage()).into(holder.binding.imageAwayTeam);
        holder.binding.textAwayTeamName.setText(match.getAwayTeam().getName());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
