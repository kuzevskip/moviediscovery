package com.pavlekuzevski.moviediscovery.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {

    @Expose
    @SerializedName("popularity")
    private Float popularity;

    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("video")
    private Boolean video;

    @Expose
    @SerializedName("vote_count")
    private Integer voteCount;

    @Expose
    @SerializedName("vote_average")
    private Float voteAverage;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("release_date")
    private String releaseDate;

    @Expose
    @SerializedName("original_language")
    private String originalLanguage;

    @Expose
    @SerializedName("original_title")
    private String originalTitle;

    @Expose
    @SerializedName("genre_ids")
    private ArrayList<Integer> genreIds;

    @Expose
    @SerializedName("adult")
    private Boolean adult;

    @Expose
    @SerializedName("overview")
    private String overview;

    @Expose
    @SerializedName("poster_path")
    private String posterPath;

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

}
