package com.example.kinopoisk.usecase

import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.repository.FilmLocaleRepository

class InsertLocaleFilmUseCase(
    private val repository: FilmLocaleRepository
) {

    suspend operator fun invoke(filmDetails: FilmDetails) {
        repository.insertFilm(filmDetails)
    }
}