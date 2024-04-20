package com.example.moviesapp.feature.movies.interactor

import com.example.moviesapp.feature.movies.data.MovieServices
import com.example.moviesapp.feature.movies.data.model.Movie
import com.example.moviesapp.feature.movies.data.model.MovieList
import retrofit2.Call

class GetMovies2(private val page: Int, private val category: Int) : GetMovies(page) {
    override fun getApiMethod(): Call<MovieList> {
        return MovieServices().movies(page, category)
    }
}