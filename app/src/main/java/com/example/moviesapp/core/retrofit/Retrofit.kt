package com.example.moviesapp.core.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        private val retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun instance() = retrofit

    }
}