package com.example.kinopoisk.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kinopoisk.model.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class FilmDataBase : RoomDatabase(){

    abstract fun filmDao(): FilmDao
}