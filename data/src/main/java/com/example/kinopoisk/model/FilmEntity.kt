package com.example.kinopoisk.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film")
data class FilmEntity(
    @PrimaryKey
    @ColumnInfo(name = "kinopoisk_id")
    var kinopoiskId: Int,
    @ColumnInfo(name = "name_ru")
    var nameRu: String,
    @ColumnInfo(name = "poster_url")
    var posterUrl: String,
    @ColumnInfo(name = "cover_url")
    var coverUrl: String,
    @ColumnInfo(name = "rating_kinopoisk")
    var ratingKinopoisk: Double,
    @ColumnInfo(name = "rating_imdb")
    var ratingImdb: Double,
    @ColumnInfo(name = "slogan")
    var slogan: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "favorites")
    var favorites: Boolean
)