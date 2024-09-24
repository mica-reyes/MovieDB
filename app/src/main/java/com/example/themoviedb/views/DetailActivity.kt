package com.example.themoviedb.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.databinding.ActivityDetailBinding
import com.example.themoviedb.views.recyclerview.GenreAdapter
import eightbitlab.com.blurview.RenderScriptBlur

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels(
        factoryProducer = { DetailViewModelFactory() }
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
            binding.tvTitle.text = detail?.title
            binding.recyclerGenre.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            viewModel.detail.observe(this){genre ->
                binding.recyclerGenre.adapter= genre?.let {
                    GenreAdapter(it.genres)
                }
            }
            binding.tvReleaseDate.text = detail?.release_date.toString().substring(0,4)
            binding.tvDescription.text = detail?.description.toString()

            val requestOptions= RequestOptions().transform(CenterCrop(), GranularRoundedCorners(0f, 0f, 50f, 50f))
            Glide.with(binding.ivPoster.context)
                .load("${BuildConfig.IMAGE_URL}${detail?.poster}")
                .apply(requestOptions)
                .into(binding.ivPoster)

            binding.backBtn.setOnClickListener {
                finish()
            }

            val radius= 10f
            val decorView= window.decorView
            val rootView= decorView.findViewById<ViewGroup>(android.R.id.content)
            val windowsBackground= decorView.background
            binding.blurView.setupWith(rootView, RenderScriptBlur(this))
                .setFrameClearDrawable(windowsBackground)
                .setBlurRadius(radius)
            binding.blurView.outlineProvider= ViewOutlineProvider.BACKGROUND
            binding.blurView.clipToOutline= true
        }
        if (id != null) {
            viewModel.getDetail(id)
        }
        viewModel.loading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
            binding.blurView.visibility= if (loading) View.INVISIBLE else View.VISIBLE
            binding.backBtn.visibility= if (loading) View.INVISIBLE else View.VISIBLE
        }

    }
}