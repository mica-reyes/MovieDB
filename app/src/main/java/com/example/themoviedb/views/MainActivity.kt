package com.example.themoviedb.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.databinding.ActivityMainBinding
import com.example.themoviedb.views.recyclerview.MovieAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { MainViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerMovie.layoutManager = GridLayoutManager(this, 3)
        viewModel.movieList.observe(this) { movie ->
            binding.recyclerMovie.adapter = movie?.let {
                MovieAdapter(it)
            }
        }
        viewModel.loading.observe(this) { loading ->
           binding.progressBar.visibility =if(loading) View.VISIBLE else View.INVISIBLE
        }
        viewModel.getMovieList()
    }
}