package com.example.kinopoisk.mapper

import com.example.kinopoisk.model.*
import org.w3c.dom.Entity

fun FilmListDTO.toListFilm(): List<Film> {
    return films.map {
        it.toFilm()
    }
}

fun List<FilmEntity>.toListFilmDetails(): List<FilmDetails> {
    return this.map {
        it.toFilmDetails()
    }
}

fun FilmDTO.toFilm(): Film {
    return Film(
        filmId = filmId,
        nameRu = nameRu,
        posterUrl = posterUrlPreview
    )
}

fun FilmDetailsDTO.toFilmDetails(): FilmDetails {
    return FilmDetails(
        kinopoiskId = kinopoiskId,
        nameRu = nameRu,
        posterUrl = posterUrl,
        coverUrl = coverUrl,
        ratingKinopoisk = ratingKinopoisk,
        ratingImdb = ratingImdb,
        slogan = slogan ?: "",
        description = description,
        type = type,
        countries = countries,
        genres = genres
    )
}

fun FilmEntity.toFilmDetails(): FilmDetails {
    return FilmDetails(
        kinopoiskId = kinopoiskId,
        nameRu = nameRu,
        posterUrl = posterUrl,
        coverUrl = coverUrl,
        ratingKinopoisk = ratingKinopoisk,
        ratingImdb = ratingImdb,
        slogan = slogan ?: "",
        description = description,
        type = type,
        countries = emptyList(),
        genres = emptyList(),
        favorites = favorites
    )
}

fun FilmDetails.toFilmEntity(): FilmEntity {
    return FilmEntity(
        kinopoiskId = kinopoiskId,
        nameRu = nameRu,
        posterUrl = posterUrl,
        coverUrl = coverUrl,
        ratingKinopoisk = ratingKinopoisk,
        ratingImdb = ratingImdb,
        slogan = slogan,
        description = description,
        type = type,
        favorites = favorites
    )
}