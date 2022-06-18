package com.example.kinopoisk.repository

import com.example.kinopoisk.mapper.toFilmDetails
import com.example.kinopoisk.mapper.toFilmEntity
import com.example.kinopoisk.mapper.toListFilmDetails
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.room.FilmDao

class FilmLocaleRepositoryImpl(
    private val filmDao: FilmDao
) : FilmLocaleRepository {

    override suspend fun getFilms(): Result<List<FilmDetails>> {
        return runCatching {
            filmDao.getFilms().map {
                it.toFilmDetails()
            }
        }
    }

    override suspend fun getFilm(id: Int): Result<FilmDetails> {
        return runCatching {
            filmDao.getFilm(id).toFilmDetails()
        }
    }


    override suspend fun insertFilm(filmDetails: FilmDetails) {
        println("$filmDetails ADDDDDDDDDDDDDDDED")
        filmDao.insertFilm(filmDetails.toFilmEntity())
    }

    override suspend fun deleteFilm(filmDetails: FilmDetails) {
        filmDao.deleteFilm(filmDetails.toFilmEntity())
    }
}