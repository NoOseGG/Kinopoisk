package com.example.kinopoisk.koin

import androidx.room.Room
import com.example.kinopoisk.room.FilmDao
import com.example.kinopoisk.room.FilmDataBase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            FilmDataBase::class.java,
            "film-database"
        )
            .build()
    }

    single<FilmDao> {
        get()
    }
}