package com.example.themoviedb.data

import com.example.themoviedb.data.remote.MovieService

class MovieRepository(private val movieService: MovieService) {
    suspend fun getMovieList(): MovieList{
       return movieService.getMovieList()
    }

    suspend fun getUpcomingList() : MovieList{
        return movieService.getUpcomingList()
    }

    suspend fun getTopRatedList(): MovieList{
        return movieService.getTopRatedList()
    }

    suspend fun getDetail(id: Int): Detail{
        return movieService.getDetails(id)
    }
}
