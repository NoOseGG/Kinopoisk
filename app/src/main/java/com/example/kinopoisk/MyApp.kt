package com.example.kinopoisk

import android.app.Application
import com.example.kinopoisk.koin.networkModule
import com.example.kinopoisk.koin.repositoryModule
import com.example.kinopoisk.koin.useCaseModule
import com.example.kinopoisk.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                networkModule,
                useCaseModule,
                viewModelModule,
                repositoryModule
            )
        }
    }
}