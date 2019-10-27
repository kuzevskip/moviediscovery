package com.pavlekuzevski.moviediscovery.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.pavlekuzevski.moviediscovery.data.model.Movie;
import com.pavlekuzevski.moviediscovery.ui.movielist.MovieListAdapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter({"adapter_items"})
    public static void addMovieItems(RecyclerView recyclerView, List<Movie> movies) {
        MovieListAdapter adapter = (MovieListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(movies);
        }
    }

    @BindingAdapter("bind:thumbnailUrl")
    public static void loadImage(ImageView view, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide
                    .with(view.getContext())
                    .load(MovieImageUrlBuilder.buildThumbnailUrl(url))
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(RequestOptions.centerCropTransform())
                    .into(view);
        }
    }
}
