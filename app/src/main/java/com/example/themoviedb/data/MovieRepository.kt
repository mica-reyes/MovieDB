package com.example.themoviedb.data

import com.example.themoviedb.data.local.GenreEntity
import com.example.themoviedb.data.local.MovieDao
import com.example.themoviedb.data.local.MovieWithGenres
import com.example.themoviedb.data.remote.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class MovieRepository(private val movieService: MovieService, private val movieDao: MovieDao) {
    suspend fun getMovieList(): MovieList {
        return movieService.getMovieList()
    }

    suspend fun getUpcomingList(): MovieList {
        return movieService.getUpcomingList()
    }

    suspend fun getTopRatedList(): MovieList {
        return movieService.getTopRatedList()
    }

    suspend fun getDetail(id: Int): Movie {
        val dbDetail = movieDao.getDetailDB(id).firstOrNull()
        return dbDetail?.toDomain() ?: movieService.getDetail(id)
    }

    fun getMyList(): Flow<List<MovieWithGenres>?> {
        return movieDao.getMyList()
    }

    suspend fun insertMovieFav(movie: Movie) {
        movieDao.insertMovieFav(movie.toEntity())
    }

    suspend fun insertGenreEntity(movie: Movie) {
        movie.genres.forEach {
            movieDao.insertGenreEntity(
                GenreEntity(
                    movieId = movie.id,
                    name = it.name,
                    genreId = it.id
                )
            )
        }
    }

    fun getDetailDb(movieId: Int): Flow<MovieWithGenres> {
        return movieDao.getDetailDB(movieId)
    }

    suspend fun deleteMovieFav(movieId: Int){
        movieDao.deleteMovieFav(movieId)
    }
}
