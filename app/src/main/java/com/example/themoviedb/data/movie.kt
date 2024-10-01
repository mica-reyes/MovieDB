package com.example.themoviedb.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val image: String,
    @SerializedName("genres") val genres: List<Genres>,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("overview") val description: String,
    var fav: Boolean= false,
    )

data class Genres(
    val name: String,
   // val id:Int
)

data class MovieList(@SerializedName("results") val results: List<Movie>)

//image --> {´https://image.tmdb.org/t/p/w500{poster_path} ´

//https://image.tmdb.org/t/p/w500/hYZ4a0JvPETdfgJJ9ZzyFufq8KQ.jpg