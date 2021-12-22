package com.example.moviesapp.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.interfaces.MoviesDAO

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDAO() : MoviesDAO
}