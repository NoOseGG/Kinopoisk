package com.example.kinopoisk.repository

import com.example.kinopoisk.mapper.toFilmDetails
import com.example.kinopoisk.mapper.toListFilm
import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.retrofit.KinopoiskApi

class FilmRemoteRepositoryImpl(
    private val api: KinopoiskApi
) : FilmRemoteRepository {

    override suspend fun getFilms(page: Int): List<Film> {
        return api.getTop250Films(page).toListFilm()
    }

    override suspend fun getFilm(id: Int): FilmDetails {
        return api.getFilm(id).toFilmDetails()
    }

    override suspend fun getPageCount(): Int {
        return api.getTop250Films(1).pagesCount
    }
}