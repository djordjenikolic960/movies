package com.example.moviesapi.feature.data.data_source.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

}