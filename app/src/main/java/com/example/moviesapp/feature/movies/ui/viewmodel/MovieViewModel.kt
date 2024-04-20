package com.example.moviesapp.feature.movies.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.interactor.UserCase
import com.example.moviesapp.core.viewstate.ViewState
import com.example.moviesapp.feature.movies.viewstate.Idle
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val interactionChannel = Channel<UserCase>()
    val viewStates: MutableState<ViewState> = mutableStateOf(Idle)


    init {
        start()
    }

    private fun start() {
        viewModelScope.launch {
            interactionChannel.consumeAsFlow().collect {
                it(viewModelScope, viewStates)
            }
        }
    }
}