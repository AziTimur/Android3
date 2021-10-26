package com.example.android32.retrofit.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResponse {


    @SerializedName("results")
    @Expose
    private List<Films> results = null;


    public List<Films> getResults() {
        return results;
    }

    public void setResults(List<Films> results) {
        this.results = results;
    }

}
