package com.example.kinopoisk.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kinopoisk.usecase.GetFilmsLocaleUseCase
import kotlinx.coroutines.flow.flow

class FavouritesViewModel(
    private val getFilmsLocaleUseCase: GetFilmsLocaleUseCase
) : ViewModel() {

    val filmsFlow = flow {
        val films = getFilmsLocaleUseCase()
        films.fold(
            onSuccess = {
                emit(it)
            },
            onFailure = {

            }
        )
    }
}