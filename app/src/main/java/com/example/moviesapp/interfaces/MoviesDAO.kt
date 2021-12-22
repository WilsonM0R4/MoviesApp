package com.example.moviesapp.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviesapp.models.Movie

@Dao
interface MoviesDAO {
    @Query("select * from Movie")
    fun getAll() : Array<Movie>

    @Insert
    fun insertMovie(vararg movies: Movie)
}