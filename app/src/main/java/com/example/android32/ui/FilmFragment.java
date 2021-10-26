package com.example.android32.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.android32.App;
import com.example.android32.R;
import com.example.android32.databinding.FragmentFilmBinding;
import com.example.android32.retrofit.data.models.Films;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmFragment extends Fragment {

    private FragmentFilmBinding fragmentFilmBinding;
    private Adapter filmAdapter;
    private ViewModelMain viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFilmBinding = FragmentFilmBinding.inflate(inflater, container, false);
        return fragmentFilmBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmAdapter = new Adapter();
        App.api.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    filmAdapter.setFilms((List<Films>) response.body());
                    fragmentFilmBinding.filmRv.setAdapter(filmAdapter);
                } else {
                    Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
            }
        });
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
        filmAdapter.setClickListener(new Adapter.AdapterClickListener() {
            @Override
            public void onClick(Films films) {
                DetailFragment fragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("details", films);
                getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
                fragment.setArguments(bundle);
            }
        });
    }


}