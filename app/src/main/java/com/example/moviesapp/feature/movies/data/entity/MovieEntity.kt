package com.example.moviesapp.feature.movies.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.feature.movies.data.model.Movie


@Entity(tableName = "movie_table")
class MovieEntity(
    id: Int,
    title: String,
    release_date: String,
    poster_path: String,
    vote_average: Float
) {
    @PrimaryKey
    private var id: Int = id
    private var title: String = title
    private var release_date: String = release_date
    private var poster_path: String = poster_path
    private var vote_average: Float = vote_average

    fun toMovie() = Movie(id, title, release_date, poster_path, vote_average)
}