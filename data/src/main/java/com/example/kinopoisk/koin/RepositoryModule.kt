package com.example.kinopoisk.koin

import com.example.kinopoisk.repository.FilmLocaleRepository
import com.example.kinopoisk.repository.FilmLocaleRepositoryImpl
import com.example.kinopoisk.repository.FilmRemoteRepository
import com.example.kinopoisk.repository.FilmRemoteRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<FilmRemoteRepository> {
        FilmRemoteRepositoryImpl(
            api = get()
        )
    }

    single<FilmLocaleRepository> {
        FilmLocaleRepositoryImpl(
            filmDao = get()
        )
    }
}