package com.example.kinopoisk.retrofit

import com.example.kinopoisk.model.FilmDTO
import com.example.kinopoisk.model.FilmListDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {

    @Headers("X-API-KEY: 1c389672-6a5d-4cd0-889f-95555177e69a")
    @GET("/api/v2.2/films/top")
    suspend fun getTop250Films(
        @Query("page") page: Int
    ) : FilmListDTO
}