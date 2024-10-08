package com.example.themoviedb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class, GenreEntity::class], version = 2)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}