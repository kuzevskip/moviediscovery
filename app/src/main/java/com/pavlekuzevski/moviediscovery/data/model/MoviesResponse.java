package com.pavlekuzevski.moviediscovery.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @Expose
    @SerializedName("page")
    private Integer page;

    @Expose
    @SerializedName("total_results")
    private Integer totalResults;

    @Expose
    @SerializedName("total_pages")
    private Integer totalPages;

    @Expose
    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}