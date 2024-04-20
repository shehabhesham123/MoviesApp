package com.example.moviesapp.feature.movies.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.feature.movies.data.model.Category

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey private val id: Int,
    private val name: String
) {
    fun toCategory() = Category(id, name)
}