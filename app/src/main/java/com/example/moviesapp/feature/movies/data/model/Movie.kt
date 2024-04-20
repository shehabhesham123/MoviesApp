package com.example.moviesapp.feature.movies.data.model

import com.google.gson.annotations.SerializedName

class Movie(
    id: Int,
    title: String,
    release_date: String,
    poster_path: String,
    vote_average: Float
) {
    var id: Int = id
        private set
    var title: String = title
        private set
    var release_date: String = release_date
        private set
    var poster_path: String = poster_path
        private set
    var vote_average: Float = vote_average
        private set
}

class MovieList {
    @SerializedName("results")
    lateinit var movies: List<Movie>
        private set
}