package com.example.themoviedb.views.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.data.MovieList
import com.example.themoviedb.databinding.ItemMovieBinding
import com.example.themoviedb.views.DetailActivity

class MovieAdapter(private val movieList: MovieList) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //val view = layoutInflater.inflate(R.layout.item_movie, parent, false)
        val binding= ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList.results[position]

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.ID, item.id)
            context.startActivity(intent)
        }
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return movieList.results.size
    }
}