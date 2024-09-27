package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.Movie
import com.example.themoviedb.databinding.ItemHorizontalMovieBinding

class TopRatedViewHolder(val binding: ItemHorizontalMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render(movie: Movie) {
        Glide.with(binding.ivHorizontalMovie.context).load("${BuildConfig.IMAGE_URL}${movie.image}")
            .into(binding.ivHorizontalMovie)
    }
}