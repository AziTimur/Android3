package com.example.android32.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android32.databinding.ItemRvBinding;
import com.example.android32.retrofit.data.models.Films;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Films> films = new ArrayList<>();

    public void setFilms(List<Films> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRvBinding binding;
        ;

        public ViewHolder(@NonNull ItemRvBinding itemView) {
            super(itemView.getRoot());
            binding= itemView;
        }

        public void onBind(Films films) {
            binding.text.setText(films.getTitle());
            binding.text2.setText(films.getDirector());


        }
    }


}
