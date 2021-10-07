package com.example.android32.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.android32.databinding.FragmentFilmBinding;
import com.example.android32.retrofit.data.models.Films;

import java.util.List;


public class FilmFragment extends Fragment {

    private FragmentFilmBinding fragmentFilmBinding;
    private Adapter filmAdapter;
    private ViewModelMain viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmAdapter  = new Adapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFilmBinding = FragmentFilmBinding.inflate(inflater,container,false);
        return fragmentFilmBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ViewModelMain.class);
        setRv();
    }

    private void setRv() {
        fragmentFilmBinding.filmRv.setAdapter(filmAdapter);
        viewModel.getFilms().observe(getViewLifecycleOwner(), new Observer<List<Films>>() {
            @Override
            public void onChanged(List<Films> films) {
                filmAdapter.setFilms(films);
            }
        });
    }


}