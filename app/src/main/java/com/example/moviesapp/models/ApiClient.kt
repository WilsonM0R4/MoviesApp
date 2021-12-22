package com.example.moviesapp.models

import com.example.moviesapp.commons.Constants
import com.example.moviesapp.interfaces.FailureCallback
import com.example.moviesapp.interfaces.MovieQuery
import com.example.moviesapp.interfaces.SuccessCallback
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private fun getClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                 val builder = chain.request().newBuilder()
                 builder.header("Content-Type","application/json")
                 return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()
        return Retrofit.Builder().baseUrl(Constants.API_MAIN_PATH)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    fun getMovies(success:SuccessCallback, failure:FailureCallback) {
        getClient().create(MovieQuery::class.java).getMovies(Constants.API_KEY)
            .enqueue(object: Callback<Response>{
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    response.body()?.let { success.onSuccess(it) }
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    failure.onFailure()
                }

            })
    }

}