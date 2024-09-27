package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.local.MovieWithGenres
import com.example.themoviedb.databinding.ItemHorizontalMovieBinding

class MyListViewHolder(val binding: ItemHorizontalMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render (movieWhithGenres: MovieWithGenres){
        Glide.with(binding.ivHorizontalMovie.context).load("${BuildConfig.IMAGE_URL}${movieWhithGenres.movie.image}")
            .into(binding.ivHorizontalMovie)
    }
}