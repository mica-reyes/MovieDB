package com.example.themoviedb.views.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.data.local.MovieWithGenres
import com.example.themoviedb.databinding.ItemHorizontalMovieBinding
import com.example.themoviedb.views.DetailActivity

class MyListAdapter(private val movieList: List<MovieWithGenres>): RecyclerView.Adapter<MyListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewTipe: Int): MyListViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding= ItemHorizontalMovieBinding.inflate(layoutInflater, parent, false)
        return MyListViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val item= movieList[position]
        holder.itemView.setOnClickListener {
            val context= holder.itemView.context
            val intent= Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.ID, item.movie.id)
            context.startActivity(intent)
        }
        holder.render(item)
    }
}