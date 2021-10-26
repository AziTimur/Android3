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
    private ItemRvBinding binding;
    private AdapterClickListener clickListener;

    public void setClickListener(AdapterClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public void setFilms(List<Films> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
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

            itemView.setOnClickListener(v -> {
                clickListener.onClick(films);
            });

        }
    }

    public interface AdapterClickListener {
        void onClick(Films films);
    }
}
