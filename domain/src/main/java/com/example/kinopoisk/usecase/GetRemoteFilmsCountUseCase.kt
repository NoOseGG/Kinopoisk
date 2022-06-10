package com.example.kinopoisk.usecase

import com.example.kinopoisk.repository.FilmRemoteRepository

class GetRemoteFilmsCountUseCase(
    private val repository: FilmRemoteRepository
) {

    suspend operator fun invoke(): Int {
        return repository.getPageCount()
    }
}