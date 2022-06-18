package com.example.kinopoisk.model

data class FilmDetailsDTO(
    val kinopoiskId: Int,
    val nameRu: String,
    val posterUrl: String,
    val coverUrl: String,
    val ratingKinopoisk: Double,
    val ratingImdb: Double,
    val slogan: String,
    val description: String,
    val type: String,
    val countries: List<Country>,
    val genres: List<Genre>
)