package com.example.kinopoisk.repository

import com.example.kinopoisk.mapper.toListFilm
import com.example.kinopoisk.model.Film
import com.example.kinopoisk.retrofit.KinopoiskApi

class FilmRemoteRepositoryImpl(
    private val api: KinopoiskApi
) : FilmRemoteRepository {

    override suspend fun getFilms(page: Int): List<Film> {
        val films = api.getTop250Films(page).toListFilm()
        println("films: $films")
        return films
    }

    override suspend fun getPageCount(): Int {
        return api.getTop250Films(1).pagesCount
    }
}