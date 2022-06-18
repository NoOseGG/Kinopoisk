package com.example.kinopoisk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.kinopoisk.paging.FilmDataSource
import com.example.kinopoisk.usecase.GetRemoteFilmsCountUseCase
import com.example.kinopoisk.usecase.GetRemoteFilmsUseCase

class ListViewModel(
    private val getRemoteFilmsUseCase: GetRemoteFilmsUseCase,
    private val getRemoteFilmsCountUseCase: GetRemoteFilmsCountUseCase
) : ViewModel() {

    val films = Pager(PagingConfig(PAGE_SIZE)) {
        FilmDataSource(
            getRemoteFilmsUseCase,
            getRemoteFilmsCountUseCase
        )
    }.flow.cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE = 30
    }
}