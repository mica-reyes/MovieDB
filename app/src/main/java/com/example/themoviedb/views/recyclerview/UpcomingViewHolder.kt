package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.Movie
import com.example.themoviedb.databinding.ItemUpcomingBinding

class UpcomingViewHolder(val binding: ItemUpcomingBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render (movie: Movie){
        Glide.with(binding.ivUpcoming.context).load("${BuildConfig.IMAGE_URL}${movie.image}")
            .into(binding.ivUpcoming)
    }
}