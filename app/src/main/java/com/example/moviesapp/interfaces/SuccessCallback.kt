package com.example.moviesapp.interfaces

import com.example.moviesapp.models.Response


interface SuccessCallback {
    fun onSuccess(response:Response)
}