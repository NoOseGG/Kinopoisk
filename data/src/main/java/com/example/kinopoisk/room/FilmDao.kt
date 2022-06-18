package com.example.kinopoisk.room

import androidx.room.*
import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM film")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM film WHERE kinopoisk_id = :id")
    suspend fun getFilm(id: Int): FilmEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(filmEntity: FilmEntity)

    @Delete
    suspend fun deleteFilm(filmEntity: FilmEntity)
}