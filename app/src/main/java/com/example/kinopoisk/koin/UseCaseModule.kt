package com.example.kinopoisk.koin

import com.example.kinopoisk.usecase.GetRemoteFilmUseCase
import com.example.kinopoisk.usecase.GetRemoteFilmsCountUseCase
import com.example.kinopoisk.usecase.GetRemoteFilmsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetRemoteFilmsUseCase)
    factoryOf(::GetRemoteFilmsCountUseCase)
    factoryOf(::GetRemoteFilmUseCase)
}