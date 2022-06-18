package com.example.kinopoisk.usecase

import com.example.kinopoisk.model.Film
import com.example.kinopoisk.repository.FilmRemoteRepository

class GetRemoteFilmsUseCase(
    private val repository: FilmRemoteRepository
) {

    suspend operator fun invoke(page: Int): List<Film> {
        println("2222222222222222222222222222222")
        return repository.getFilms(page)
    }
}