package com.example.kinopoisk.model

data class FilmDetails(
    val filmId: Int,
    val nameRu: String,
    val nameEn: String,
    val year: Int,
    val filmLength: String,
    val posterUrl: String
)