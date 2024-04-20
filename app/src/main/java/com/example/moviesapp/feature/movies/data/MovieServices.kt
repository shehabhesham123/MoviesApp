package com.example.moviesapp.feature.movies.data

import com.example.moviesapp.core.retrofit.Retrofit
import com.example.moviesapp.feature.movies.data.model.CategoryList
import com.example.moviesapp.feature.movies.data.model.MovieDetails
import com.example.moviesapp.feature.movies.data.model.MovieList
import retrofit2.Call

class MovieServices : MoviesApi {

    private val movieApi by lazy {
        Retrofit.instance().create(MoviesApi::class.java)
    }

    override fun movies(page: Int): Call<MovieList> = movieApi.movies(page)

    override fun movies(page: Int, category: Int): Call<MovieList> =
        movieApi.movies(page, category)

    override fun categories(): Call<CategoryList> = movieApi.categories()

    override fun popularMovies(page: Int): Call<MovieList> = movieApi.popularMovies(page)

    override fun movieDetails(movieId: Int): Call<MovieDetails> = movieApi.movieDetails(movieId)
}