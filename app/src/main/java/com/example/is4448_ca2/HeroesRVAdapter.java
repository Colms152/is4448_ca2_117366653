package com.example.is4448_ca2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeroesRVAdapter extends RecyclerView.Adapter<HeroesRVItemHolder> implements Filterable {
    private List<HeroObject> heroes;
    private List<HeroObject> heroesAll;
    private List<HeroObject> heroesSpinnerFiltered;
    private Context contx;
    Boolean isFiltered;

    public HeroesRVAdapter(List<HeroObject> heroes, Context contx) {
        this.heroes = heroes;
        heroesAll = new ArrayList<>(heroes);
        heroesSpinnerFiltered = new ArrayList<>();
        this.isFiltered = false;
        this.contx = contx;
    }

    @NonNull
    @Override
    public HeroesRVItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contx).inflate(R.layout.holder_heroes, parent, false);
        return new HeroesRVItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HeroesRVItemHolder holder, int position) {
        final HeroObject hero = heroes.get(position);
        holder.tvName.setText(hero.getName());
        holder.tvRealName.setText(hero.getRealName());
        holder.rbRating.setRating(hero.getRating());
        holder.tvTeam.setText(hero.getTeam());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public void updateDataSet(ArrayList<HeroObject> heroes) {
        this.heroes.clear();
        this.heroes.addAll(heroes);
        this.heroesAll.addAll(heroes);
        notifyDataSetChanged();
    }

    public void itemRemoved(int postion) {
        this.heroes.remove(postion);
        notifyItemRemoved(postion);
    }

    public void itemAdded(HeroObject hero, int postion) {
        this.heroes.add(postion, hero);
        notifyItemInserted(postion);
    }

    @Override
    public Filter getFilter() {
        return heroFilter;
    }

    private Filter heroFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<HeroObject> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                //if search field empty return all
                if (isFiltered) {
                    filteredList.addAll(heroesSpinnerFiltered);
                } else {
                    filteredList.addAll(heroesAll);
                }
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                if(isFiltered) {
                    for (HeroObject h : heroesSpinnerFiltered) {
                        if (h.getName().toLowerCase().contains(filterPattern)) {
                            filteredList.add(h);
                        }
                    }
                }else{
                    for (HeroObject h : heroesAll) {
                        if (h.getName().toLowerCase().contains(filterPattern)) {
                            filteredList.add(h);
                        }
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            heroes.clear();
            heroes.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}

