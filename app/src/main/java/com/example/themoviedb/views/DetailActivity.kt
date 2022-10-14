package com.example.themoviedb.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { MainViewModelFactory() }
    )

    companion object {
        const val ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent?.extras?.getInt(ID)

        viewModel.detail.observe(this) { detail ->

            val genres = detail?.genres?.map { genres -> genres.name }?.joinToString(", ")

            binding.tvTitle.text = detail?.title
            binding.tvGenres.text = "Genres: $genres"
            binding.tvOriginalLanguage.text =
                "Original Language: ${detail?.original_language.toString()}"
            binding.tvPopularity.text = "Popularity: ${detail?.popularity.toString()}"
            binding.tvReleaseDate.text = "Release Date: ${detail?.release_date.toString()}"
            binding.tvDescription.text = detail?.description.toString()

            Glide.with(binding.ivPoster.context).load("${BuildConfig.IMAGE_URL}${detail?.poster}")
                .into(binding.ivPoster)
        }
        if (id != null) {
            viewModel.getDetail(id)
        }
        viewModel.loading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
        }

    }
}