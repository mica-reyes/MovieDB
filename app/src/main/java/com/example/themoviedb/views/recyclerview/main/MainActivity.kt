package com.example.themoviedb.views.recyclerview.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.databinding.ActivityMainBinding
import com.example.themoviedb.views.recyclerview.MovieAdapter
import com.example.themoviedb.views.recyclerview.MyListAdapter
import com.example.themoviedb.views.recyclerview.TopRatedAdapter
import com.example.themoviedb.views.recyclerview.UpcomingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMovieList()
        initUpcoming()
        initTopRated()
        initMyList()
        loading()

    }

    private fun initMovieList() {
        binding.recyclerMovie.layoutManager = GridLayoutManager(this, 2)
        viewModel.movieList.observe(this) { movie ->
            binding.recyclerMovie.adapter = movie?.let {
                MovieAdapter(it)
            }
        }
    }

    private fun initUpcoming() {
        binding.recyclerUpcoming.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.upcomingList.observe(this) { movie ->
            binding.recyclerUpcoming.adapter = movie?.let {
                UpcomingAdapter(it)
            }
        }
    }

    private fun initTopRated() {
        binding.recyclerTopRated.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.topRatedList.observe(this) { movie ->
            binding.recyclerTopRated.adapter = movie?.let {
                TopRatedAdapter(it)
            }
        }
    }

    private fun initMyList() {
        binding.recyclerMyList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.myList.observe(this) { movie ->
            binding.recyclerMyList.adapter = movie?.let {
                MyListAdapter(it)
            }
            if (movie?.size == 0) {
                binding.tvMyList.text = ""
            } else {
                binding.tvMyList.text = "My lista"
            }
        }
    }

    private fun loading(){
        viewModel.loading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
            binding.ivMdb.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.recyclerUpcoming.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.recyclerTopRated.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvMovies.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvTopRated.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvUpcoming.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvMyList.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.recyclerMyList.visibility = if (loading) View.INVISIBLE else View.VISIBLE
        }
    }
}