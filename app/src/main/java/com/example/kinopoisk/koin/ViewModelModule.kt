package com.example.kinopoisk.koin

import com.example.kinopoisk.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ListViewModel)
}