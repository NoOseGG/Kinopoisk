package com.example.kinopoisk.retrofit

import com.example.kinopoisk.model.FilmDTO
import com.example.kinopoisk.model.FilmListDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {

    @Headers("X-API-KEY: 7ca4fe8e-239b-4458-a3c7-eb08c32123cb")
    @GET("/api/v2.2/films/top")
    suspend fun getTop250Films(
        @Query("page") page: Int
    ) : FilmListDTO
}