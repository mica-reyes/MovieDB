package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.Movie
import com.example.themoviedb.databinding.ItemMovieBinding

class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render(movie: Movie) {
        Glide.with(binding.ivMovieList.context).load("${BuildConfig.IMAGE_URL}${movie.image}")
            .into(binding.ivMovieList)
    }
}
