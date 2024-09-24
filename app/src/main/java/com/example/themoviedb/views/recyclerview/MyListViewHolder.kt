package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.Movie
import com.example.themoviedb.databinding.ItemDetailBinding

class MyListViewHolder(val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render (movie: Movie){
        Glide.with(binding.ivDetail.context).load("${BuildConfig.IMAGE_URL}${movie.image}")
            .into(binding.ivDetail)
    }
}