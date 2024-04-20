package com.example.moviesapp.feature.movies.interactor

import com.example.moviesapp.feature.movies.data.MovieServices
import com.example.moviesapp.feature.movies.data.model.MovieList
import retrofit2.Call

class GetPopularMovies(private val page: Int) : GetMovies(page) {
    override fun getApiMethod(): Call<MovieList> {
        return MovieServices().popularMovies(page)
    }
}