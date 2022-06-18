package com.example.kinopoisk.repository

import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmDetails

interface FilmRemoteRepository {

    suspend fun getFilms(page: Int): List<Film>

    suspend fun getFilm(id: Int): FilmDetails

    suspend fun getPageCount(): Int
}