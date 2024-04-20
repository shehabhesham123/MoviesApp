package com.example.moviesapp.feature.movies.data

import com.example.moviesapp.feature.movies.data.model.CategoryList
import com.example.moviesapp.feature.movies.data.model.MovieDetails
import com.example.moviesapp.feature.movies.data.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesApi {
    companion object {
        private const val MOVIE_ID = "movieId"

        private const val MOVIES_TASK =
            "3/discover/movie?language=en-US&sort_by=popularity.desc"
        private const val CATEGORY_TASK = "3/genre/movie/list?language=en"
        private const val POPULAR_MOVIES_TASK = "3/movie/popular?language=en-US"
        private const val MOVIE_DETAILS_TASK = "3/movie/{$MOVIE_ID}?language=en-US"
        const val TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMTE3ZTNkYjcyNzE1OWQ2OWRlNDk3OGZiYjBhMjFiMiIsInN1YiI6IjY2MWRkNjBmMjBhZjc3MDE3ZDNkMzkwNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNRCu_nPrja8hyUi1fV9ff_s1uIIr1b4pPloutel-S8"

    }

    @Headers(
        "accept:application/json",
        "Authorization:Bearer $TOKEN"
    )
    @GET(MOVIES_TASK)
    fun movies(@Query("page") page: Int): Call<MovieList>

    @Headers(
        "accept:application/json",
        "Authorization:Bearer $TOKEN"
    )
    @GET(CATEGORY_TASK)
    fun categories(): Call<CategoryList>

    @Headers(
        "accept:application/json",
        "Authorization:Bearer $TOKEN"
    )
    @GET(MOVIES_TASK)
    fun movies(@Query("page") page: Int, @Query("with_genres") category: Int): Call<MovieList>

    @Headers(
        "accept:application/json",
        "Authorization:Bearer $TOKEN"
    )
    @GET(POPULAR_MOVIES_TASK)
    fun popularMovies(@Query("page") page: Int): Call<MovieList>

    @Headers(
        "accept:application/json",
        "Authorization:Bearer $TOKEN"
    )
    @GET(MOVIE_DETAILS_TASK)
    fun movieDetails(@Path(MOVIE_ID) movieId: Int): Call<MovieDetails>

}