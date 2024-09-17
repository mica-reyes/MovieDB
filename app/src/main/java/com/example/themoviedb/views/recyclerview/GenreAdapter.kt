package com.example.themoviedb.views.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.data.Genres
import com.example.themoviedb.databinding.ItemGenreBinding

class GenreAdapter (private val genresList: List<Genres> ): RecyclerView.Adapter<GenreViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding= ItemGenreBinding.inflate(layoutInflater, parent, false)
        return GenreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return genresList.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val item= genresList[position]
        holder.render(item)
    }
}