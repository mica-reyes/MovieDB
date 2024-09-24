package com.example.themoviedb.data

import com.example.themoviedb.BuildConfig
import retrofit2.awaitResponse

class MovieRemoteDataSource {
    suspend fun getMovieList(): MovieList? {
        val service = RetrofitService.instance.create(MovieService::class.java)
            .getMovieList(BuildConfig.API_KEY)
        try {
            val response = service.awaitResponse()
            return response.body()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getUpcomingList(): MovieList?{
        val service= RetrofitService.instance.create((MovieService::class.java))
            .getUpcomingList(BuildConfig.API_KEY)
        try {
            val response = service.awaitResponse()
            return response.body()
        } catch (e: Exception) {
            return null
        }
    }
    suspend fun getTopRatedList(): MovieList?{
        val service= RetrofitService.instance.create((MovieService::class.java))
            .getTopRatedList(BuildConfig.API_KEY)
        try {
            val response = service.awaitResponse()
            return response.body()
        } catch (e: Exception) {
            return null
        }
    }
    suspend fun getDetails(id: Int): Detail? {
        val service= RetrofitService.instance.create(DetailService::class.java)
            .getDetails(id, BuildConfig.API_KEY)
        try {
            val response= service.awaitResponse()
            return response.body()
        }catch (e: Exception){
            return null
        }
    }
}