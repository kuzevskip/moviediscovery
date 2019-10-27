package com.pavlekuzevski.moviediscovery.utils;

public class MovieImageUrlBuilder {
    private static final String THUMBNAIL_URL = "https://image.tmdb.org/t/p/w154";

    public static String buildThumbnailUrl(String posterPath) {
        return THUMBNAIL_URL + posterPath;
    }
}
