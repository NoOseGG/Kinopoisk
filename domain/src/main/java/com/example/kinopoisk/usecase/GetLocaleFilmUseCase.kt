package com.example.kinopoisk.usecase

import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.repository.FilmLocaleRepository

class GetLocaleFilmUseCase(
    private val repository: FilmLocaleRepository
) {

    suspend operator fun invoke(id: Int): Result<FilmDetails> {
        return repository.getFilm(id)
    }
}