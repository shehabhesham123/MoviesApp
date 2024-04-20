package com.example.moviesapp.core.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        private const val TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMTE3ZTNkYjcyNzE1OWQ2OWRlNDk3OGZiYjBhMjFiMiIsInN1YiI6IjY2MWRkNjBmMjBhZjc3MDE3ZDNkMzkwNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNRCu_nPrja8hyUi1fV9ff_s1uIIr1b4pPloutel-S8"

        private var retrofit: Retrofit? = null

        fun instance(): Retrofit {
            val httpClient = OkHttpClient()
            httpClient.networkInterceptors().add(Interceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                requestBuilder.header("accept", "application/json")
                requestBuilder.header("Authorization", "Bearer $TOKEN")
                chain.proceed(requestBuilder.build())
            })

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            }

            return retrofit!!
        }
    }
}