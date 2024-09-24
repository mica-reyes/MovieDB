package com.example.themoviedb.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.databinding.ActivityMainBinding
import com.example.themoviedb.views.recyclerview.MovieAdapter
import com.example.themoviedb.views.recyclerview.TopRatedApapter
import com.example.themoviedb.views.recyclerview.UpcomingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMovieList()
        initUpcoming()
        initTopRated()

        viewModel.loading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
            binding.ivMdb.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.recyclerUpcoming.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.recyclerTopRated.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvMovies.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvTopRated.visibility = if (loading) View.INVISIBLE else View.VISIBLE
            binding.tvUpcoming.visibility = if (loading) View.INVISIBLE else View.VISIBLE
        }
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
                TopRatedApapter(it)
            }
        }
    }

    private fun myList(){

    }
}