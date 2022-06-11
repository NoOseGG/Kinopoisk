package com.example.kinopoisk.usecase

import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.repository.FilmRemoteRepository

class GetRemoteFilmUseCase(
    private val filmRemoteRepository: FilmRemoteRepository
) {

    suspend operator fun invoke(id: Int): FilmDetails {
        return filmRemoteRepository.getFilm(id)
    }
}