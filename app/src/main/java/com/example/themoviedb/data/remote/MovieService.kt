package com.example.themoviedb.data.remote

import com.example.themoviedb.data.Detail
import com.example.themoviedb.data.MovieList
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/popular")
    suspend fun getMovieList(): MovieList

    @GET ("movie/upcoming")
    suspend fun getUpcomingList(): MovieList

    @GET ("movie/top_rated")
    suspend fun getTopRatedList(): MovieList

    @GET("movie/{id}")
    suspend fun getDetails(@Path("id") id: Int): Detail
}
