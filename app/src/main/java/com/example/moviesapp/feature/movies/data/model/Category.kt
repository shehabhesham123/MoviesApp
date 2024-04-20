package com.example.moviesapp.feature.movies.data.model

import com.google.gson.annotations.SerializedName

class Category(id: Int, name: String) {
    var id: Int = id
        private set
    var name: String = name
        private set
}

class CategoryList() {
    @SerializedName("genres")
    lateinit var list: MutableList<Category>
        private set
}