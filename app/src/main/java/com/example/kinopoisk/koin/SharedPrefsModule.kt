package com.example.kinopoisk.koin

import com.example.kinopoisk.manager.SharedPrefsManager
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sharedPrefsModule = module {
    singleOf(::SharedPrefsManager)
}