package com.example.themoviedb.data

import com.example.themoviedb.data.local.MovieEntity
import com.example.themoviedb.data.local.MovieWithGenres

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        image = this.image,
        title = this.title,
        fav = this.fav,
        releaseDate = this.releaseDate,
        description = this.description
    )
}

fun MovieWithGenres.toDomain(): Movie {
    return Movie(
        id = this.movie.id,
        title = this.movie.title,
        image = this.movie.image,
        releaseDate = this.movie.releaseDate,
        description = this.movie.description,
        fav = this.movie.fav,
        genres = this.genresList.map {
            Genres(
                name = it.name,
                id = it.genreId
            )
        }
    )
}