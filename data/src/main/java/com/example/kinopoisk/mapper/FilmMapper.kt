package com.example.kinopoisk.mapper

import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmDTO
import com.example.kinopoisk.model.FilmDetails

fun FilmDTO.toFilm(): Film {
    return Film(
        kinopoiskId = kinopoiskId,
        posterUrl = posterUrl
    )
}

fun FilmDTO.toFilmDetails(): FilmDetails {
    return FilmDetails(
        kinopoiskId = kinopoiskId,
        imdbId = imdbId,
        nameRu = nameRu,
        nameEn = nameEn,
        nameOriginal = nameOriginal,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        reviewsCount = reviewsCount,
        ratingGoodReview = ratingGoodReview,
        ratingKinopoisk = ratingKinopoisk,
        ratingImdb = ratingImdb,
        ratingFilmCritics = ratingFilmCritics
    )
}