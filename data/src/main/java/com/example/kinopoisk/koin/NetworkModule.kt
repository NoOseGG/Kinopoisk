package com.example.kinopoisk.koin

import com.example.kinopoisk.retrofit.KinopoiskApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://kinopoiskapiunofficial.tech"

val networkModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single<KinopoiskApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(KinopoiskApi::class.java)
    }
}