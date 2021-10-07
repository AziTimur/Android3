package com.example.android32.ui;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android32.App;
import com.example.android32.retrofit.data.models.Films;
import com.example.android32.retrofit.data.repositories.GhibliRepository;

import java.util.List;

public class ViewModelMain extends ViewModel {

        private final GhibliRepository repository = new GhibliRepository();
        MutableLiveData<List<Films>> getFilms(){
            return repository.getFilms();
        }
 /*   public LiveData<List<Films>> films;
    void getFilms() {
        films = App.repository.getFilms();
    }*/
}
