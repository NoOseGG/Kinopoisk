package com.example.kinopoisk.model

data class FilmListDTO(
    val pagesCount: Int,
    val films: List<FilmDTO>
)