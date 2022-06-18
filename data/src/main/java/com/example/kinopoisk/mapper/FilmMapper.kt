package com.example.kinopoisk.mapper

import com.example.kinopoisk.model.*

fun FilmListDTO.toListFilm(): List<Film> {
    return films.map {
        it.toFilm()
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