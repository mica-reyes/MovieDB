package com.example.themoviedb.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val image: String
)

data class Detail(
    @SerializedName("title") val title: String,
    @SerializedName("genres") val genres: List<Genres>,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("overview") val description: String,
    @SerializedName("poster_path") val poster: String
)

data class Genres(
    val name: String
)

data class MovieList(@SerializedName("results") val results: List<Movie>)

//image --> {´https://image.tmdb.org/t/p/w500{poster_path} ´

//https://image.tmdb.org/t/p/w500/hYZ4a0JvPETdfgJJ9ZzyFufq8KQ.jpg