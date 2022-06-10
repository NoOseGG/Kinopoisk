package com.example.kinopoisk.repository

import com.example.kinopoisk.model.Film

interface FilmRemoteRepository {

    suspend fun getFilms(page: Int): List<Film>

    suspend fun getPageCount(): Int
}