package com.example.moviesapp.feature.movies.interactor

import androidx.compose.runtime.MutableState
import com.example.moviesapp.core.interactor.UserCase
import com.example.moviesapp.core.viewstate.ViewState
import com.example.moviesapp.feature.movies.data.MovieServices
import com.example.moviesapp.feature.movies.data.model.MovieDetails
import com.example.moviesapp.feature.movies.viewstate.Loading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMovieDetails(private val movieId: Int) : UserCase() {
    override suspend fun run(coroutineScope: CoroutineScope, stateFlow: MutableState<ViewState>) {
        coroutineScope.launch {
            stateFlow.value = Loading

            MovieServices().movieDetails(movieId).enqueue(object : Callback<MovieDetails> {
                override fun onResponse(p0: Call<MovieDetails>, p1: Response<MovieDetails>) {
                    coroutineScope.launch {
                        stateFlow.value = getState(p1.body(), null)
                    }
                }

                override fun onFailure(p0: Call<MovieDetails>, p1: Throwable) {
                    coroutineScope.launch {
                        stateFlow.value = getState(null, p1.message)
                    }
                }
            })
        }
    }
}