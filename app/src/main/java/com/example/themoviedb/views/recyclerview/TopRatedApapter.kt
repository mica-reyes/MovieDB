package com.example.themoviedb.views.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.data.MovieList
import com.example.themoviedb.databinding.ItemUpcomingBinding
import com.example.themoviedb.views.DetailActivity

class TopRatedApapter (private val movieList: MovieList): RecyclerView.Adapter<TopRatedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewTipe: Int): TopRatedViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding= ItemUpcomingBinding.inflate(layoutInflater, parent, false)
        return TopRatedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.results.size
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val item= movieList.results[position]
        holder.itemView.setOnClickListener {
            val context= holder.itemView.context
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.ID, item.id)
            context.startActivity(intent)
        }
        holder.render(item)
    }
}