package com.example.kinopoisk.mapper

import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmDTO
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.model.FilmListDTO

fun FilmListDTO.toListFilm(): List<Film> {
    return films.map {
        it.toFilm()
    }
}

fun FilmDTO.toFilm(): Film {
    return Film(
        filmId = filmId,
        posterUrl = posterUrl
    )
}

fun FilmDTO.toFilmDetails(): FilmDetails {
    return FilmDetails(
        filmId = filmId,
        nameRu = nameRu,
        nameEn = nameEn,
        year = year,
        filmLength = filmLength,
        posterUrl = posterUrl,
    )
}