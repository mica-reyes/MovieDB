package com.example.themoviedb.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getMovieList(@Query("api_key") api_key: String):Call<MovieList>

    @GET ("movie/upcoming")
    fun getUpcomingList(@Query("api_key") api_key: String):Call<MovieList>

    @GET ("movie/top_rated")
    fun getTopRatedList(@Query("api_key") api_key: String):Call<MovieList>
}
