package com.example.kinopoisk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.usecase.GetRemoteFilmUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class FilmDetailsViewModel(
    private val getRemoteFilmUseCase: GetRemoteFilmUseCase,
    private val filmId: Int
) : ViewModel() {

    val filmDetailsFlow = flow {
        val film = getRemoteFilmUseCase.invoke(filmId)
        emit(film)
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )
}