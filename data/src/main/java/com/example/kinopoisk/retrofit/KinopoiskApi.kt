package com.example.kinopoisk.retrofit

import com.example.kinopoisk.model.FilmDTO
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.model.FilmDetailsDTO
import com.example.kinopoisk.model.FilmListDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {

    @Headers("X-API-KEY: 231b7063-6a29-4565-9538-cae1c813e0d6")
    @GET("/api/v2.2/films/top")
    suspend fun getTop250Films(
        @Query("page") page: Int
    ): FilmListDTO

    @Headers("X-API-KEY: 231b7063-6a29-4565-9538-cae1c813e0d6")
    @GET("/api/v2.2/films/{id}")
    suspend fun getFilm(
        @Path("id") id: Int
    ): FilmDetailsDTO
}