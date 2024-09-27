package com.example.themoviedb.views.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.data.Genres
import com.example.themoviedb.databinding.ItemGenreBinding

class GenreViewHolder (val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root){
    fun render(genre: Genres){
        binding.genre.text= genre.name
    }
}
