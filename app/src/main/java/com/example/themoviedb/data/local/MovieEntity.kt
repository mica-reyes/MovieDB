package com.example.themoviedb.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val image: String,
    val date: Long = System.currentTimeMillis(),
    var fav: Boolean= true,
    val title: String,
    val releaseDate: String,
    val description: String,
)

@Entity
data class GenreEntity(
   @PrimaryKey(autoGenerate = true) val genreId: Int,
   //@PrimaryKey(autoGenerate = false) val genreId: Int,
    val movieId: Int,
    val name: String,
)

//https://developer.android.com/training/data-storage/room/relationships?hl=es-419#kotlin
data class MovieWithGenres(
    @Embedded val movie: MovieEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val genresList: List<GenreEntity>,
)