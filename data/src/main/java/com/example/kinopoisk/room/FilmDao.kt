package com.example.kinopoisk.room

import androidx.room.Dao
import androidx.room.Query
import com.example.kinopoisk.model.FilmEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM film")
    suspend fun getFilms(): Result<List<FilmEntity>>
}