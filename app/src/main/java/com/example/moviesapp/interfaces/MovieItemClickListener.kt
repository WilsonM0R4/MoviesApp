package com.example.moviesapp.interfaces

import com.example.moviesapp.models.Movie

interface MovieItemClickListener {
    fun onItemClicked(movie:Movie)
}