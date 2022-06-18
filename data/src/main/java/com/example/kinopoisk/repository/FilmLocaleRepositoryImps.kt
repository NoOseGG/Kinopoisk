package com.example.kinopoisk.repository

import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.room.FilmDao

class FilmLocaleRepositoryImps(
    private val filmDao: FilmDao
) : FilmLocaleRepository {
    override suspend fun getFilms(): Result<List<FilmDetails>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertFilm(filmDetails: FilmDetails) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFilm(filmDetails: FilmDetails) {
        TODO("Not yet implemented")
    }
}