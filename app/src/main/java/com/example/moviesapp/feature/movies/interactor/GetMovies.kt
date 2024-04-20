package com.example.moviesapp.feature.movies.interactor

import androidx.compose.runtime.MutableState
import com.example.moviesapp.core.interactor.UserCase
import com.example.moviesapp.core.viewstate.ViewState
import com.example.moviesapp.feature.movies.data.MovieServices
import com.example.moviesapp.feature.movies.data.model.MovieList
import com.example.moviesapp.feature.movies.viewstate.Loading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class GetMovies(private val page: Int) : UserCase() {
    override suspend fun run(coroutineScope: CoroutineScope, stateFlow: MutableState<ViewState>) {
        coroutineScope.launch {
            stateFlow.value = Loading

            getApiMethod()
                .enqueue(object : Callback<MovieList> {
                    override fun onResponse(p0: Call<MovieList>, p1: Response<MovieList>) {
                        coroutineScope.launch {
                            stateFlow.value = getState(p1.body(), null)
                        }
                    }

                    override fun onFailure(p0: Call<MovieList>, p1: Throwable) {
                        coroutineScope.launch {
                            stateFlow.value = getState(null, p1.message)
                        }
                    }
                })
        }
    }

    open fun getApiMethod(): Call<MovieList> {
        return MovieServices().movies(page)
    }


}