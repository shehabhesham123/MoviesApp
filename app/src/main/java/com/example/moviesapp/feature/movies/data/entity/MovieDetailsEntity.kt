package com.example.moviesapp.feature.movies.data.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.moviesapp.feature.movies.data.model.CategoryList
import com.example.moviesapp.feature.movies.data.model.MovieDetails

@Entity(tableName = "movie_details_table")
class MovieDetailsEntity(
    id: Int,
    title: String,
    overview: String,
    release_date: String,
    runtime: Int,
    vote_average: Float,
    budget: Long,
    revenue: Long
) {
    @PrimaryKey
    var id: Int = id
        private set
    var title: String = title
        private set
    var overview: String = overview
        private set
    var release_date: String = release_date
        private set

    @Ignore
    var genres: List<CategoryList> = mutableListOf()
        private set
    var runtime: Int = runtime
        private set
    var vote_average: Float = vote_average
        private set
    var budget: Long = budget
        private set
    var revenue: Long = revenue
        private set

    fun toMovieDetails() = MovieDetails(
        id,
        title,
        overview,
        release_date,
        genres,
        runtime,
        vote_average,
        budget,
        revenue
    )
}