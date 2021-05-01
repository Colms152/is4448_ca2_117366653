package com.example.is4448_ca2;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class HeroesRVItemHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvRealName, tvTeam;
    RatingBar rbRating;
    ConstraintLayout clHeroHolder;
    public HeroesRVItemHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvRealName = itemView.findViewById(R.id.tvRealName);
        tvTeam = itemView.findViewById(R.id.tvTeam);
        rbRating = itemView.findViewById(R.id.rbRating);
        clHeroHolder = itemView.findViewById(R.id.clHeroHolder);
    }
}
