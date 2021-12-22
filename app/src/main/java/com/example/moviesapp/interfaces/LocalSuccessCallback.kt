package com.example.moviesapp.interfaces

import com.example.moviesapp.models.Movie

interface LocalSuccessCallback {
    fun onSuccess(array: ArrayList<Movie>)
}