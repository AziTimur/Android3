package com.example.android32.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android32.R;
import com.example.android32.databinding.FragmentDetailBinding;
import com.example.android32.retrofit.data.models.Films;


public class DetailFragment extends Fragment {
      private   FragmentDetailBinding binding;
      private Films films;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        films = (Films) getArguments().getSerializable("details");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
    }

    private void setData() {

    binding.title.setText(films.getTitle());
    binding.originalTitleRomanised.setText(films.getOriginalTitleRomanised());
    binding.description.setText(films.getDescription());
    }
}