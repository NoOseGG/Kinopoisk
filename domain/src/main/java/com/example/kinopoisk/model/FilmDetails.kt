package com.example.kinopoisk.model

data class FilmDetails(
    val kinopoiskId: Int,
    val imdbId: String,
    val nameRu: String,
    val nameEn: String,
    val nameOriginal: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val reviewsCount: Int,
    val ratingGoodReview: Double,
    val ratingKinopoisk: Double,
    val ratingImdb: Double,
    val ratingFilmCritics: Double
)