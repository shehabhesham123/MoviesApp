package com.example.moviesapp.feature.movies.interactor

import androidx.compose.runtime.MutableState
import com.example.moviesapp.core.interactor.UserCase
import com.example.moviesapp.core.viewstate.ViewState
import com.example.moviesapp.feature.movies.data.MovieServices
import com.example.moviesapp.feature.movies.data.model.CategoryList
import com.example.moviesapp.feature.movies.viewstate.Loading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCategories : UserCase() {
    override suspend fun run(coroutineScope: CoroutineScope, stateFlow: MutableState<ViewState>) {
        coroutineScope.launch {
            stateFlow.value = Loading

            MovieServices().categories()
                .enqueue(object : Callback<CategoryList> {
                    override fun onResponse(
                        p0: Call<CategoryList>,
                        p1: Response<CategoryList>
                    ) {
                        coroutineScope.launch {
                            stateFlow.value = getState(p1.body(), null)
                        }
                    }

                    override fun onFailure(p0: Call<CategoryList>, p1: Throwable) {
                        coroutineScope.launch {
                            stateFlow.value = getState(null, p1.message)
                        }
                    }
                })
        }
    }
}