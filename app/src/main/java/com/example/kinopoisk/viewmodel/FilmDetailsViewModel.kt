package com.example.kinopoisk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.usecase.DeleteLocaleFilmUseCase
import com.example.kinopoisk.usecase.GetLocaleFilmUseCase
import com.example.kinopoisk.usecase.GetRemoteFilmUseCase
import com.example.kinopoisk.usecase.InsertLocaleFilmUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class FilmDetailsViewModel(
    private val getRemoteFilmUseCase: GetRemoteFilmUseCase,
    private val insertLocaleFilmUseCase: InsertLocaleFilmUseCase,
    private val deleteLocaleFilmUseCase: DeleteLocaleFilmUseCase,
    private val getLocaleFilmUseCase: GetLocaleFilmUseCase,
    private val filmId: Int
) : ViewModel() {

    val filmDetailsFlow = flow {
        getLocaleFilmUseCase(filmId).fold(
            onSuccess = {
                emit(it)
            },
            onFailure = {
                val film = getRemoteFilmUseCase(filmId)
                emit(film)
            }
        )
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )

    suspend fun insertFilm(filmDetails: FilmDetails) {
        insertLocaleFilmUseCase(filmDetails)
    }

    suspend fun deleteFilm(filmDetails: FilmDetails) {
        deleteLocaleFilmUseCase(filmDetails)
    }
}