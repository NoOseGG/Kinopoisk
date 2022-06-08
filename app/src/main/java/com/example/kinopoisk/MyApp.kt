package com.example.kinopoisk

import android.app.Application
import com.example.kinopoisk.koin.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            networkModule
        }
    }
}