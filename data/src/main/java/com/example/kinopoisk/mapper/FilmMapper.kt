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
        nameRu = nameRu,
        posterUrl = posterUrlPreview
    )
}

