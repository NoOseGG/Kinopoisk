package com.example.kinopoisk.usecase

import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.repository.FilmLocaleRepository

class GetFilmsLocaleUseCase(
    private val repository: FilmLocaleRepository
) {

    suspend operator fun invoke(): Result<List<FilmDetails>> {
        return repository.getFilms()
    }
}