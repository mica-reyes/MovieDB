package com.example.themoviedb.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getMovieList(@Query("api_key") api_key: String):Call<MovieList>
}
