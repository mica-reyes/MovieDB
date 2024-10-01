package com.example.themoviedb.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovieFav(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenreEntity(genre:GenreEntity)

    @Transaction
    @Query("SELECT * from movie_table ORDER BY date ASC ")
    fun getMyList(): Flow<List<MovieWithGenres>>

    @Query("SELECT * from movie_table WHERE id= :movieId")
    fun getDetailDB(movieId: Int): Flow<MovieWithGenres>

    @Query("DELETE from movie_table WHERE id= :movieId")
    suspend fun deleteMovieFav(movieId: Int)

    @Query("DELETE from genreentity WHERE movieId= :movieId")
    suspend fun deleteGenre(movieId: Int)
}