package com.example.themoviedb.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailService {
    @GET("movie/{id}")
    fun getDetails( @Path("id") id: Int,@Query("api_key") api_key: String): Call<Detail>
}





//https://api.themoviedb.org/3/movie/610150?api_key=02b937e92a2cf7b80f994d5c538d3d6d