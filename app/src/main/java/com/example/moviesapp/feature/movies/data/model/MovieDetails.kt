package com.example.moviesapp.feature.movies.data.model

import com.google.gson.annotations.SerializedName

class MovieDetails(
    id: Int,
    title: String,
    overview: String,
    release_date: String,
    genres: List<CategoryList>,
    runtime: Int,
    vote_average: Float,
    budget: Long,
    revenue: Long
) {
    var id: Int = id
        private set
    var title: String = title
        private set
    var overview: String = overview
        private set
    var release_date: String = release_date
        private set

    @SerializedName("genres")
    var genres: List<CategoryList> = genres
        private set
    var runtime: Int = runtime
        private set
    var vote_average: Float = vote_average
        private set
    var budget: Long = budget
        private set
    var revenue: Long = revenue
        private set
}