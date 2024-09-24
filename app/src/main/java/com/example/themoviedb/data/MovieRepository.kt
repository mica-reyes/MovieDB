package com.example.themoviedb.data

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource) {
    suspend fun getMovieList(): MovieList?{
       return remoteDataSource.getMovieList()
    }

    suspend fun getUpcomingList() : MovieList?{
        return remoteDataSource.getUpcomingList()
    }

    suspend fun getTopRatedList(): MovieList?{
        return remoteDataSource.getTopRatedList()
    }

    suspend fun getDetail(id: Int): Detail?{
        return remoteDataSource.getDetails(id)
    }
}
