package com.example.kinopoisk.repository

import com.example.kinopoisk.model.FilmDetails

interface FilmLocaleRepository {

    suspend fun getFilms(): Result<List<FilmDetails>>

    suspend fun insertFilm(filmDetails: FilmDetails)

    suspend fun deleteFilm(filmDetails: FilmDetails)
}