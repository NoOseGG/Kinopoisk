package com.example.kinopoisk.koin

import com.example.kinopoisk.usecase.*
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetRemoteFilmsUseCase)
    factoryOf(::GetRemoteFilmsCountUseCase)
    factoryOf(::GetRemoteFilmUseCase)
    factoryOf(::InsertLocaleFilmUseCase)
    factoryOf(::DeleteLocaleFilmUseCase)
    factoryOf(::GetLocaleFilmUseCase)
    factoryOf(::GetFilmsLocaleUseCase)
}